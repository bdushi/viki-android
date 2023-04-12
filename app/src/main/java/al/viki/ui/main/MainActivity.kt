package al.viki.ui.main

import al.bruno.analytics.AnalyticsServiceProviders
import al.bruno.analytics.FacebookAnalyticsService
import al.bruno.analytics.events.APP_BUILD_TYPE
import al.bruno.analytics.events.APP_PACKAGE_NAME
import al.bruno.analytics.events.APP_VERSION_NAME
import al.bruno.core.interceptor.AuthorizationInterceptor
import al.bruno.core.interceptor.RefreshTokenInterceptor
import al.viki.BuildConfig
import al.viki.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.Entry
import al.viki.common.TOPIC
import al.viki.model.PropertyUi.Companion.bundleToPropertyUi
import al.viki.model.RequestUi.Companion.bundleToRequestUi
import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotifyAuthenticationChange {

    private val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var authorizationInterceptor: AuthorizationInterceptor

    @Inject
    lateinit var refreshTokenInterceptor: RefreshTokenInterceptor

    @Inject
    lateinit var analyticsServiceProviders: AnalyticsServiceProviders

    private val notification =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Firebase
                    .messaging
                    .subscribeToTopic(TOPIC)
                    .addOnCompleteListener { task ->
                        if (!task.isSuccessful)
                            Log.d(MainActivity::class.java.name, "Success")
                    }.addOnFailureListener { ex ->
                        Log.d(
                            MainActivity::class.java.name,
                            "Failure: ${ex.message.toString()}"
                        )
                    }
            } else {
                Snackbar
                    .make(
                        findViewById(android.R.id.content),
                        getString(R.string.permission_denied),
                        Snackbar.LENGTH_LONG
                    )
                    .setAction(R.string.settings) {
                        startActivity(
                            Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.parse("package:" + BuildConfig.APPLICATION_ID)
                            )
                        )
                    }.show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseInstallations.getInstance().id.addOnSuccessListener {
            Log.d("TAG", it)
        }
        analyticsServiceProviders
            .setDefaultEventParameters(
                Pair(APP_PACKAGE_NAME, BuildConfig.APPLICATION_ID),
                Pair(APP_VERSION_NAME, BuildConfig.VERSION_NAME),
                Pair(APP_BUILD_TYPE, BuildConfig.BUILD_TYPE),
            )
        authorizationInterceptor.setOnSessionListen {
            startActivity(
                Intent(this@MainActivity, AuthenticationActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                mainViewModel.token().collectLatest {
                    if (it != null) {
                        authorizationInterceptor.token = it
                        setContentView(R.layout.activity_main)
                        val navHostFragment =
                            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                        val navController = navHostFragment.navController
                        intent.extras?.let { bundle ->
                            if (bundle.getString("entry") == Entry.PROPERTY.name) {
                                navController.navigate(
                                    R.id.propertyDetailsFragment,
                                    bundleOf("property" to bundleToPropertyUi(bundle))
                                )
                            } else if (bundle.getString("entry") == Entry.REQUEST.name) {
                                navController.navigate(
                                    R.id.requestDetailsFragment,
                                    bundleOf("request" to bundleToRequestUi(bundle))
                                )
                            }
                        }

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            if (
                                ContextCompat.checkSelfPermission(
                                    this@MainActivity,
                                    POST_NOTIFICATIONS
                                ) == PackageManager.PERMISSION_GRANTED
                            ) {
                                Firebase
                                    .messaging
                                    .subscribeToTopic(TOPIC)
                                    .addOnCompleteListener { task ->
                                        if (!task.isSuccessful)
                                            Log.d(MainActivity::class.java.name, "Success")
                                    }.addOnFailureListener { ex ->
                                        Log.d(
                                            MainActivity::class.java.name,
                                            "Failure: ${ex.message.toString()}"
                                        )
                                    }

                            } else if (shouldShowRequestPermissionRationale(POST_NOTIFICATIONS)) {
                                // https://developer.android.com/training/permissions/requesting
                                MaterialAlertDialogBuilder(this@MainActivity)
                                    .setTitle(R.string.allow_access)
                                    .setMessage(R.string.allow_access_detail_location)
                                    .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                                        dialogInterface.dismiss()
                                        Firebase
                                            .messaging
                                            .subscribeToTopic(TOPIC)
                                            .addOnCompleteListener { task ->
                                                if (!task.isSuccessful)
                                                    Log.d(MainActivity::class.java.name, "Success")
                                            }.addOnFailureListener { ex ->
                                                Log.d(
                                                    MainActivity::class.java.name,
                                                    "Failure: ${ex.message.toString()}"
                                                )
                                            }
                                    }
                                    .setNegativeButton(R.string.cancel_title) { dialogInterface, _ -> dialogInterface.dismiss() }
                                    .show()
                            } else {
                                notification.launch(POST_NOTIFICATIONS)
                            }
                        } else {
                            Firebase
                                .messaging
                                .subscribeToTopic(TOPIC)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful)
                                        Log.d(MainActivity::class.java.name, "Success")
                                }.addOnFailureListener { ex ->
                                    Log.d(
                                        MainActivity::class.java.name,
                                        "Failure: ${ex.message.toString()}"
                                    )
                                }
                        }
                    } else {
                        startActivity(
                            Intent(this@MainActivity, AuthenticationActivity::class.java)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        )
                    }
                }
            }
        }
    }

    override fun onSignOut() {
        mainViewModel.clear()
        Firebase
            .messaging
            .unsubscribeFromTopic(TOPIC)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful)
                    Log.d(MainActivity::class.java.name, "Success")
            }.addOnFailureListener { ex ->
                Log.d(
                    MainActivity::class.java.name,
                    "Failure: ${ex.message.toString()}"
                )
            }
    }
}