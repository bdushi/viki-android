package al.viki.ui.details

import al.bruno.adapter.CustomListAdapter
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.DetailsPropertyPhotoItemBinding
import al.viki.model.ImagesUi
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.google.android.material.snackbar.Snackbar

/**
 * https://developer.android.com/training/sharing/send#java
 */

abstract class DetailsFragment<T: ViewDataBinding> : Fragment() {
    protected var _binding: T? = null
    protected val binding get() = _binding
    protected val photoAdapter =
        CustomListAdapter<ImagesUi, DetailsPropertyPhotoItemBinding>(
            R.layout.details_property_photo_item, { t, vm ->
                vm.photo = t
            },
            object : DiffUtil.ItemCallback<ImagesUi>() {
                override fun areItemsTheSame(oldItem: ImagesUi, newItem: ImagesUi): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: ImagesUi, newItem: ImagesUi): Boolean {
                    return oldItem.photo == newItem.photo
                }
            }
        )
    protected val startForResult =
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
            uri?.let {
                // TODO
            }
        }

    protected val requestFilePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    Manifest.permission.READ_EXTERNAL_STORAGE, false
                ) -> {
                    val intent =
                        Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                    intent.type = "image/*"
                    startForResult.launch(intent)
                }
                else -> {
                    binding?.let { view ->
                        Snackbar
                            .make(
                                view.root,
                                getString(R.string.permission_denied),
                                Snackbar.LENGTH_LONG
                            )
                            .setAction(R.string.settings) {
                                startActivity(
                                    Intent(
                                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                        Uri.parse("package:" + BuildConfig.APPLICATION_ID)
                                    )
                                )
                            }.show()
                    }
                }
            }
        }
}