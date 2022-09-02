package al.viki.authentication.forgot.password

import al.bruno.core.State
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityChangePasswordBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.foundation.root.RootActivity
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class ChangePasswordActivity : RootActivity() {
    private val passwordViewModel: PasswordViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[PasswordViewModel::class.java]
    }
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
                        startActivity(Intent().setComponent(ComponentName("al.viki", "al.viki.ui.main.MainActivity")))
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