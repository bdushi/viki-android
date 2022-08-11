package al.viki.authentication.register

import al.bruno.core.State
import al.viki.authentication.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityRegisterBinding
import al.bruno.core.data.source.model.response.ValidationResponse
import al.bruno.core.data.source.model.response.ValidationStatus
import al.viki.foundation.common.collectLatestFlow
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    private val requestGallery =
        registerForActivityResult(
            object : ActivityResultContract<Intent, Uri?>() {
                override fun createIntent(context: Context, input: Intent): Intent {
                    return input
                }

                override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
                    return if (resultCode == Activity.RESULT_OK) {
                        intent?.data
                    } else {
                        null
                    }
                }
            }
        ) { uri: Uri? ->
            registerViewModel.setPhotoUi(uri)
        }

    private val requestFilePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(Manifest.permission.READ_EXTERNAL_STORAGE, false) or
                        it.getOrDefault(Manifest.permission.WRITE_EXTERNAL_STORAGE, false) -> {
                    val intent =
                        Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                    intent.type = "image/*"
                    requestGallery.launch(intent)
                }
                else -> {
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
                                    Uri.parse("package:al.viki")
                                )
                            )
                        }.show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.registerViewModel = registerViewModel
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.new_photo -> {
                    when (PackageManager.PERMISSION_GRANTED) {
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        ),
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ) -> {
                            val intent = Intent()
                            intent.action = Intent.ACTION_GET_CONTENT
                            intent.type = "image/*"
                            requestGallery.launch(intent)
                        }
                        else -> {
                            requestFilePermissions.launch(
                                arrayOf(
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                                )
                            )
                        }
                    }
                    true
                }
                else ->
                    false
            }
        }

        binding.setOnClick {
            intent.data?.let {
                registerViewModel.register(
                    it.getQueryParameter("authority").toString().toLong(),
                    it.getQueryParameter("token").toString()
                )
            } ?: run {
                Snackbar.make(
                    binding.root,
                    "Invitation has been expired, Please request New One",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        intent.data?.let {
            registerViewModel.email.value = it.getQueryParameter("email").toString()
            registerViewModel.validateToken(it.getQueryParameter("token").toString())
        } ?: run {
            Snackbar.make(
                binding.root,
                "Invitation has been expired, Please request New One",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        collectLatestFlow(registerViewModel.validate) {
            when (it) {
                is State.Error -> {
                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                    Snackbar.make(
                        binding.root,
                        al.viki.foundation.R.string.error,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is State.Success -> {
                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                    when (it.t) {
                        ValidationResponse.EXPIRED,
                        ValidationResponse.NOT_FOUND ->
                            MaterialAlertDialogBuilder(this)
                                .setIcon(al.viki.foundation.R.drawable.ic_round_warning_amber)
                                .setCancelable(false)
                                .setTitle("Token has been expired")
                                .setMessage("Please contact your administrator to send new invitation")
                                .setPositiveButton("Ok") { d, i ->
                                    d.dismiss()
                                    finish()
                                }
                                .show()
                        else -> {

                        }
                    }
                }
                is State.Loading -> {
                    binding.registerLayout.visibility = View.GONE
                    binding.registerLayoutProgress.visibility = View.VISIBLE
                }
                else -> {
                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                }
            }
        }

        collectLatestFlow(registerViewModel.register) {
            when (it) {
                is State.Success -> {
                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                    if (it.t != null) {
                        val uploadWorkRequest: WorkRequest =
                            OneTimeWorkRequestBuilder<UploadProfilePictureWorker>()
                                .setInputData(
                                    Data
                                        .Builder()
                                        .putString("USERNAME", it.t?.username)
                                        .putString(
                                            "PHOTO_UI",
                                            registerViewModel.photo.value.toString()
                                        )
                                        .build()
                                )
                                .build()
                        WorkManager
                            .getInstance(this)
                            .enqueue(uploadWorkRequest)
                        startActivity(
                            packageManager.getLaunchIntentForPackage(
                                packageName
                            )
                        )
                        finish()
                    }
                }
                is State.Error -> {
                    Snackbar.make(
                        binding.root,
                        al.viki.foundation.R.string.error,
                        Snackbar.LENGTH_SHORT
                    ).show()

                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                }
                is State.Loading -> {
                    binding.registerLayout.visibility = View.GONE
                    binding.registerLayoutProgress.visibility = View.VISIBLE
                }
                else -> {
                    binding.registerLayout.visibility = View.VISIBLE
                    binding.registerLayoutProgress.visibility = View.GONE
                }
            }
        }
    }
}