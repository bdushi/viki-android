package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.R
import al.viki.authentication.auth.NotifyAuthenticationChange
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotifyAuthenticationChange {
    private val mainViewModel: MainViewModel by viewModels()
    @Inject
    lateinit var authInterceptor: AuthInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycleScope.launch {
//            mainViewModel.token().collectLatest {
//                if(it != null) {
//                    authInterceptor.token = it
//                } else {
//                    startActivity(
//                        Intent(this@MainActivity, AuthenticationActivity::class.java)
//                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                    )
//                }
//            }
//        }
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