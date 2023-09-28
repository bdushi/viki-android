package al.viki.authentication.auth

import al.bruno.core.State
import al.viki.authentication.databinding.ActivityAuthenticationBinding
import al.viki.authentication.forgot.password.ForgotPasswordActivity
import al.viki.authentication.register.RegisterActivity
import al.viki.core.model.request.AuthRequest
import al.viki.foundation.common.gone
import al.viki.foundation.common.isNotEmpty
import al.viki.foundation.common.visible
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthenticationActivity : AppCompatActivity() {
    private val authenticationViewModel: AuthenticationViewModel by viewModels()
    private lateinit var binding: ActivityAuthenticationBinding
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
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBackPressedDispatcher.addCallback {
            // Disable BackPress for AuthenticationActivity
        }

        binding.tvRequestNewPassword.setOnClickListener {
            startActivity(Intent(this@AuthenticationActivity, ForgotPasswordActivity::class.java))
        }
        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this@AuthenticationActivity, RegisterActivity::class.java))
        }
        binding.btnLogin.setOnClickListener {
            authenticationViewModel.auth(AuthRequest(binding.usernameInput.text.toString(), binding.passwordInput.text.toString()))
        }

        binding.usernameInput.addTextChangedListener {
            binding.btnLogin.isEnabled = (binding.usernameInput.isNotEmpty() && binding.passwordInput.isNotEmpty())
        }
        binding.passwordInput.addTextChangedListener {
            binding.btnLogin.isEnabled = (binding.usernameInput.isNotEmpty() && binding.passwordInput.isNotEmpty())
        }
        binding.passwordInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                authenticationViewModel.auth(AuthRequest(binding.usernameInput.text.toString(), binding.passwordInput.text.toString()))
            }
            return@setOnEditorActionListener false
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                authenticationViewModel.authentication.collect {
                    when (val response = it) {
                        is State.Error ->  {
                            binding.pgLogin.gone()
                            binding.authLayout.visible()
                            response.error?.let { error ->
                                Snackbar.make(
                                    findViewById(android.R.id.content),
                                    error,
                                    Snackbar.LENGTH_SHORT
                                ).show()
                        }

                        }

                        is State.Success -> {
                            binding.pgLogin.gone()
                            binding.authLayout.visible()
                            if (response.t != null) {
                                startActivity(
                                    Intent().setComponent(
                                        ComponentName(
                                            packageName,
                                            "al.viki.ui.main.MainActivity"
                                        )
                                    )
                                )
                                finish()
                            }
                        }
                        State.Loading -> {
                            binding.pgLogin.visible()
                            binding.authLayout.gone()
                        }
                    }
                }
            }
        }
    }
}
