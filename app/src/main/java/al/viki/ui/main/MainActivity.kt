package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.R
import al.viki.authentication.AuthenticationActivity
import al.viki.authentication.NotifyAuthenticationChange
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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