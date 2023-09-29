package al.viki.authentication.forgot.password

import al.bruno.common.isValidEmail
import al.bruno.core.State
import al.viki.authentication.R
import al.viki.authentication.databinding.ActivityForgotPasswordBinding
import al.viki.foundation.common.gone
import al.viki.foundation.common.isEmpty
import al.viki.foundation.common.isNotEmpty
import al.viki.foundation.common.visible
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotPasswordActivity : AppCompatActivity() {
    private val passwordViewModel: PasswordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.forgotPasswordTopAppBar.setNavigationOnClickListener {
            finish()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                passwordViewModel.reset.collectLatest { response ->
                    when (response) {
                        is State.Error -> {
                            binding.forgotPasswordProgress.gone()
                            response.error?.let {
                                Snackbar.make(
                                    findViewById(android.R.id.content),
                                    it, Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }
                        is State.Success -> {
                            binding.forgotPasswordProgress.gone()
                            if (response.t == true) {
                                finish()
                            }
                        }
                        is State.Loading -> {
                            binding.forgotPasswordProgress.visible()
                        }
                    }
                }
            }
        }
        binding.edForgotPasswordEmail.addTextChangedListener {
            binding.btForgotPassword.isEnabled = binding.edForgotPasswordEmail.isNotEmpty() && isValidEmail(it) != true
            binding.forgotPasswordEmailInputLayout.error = getString(R.string.invalid_email)
            binding.forgotPasswordEmailInputLayout.isErrorEnabled = isValidEmail(it) == true
        }
        binding.btForgotPassword.setOnClickListener {
            passwordViewModel.resetPassword(binding.edForgotPasswordEmail.text.toString())
        }
    }
}