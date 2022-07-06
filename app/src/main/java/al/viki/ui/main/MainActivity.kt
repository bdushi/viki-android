package al.viki.ui.main

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.authentication.AuthenticationActivity
import al.viki.ui.viki.Viki
import al.viki.ui.home.VikiViewModel
import al.viki.ui.property.PropertyViewModel
import al.viki.ui.theme.VikiTheme
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private val vikiViewModel: VikiViewModel by viewModels()
    private val propertyViewModel: PropertyViewModel by viewModels()

    @Inject
    lateinit var authInterceptor: AuthInterceptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            mainViewModel.token().collectLatest {
                it?.let {
                    authInterceptor.token = it
                    setContent {
                        VikiTheme {
                            // A surface container using the 'background' color from the theme
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                Viki(
                                    vikiViewModel = vikiViewModel,
                                    propertyViewModel = propertyViewModel,
                                    logOut = {
                                        startActivity(Intent(this@MainActivity, AuthenticationActivity::class.java))
                                        finish()
                                    }
                                )
                            }
                        }
                    }
                } ?: run {
                    startActivity(Intent(this@MainActivity, AuthenticationActivity::class.java))
                }
            }
        }
    }
}