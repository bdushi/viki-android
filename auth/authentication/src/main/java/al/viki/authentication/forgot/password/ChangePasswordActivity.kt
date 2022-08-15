package al.viki.authentication.forgot.password

import al.bruno.core.State
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityChangePasswordBinding
import al.viki.foundation.common.collectLatestFlow
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
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = {
        startActivity(
            Intent(
                this@ChangePasswordActivity,
                AuthenticationActivity::class.java
            )
        )
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changePasswordTopAppBar.setNavigationOnClickListener {
            startActivity(
                Intent(
                    this@ChangePasswordActivity,
                    AuthenticationActivity::class.java
                )
            )
            finish()
        }

        binding.lifecycleOwner = this
        binding.passwordViewModel = passwordViewModel

        intent.data?.getQueryParameter("token")?.let {
            passwordViewModel.validateToken(it)
        } ?: run {
//            handler.postDelayed(runnable, 3000)
            Snackbar.make(
                binding.root,
                "Token is not valid anymore, Generate new One",
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
        }

        collectLatestFlow(passwordViewModel.change) {
            when (it) {
                is State.Error -> it.error?.let { error ->
                    Snackbar.make(
                        binding.root,
                        error,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is State.Success -> {
                    if (it.t == true) {
                        startActivity(
                            packageManager.getLaunchIntentForPackage(
                                packageName
                            )
                        )
                        finish()
                    }
                }
                is State.Loading -> {

                }
            }
        }


        collectLatestFlow(passwordViewModel.validate) {
            when (it) {
                is State.Error ->
                    it.error?.let { error ->
                        Snackbar.make(
                            binding.root,
                            error,
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                is State.Loading -> {

                }
                is State.Success -> {

                }
            }
        }
    }
}