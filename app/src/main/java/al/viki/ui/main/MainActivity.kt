package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.TOKEN
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotifyAuthenticationChange {
    private val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var authInterceptor: AuthInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            mainViewModel.token().collectLatest {
                val token: String? = it[stringPreferencesKey(TOKEN)]
                if(token != null) {
                    authInterceptor.token = token
                } else {
                    startActivity(
                        Intent(this@MainActivity, AuthenticationActivity::class.java)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                }
            }
        }
        setContentView(R.layout.activity_main)
    }

    override fun onSignOut() {
        mainViewModel.clear()
//        startActivity(
//            Intent(this@MainActivity, AuthenticationActivity::class.java)
//                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        )
    }
}