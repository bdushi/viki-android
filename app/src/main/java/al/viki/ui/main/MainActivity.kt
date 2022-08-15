package al.viki.ui.main

import al.bruno.core.interceptor.AuthorizationInterceptor
import al.viki.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.TOKEN
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotifyAuthenticationChange {
    private val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var authorizationInterceptor: AuthorizationInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                mainViewModel.token().collectLatest {
                    val token: String? = it[stringPreferencesKey(TOKEN)]
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