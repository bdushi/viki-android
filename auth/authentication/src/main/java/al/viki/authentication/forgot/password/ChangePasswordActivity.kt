package al.viki.authentication.forgot.password

import al.bruno.common.ACCESS_TOKEN
import al.bruno.common.TOKEN
import al.bruno.core.State
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityChangePasswordBinding
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import al.viki.authentication.R
import al.viki.foundation.common.collectLatestFlow
import android.content.ComponentName

@AndroidEntryPoint
class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangePasswordBinding
    private val passwordViewModel: PasswordViewModel by viewModels ()
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
        intent.data?.getQueryParameter(TOKEN)?.let {
            passwordViewModel.validateToken(it)
        } ?: run {
            handler.postDelayed(runnable, 3000)
            Snackbar.make(
                binding.root,
                R.string.password_expire_token_error,
                Snackbar.LENGTH_SHORT
            )
                .setAction(R.string.forgot_password) {
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