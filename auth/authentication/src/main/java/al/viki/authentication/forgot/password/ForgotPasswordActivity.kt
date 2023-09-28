package al.viki.authentication.forgot.password

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordActivity : AppCompatActivity() {
//    private val passwordViewModel: PasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.lifecycleOwner = this
//        binding.passwordViewModel = passwordViewModel
//        binding.forgotPasswordTopAppBar.setNavigationOnClickListener {
//            finish()
//        }
//
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.CREATED) {
//                passwordViewModel.reset.collectLatest { response ->
//                    when (response) {
//                        is State.Error -> response.error?.let {
//                            Snackbar.make(
//                                findViewById(android.R.id.content),
//                                it, Snackbar.LENGTH_SHORT
//                            ).show()
//                        }
//                        is State.Success -> {
//                            if (response.t == true) {
//                                finish()
//                            }
//                        }
//                        else -> {
//
//                        }
//                    }
//                }
//            }
//        }
    }
}