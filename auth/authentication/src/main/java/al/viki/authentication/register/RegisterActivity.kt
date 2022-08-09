package al.viki.authentication.register

import al.bruno.core.State
import al.viki.authentication.R
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.databinding.ActivityRegisterBinding
import al.viki.foundation.common.collectLatestFlow
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val registerViewModel: RegisterViewModel by viewModels()
    private val requestGallery =
        registerForActivityResult(
            object : ActivityResultContract<Intent, Uri?>() {
                override fun createIntent(context: Context, input: Intent): Intent {
                    return input
                }

                override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
                    return if (resultCode == Activity.RESULT_OK) {
                        intent?.data
                    } else {
                        null
                    }
                }
            }
        ) { uri: Uri? ->
            registerViewModel.setPhotoUi(uri)
        }

    private val requestFilePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(Manifest.permission.READ_EXTERNAL_STORAGE, false) or
                        it.getOrDefault(Manifest.permission.WRITE_EXTERNAL_STORAGE, false) -> {
                    val intent =
                        Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                    intent.type = "image/*"
                    requestGallery.launch(intent)
                }
                else -> {
                    Snackbar
                        .make(
                            findViewById(android.R.id.content),
                            getString(R.string.permission_denied),
                            Snackbar.LENGTH_LONG
                        )
                        .setAction(R.string.settings) {
                            startActivity(
                                Intent(
                                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                    Uri.parse("package:al.viki")
                                )
                            )
                        }.show()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.registerViewModel = registerViewModel
        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.new_photo -> {
                    when (PackageManager.PERMISSION_GRANTED) {
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        ),
                        ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ) -> {
                            val intent = Intent()
                            intent.action = Intent.ACTION_GET_CONTENT
                            intent.type = "image/*"
                            requestGallery.launch(intent)
                        }
                        else -> {
                            requestFilePermissions.launch(
                                arrayOf(
                                    Manifest.permission.READ_EXTERNAL_STORAGE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                                )
                            )
                        }
                    }
                    true
                }
                else ->
                    false
            }
        }

        binding.setOnClick {
            intent.data?.let {
                registerViewModel.register(
                    it.getQueryParameter("authority").toString().toLong()
                )
            } ?: run {
                Snackbar.make(
                    binding.root,
                    "Token has been expired, Please request New One",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        intent.data?.let {
            registerViewModel.email.value = it.getQueryParameter("email").toString()
        } ?: run {
            Snackbar.make(
                binding.root,
                "Token has been expired, Please request New One",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        collectLatestFlow(registerViewModel.register) {
            when(it) {
                is State.Success -> {
                    if(it.t != null) {
                        val uploadWorkRequest: WorkRequest =
                            OneTimeWorkRequestBuilder<UploadProfilePictureWorker>()
                                .setInputData(
                                    Data
                                        .Builder()
                                        .putString("USERNAME", it.t?.username)
                                        .putString(
                                            "PHOTO_UI",
                                            registerViewModel.photo.value.toString()
                                        )
                                        .build()
                                )
                                .build()
                        WorkManager
                            .getInstance(this)
                            .enqueue(uploadWorkRequest)
                        startActivity(Intent(this@RegisterActivity, AuthenticationActivity::class.java))
                        finish()
                    }
                }
                is State.Loading -> {

                }
                else -> {
                    Snackbar.make(
                        binding.root,
                        al.viki.foundation.R.string.error,
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}