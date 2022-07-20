package al.viki.authentication

import al.bruno.core.State
import al.viki.authentication.databinding.ActivityAuthenticationBinding
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthenticationActivity : AppCompatActivity() {
    private val authenticationViewModel: AuthenticationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
//        DaggerAuthComponent.builder()
//            .context(this)
//            .appDependencies(
//                EntryPointAccessors.fromApplication(
//                    this,
//                    AuthModuleDependencies::class.java
//                )
//            )
//            .build()
//            .inject(this)
        super.onCreate(savedInstanceState)
        val binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.auth = authenticationViewModel
        setContentView(binding.root)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                authenticationViewModel.authentication.collectLatest { response ->
                    when (response) {
                        is State.Error -> response.error?.let {
                            Snackbar.make(
                                findViewById(android.R.id.content),
                                it, Snackbar.LENGTH_SHORT
                            ).show()
                        }
                        is State.Unauthorized -> {
                            Snackbar.make(
                                findViewById(android.R.id.content),
                                R.string.unauthorized,
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                        is State.Success -> {
                            finish()
                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        // Disable BackPress for AuthenticationActivity
    }
}
