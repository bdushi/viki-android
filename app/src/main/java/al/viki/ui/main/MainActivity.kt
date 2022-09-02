package al.viki.ui.main

import al.bruno.core.interceptor.AuthorizationInterceptor
import al.bruno.core.interceptor.RefreshTokenInterceptor
import al.viki.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.ACCESS_TOKEN
import al.viki.foundation.root.RootActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : RootActivity(), NotifyAuthenticationChange {
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[MainViewModel::class.java]
    }
    @Inject
    lateinit var authorizationInterceptor: AuthorizationInterceptor
    @Inject
    lateinit var refreshTokenInterceptor: RefreshTokenInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authorizationInterceptor.setOnSessionListen {
            startActivity(
                Intent(this@MainActivity, AuthenticationActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            )
            finish()
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                mainViewModel.token().collectLatest {
                    val token = it[stringPreferencesKey(ACCESS_TOKEN)]
                    if(token != null) {
                        authorizationInterceptor.token = token
                        setContentView(R.layout.activity_main)
                    } else {
                        startActivity(
                            Intent(this@MainActivity, AuthenticationActivity::class.java)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        )
                        finish()
                    }
                }
            }
        }
    }

    override fun onSignOut() {
        mainViewModel.clear()
    }
}