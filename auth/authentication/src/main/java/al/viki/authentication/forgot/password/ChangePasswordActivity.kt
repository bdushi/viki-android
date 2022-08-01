package al.viki.authentication.forgot.password

import al.bruno.core.State
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityChangePasswordBinding
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
class ChangePasswordActivity : AppCompatActivity() {
    private val passwordViewModel: PasswordViewModel by viewModels()
    private val runnable = {
        startActivity(
            Intent(
                this@ChangePasswordActivity,
                AuthenticationActivity::class.java
            )
        )
        finish()
    }

    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changePasswordTopAppBar.setNavigationOnClickListener {
            finish()
        }

        binding.lifecycleOwner = this
        binding.passwordViewModel = passwordViewModel
        intent.data?.getQueryParameter("token")?.let {
            passwordViewModel.validateToken(it)
        } ?: run {
            Snackbar.make(
                binding.root,
                "Token is not valid, Generate new One",
                Snackbar.LENGTH_SHORT
            )
                .setAction("Forgot Password") {
                    handler.removeCallbacks(runnable)
                    startActivity(
                        Intent(
                            this@ChangePasswordActivity,
                            ForgotPasswordActivity::class.java
                        )
                    )
                    finish()
                }.show()
            handler.postDelayed(runnable, 3000)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                passwordViewModel.change.collectLatest { response ->
                    when(response) {
                        is State.Error -> response.error?.let {
                            Snackbar.make(
                                binding.root,
                                it, Snackbar.LENGTH_SHORT
                            ).show()
                        }
                        is State.Success -> {
                            if(response.t == true) {
                                startActivity(
                                    packageManager.getLaunchIntentForPackage(
                                        packageName
                                    )
                                )
                                finish()
                            }
                        }
                        is State.Unauthorized -> {
                            Snackbar.make(
                                binding.root,
                                "Token has been expired, Generate new One",
                                Snackbar.LENGTH_SHORT
                            ).setAction("Forgot Password") {
                                handler.removeCallbacks(runnable)
                                startActivity(
                                    Intent(
                                        this@ChangePasswordActivity,
                                        ForgotPasswordActivity::class.java
                                    )
                                )
                                finish()
                            }.show()
                        }
                        else -> {

                        }
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                passwordViewModel.validate.collectLatest { response ->
                    when (response) {
                        is State.Error ->
                            response.error?.let {
                                Snackbar.make(
                                    findViewById(android.R.id.content),
                                    it, Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        is State.Unauthorized -> {
//                            handler.postDelayed(runnable, 3000)
                            Snackbar.make(
                                findViewById(android.R.id.content),
                                "Token has been expired, Generate new One",
                                Snackbar.LENGTH_SHORT
                            ).setAction("Forgot Password") {
                                handler.removeCallbacks(runnable)
                                startActivity(
                                    Intent(
                                        this@ChangePasswordActivity,
                                        ForgotPasswordActivity::class.java
                                    )
                                )
                                finish()
                            }.show()
                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }
}