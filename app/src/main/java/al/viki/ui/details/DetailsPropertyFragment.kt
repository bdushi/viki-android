package al.viki.ui.details

import al.bruno.adapter.CustomListAdapter
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.DetailsPropertyPhotoItemBinding
import al.viki.databinding.FragmentDetailsPropertyBinding
import al.viki.databinding.NewPropertyPhotoItemBinding
import al.viki.model.PhotoUi
import al.viki.ui.property.PropertyViewModel
import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DiffUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * https://cloud.google.com/storage/docs/json_api/v1/objects/list
 */

@AndroidEntryPoint
class DetailsPropertyFragment : Fragment() {
    private val propertyViewModel: PropertyViewModel by viewModels()
    private val args: DetailsPropertyFragmentArgs by navArgs()
    private var _binding: FragmentDetailsPropertyBinding? = null
    private var mapFragment: SupportMapFragment? = null
    private val binding get() = _binding
    private val photoAdapter =
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
    val isPhotoNotEmpty = ObservableBoolean(false)
    private val requestFilePermissions =
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
                    binding?.let { newPropertyView ->
                        Snackbar
                            .make(
                                newPropertyView.detailsPropertyRoot,
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
    private val startForResult =
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
                    propertyViewModel.photoUi(cursor, filePathColumn)
                }
            }
        }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsPropertyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val property = args.property
        mapFragment = childFragmentManager.findFragmentById(R.id.details_property_location_in_map) as? SupportMapFragment
        mapFragment?.getMapAsync {
            val latLng = LatLng(property.latitude, property.latitude)
            val cameraPosition = CameraPosition.Builder().target(latLng).zoom(10f).bearing(20f).build()
            it.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
            it.addMarker(
                MarkerOptions()
                    .position(
                        latLng
                    )
            )
        }
        binding?.onClick = View.OnClickListener {
            when (PackageManager.PERMISSION_GRANTED) {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
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
                    requestFilePermissions.launch(
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                        )
                    )
                }
            }
        }
        binding?.isNotEmpty = isPhotoNotEmpty
        binding?.adapter = photoAdapter
        binding?.property = property
        Firebase
            .storage
            .reference
            .child("photos/${property.id}")
            .listAll()
            .addOnSuccessListener {
                val photoUiList = it.items.map { storageReference ->
                    PhotoUi("https://firebasestorage.googleapis.com/v0/b/viki-135b4.appspot.com/o/photos%2F${args.property.id}%2F${storageReference.name}?alt=media")
                }
                if(photoUiList.isNotEmpty()) {
                    isPhotoNotEmpty.set(false)
                    photoAdapter.submitList(photoUiList)
                    binding?.let { detailsProperty ->
                        TabLayoutMediator(
                            detailsProperty.detailsPropertyItemDotIndicator,
                            detailsProperty.detailsPropertyItem
                        ) { tab, position ->
                            //Some implementation
                        }.attach()
                    }
                } else {
                    isPhotoNotEmpty.set(true)
                }
            }.addOnFailureListener {
                isPhotoNotEmpty.set(true)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mapFragment = null
    }
}