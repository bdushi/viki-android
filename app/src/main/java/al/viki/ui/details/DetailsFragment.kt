package al.viki.ui.details

import al.bruno.adapter.CustomListAdapter
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.DetailsPropertyPhotoItemBinding
import al.viki.model.PhotoUi
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

abstract class DetailsFragment<T: ViewDataBinding> : Fragment() {
    protected var _binding: T? = null
    protected val binding get() = _binding
    protected val photoAdapter =
        CustomListAdapter<PhotoUi, DetailsPropertyPhotoItemBinding>(
            R.layout.details_property_photo_item, { t, vm ->
                vm.photo = t
            },
            object : DiffUtil.ItemCallback<PhotoUi>() {
                override fun areItemsTheSame(oldItem: PhotoUi, newItem: PhotoUi): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: PhotoUi, newItem: PhotoUi): Boolean {
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
            val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
            uri?.let {
                requireActivity().contentResolver.query(
                    it,
                    filePathColumn,
                    null,
                    null,
                    null
                )?.let { cursor ->
                    // propertyViewModel.photoUi(cursor, filePathColumn)
                }
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