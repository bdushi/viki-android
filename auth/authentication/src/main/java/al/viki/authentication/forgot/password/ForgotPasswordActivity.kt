package al.viki.authentication.forgot.password

import al.bruno.core.State
import al.viki.authentication.databinding.ActivityForgotPasswordBinding
import al.viki.foundation.root.RootActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ForgotPasswordActivity : RootActivity() {
    private val passwordViewModel: PasswordViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[PasswordViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.passwordViewModel = passwordViewModel
        binding.forgotPasswordTopAppBar.setNavigationOnClickListener {
            finish()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                passwordViewModel.reset.collectLatest { response ->
                    when (response) {
                        is State.Error -> response.error?.let {
                            Snackbar.make(
                                findViewById(android.R.id.content),
                                it, Snackbar.LENGTH_SHORT
                            ).show()
                        }
                        is State.Success -> {
                            if (response.t == true) {
                                finish()
                            }
                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }
}