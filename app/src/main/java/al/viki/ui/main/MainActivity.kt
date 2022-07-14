package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.authentication.AuthenticationActivity
import al.viki.authentication.NotifyAuthenticationChange
import al.viki.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NotifyAuthenticationChange {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var authInterceptor: AuthInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            mainViewModel.token().collectLatest {
                it?.let {
                    authInterceptor.token = it
                    binding = ActivityMainBinding.inflate(layoutInflater)
                    setContentView(binding.root)
                } ?: run {
                    startActivity(Intent(this@MainActivity, AuthenticationActivity::class.java))
                }
            }
        }
    }

    override fun onSignOut() {
        mainViewModel.clear()
        startActivity(Intent(this@MainActivity, AuthenticationActivity::class.java))
    }
}