package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.R
import al.viki.authentication.AuthenticationActivity
import al.viki.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
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
                    val navHostFragment: NavHostFragment =
                        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                    setContentView(binding.root)
                    val navController = navHostFragment.navController
//                    appBarConfiguration = AppBarConfiguration(
//                        setOf(
//                            R.id.nav_home,
//                            R.id.nav_settings,
//                            R.id.nav_imprint
//                        )
//                    )
//                    setupActionBarWithNavController(navController, appBarConfiguration)
                } ?: run {
                    startActivity(Intent(this@MainActivity, AuthenticationActivity::class.java))
                }
            }
        }
    }
}