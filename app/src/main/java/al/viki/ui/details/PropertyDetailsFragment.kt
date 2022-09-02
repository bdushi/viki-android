package al.viki.ui.details

import al.bruno.core.State
import al.viki.R
import al.viki.databinding.FragmentPropertyDetailsBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.PhotoUi
import al.viki.ui.account.RequestNewAccountViewModel
import al.viki.ui.home.HomeViewModel
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

/**
 * https://cloud.google.com/storage/docs/json_api/v1/objects/list
 */

class PropertyDetailsFragment : DetailsFragment<FragmentPropertyDetailsBinding>() {
    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[HomeViewModel::class.java]
    }
    private val args: PropertyDetailsFragmentArgs by navArgs()
    private var mapFragment: SupportMapFragment? = null
    private val isPhotoNotEmpty = ObservableBoolean(false)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPropertyDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property = args.property
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        mapFragment =
            childFragmentManager.findFragmentById(R.id.details_property_location_in_map) as? SupportMapFragment
        mapFragment?.getMapAsync {
            it.mapType = GoogleMap.MAP_TYPE_SATELLITE
            it.uiSettings.isZoomControlsEnabled = true
            it.uiSettings.setAllGesturesEnabled(true)
            it.uiSettings.isCompassEnabled = true
            val latLng = LatLng(property.latitude, property.longitude)
            val cameraPosition =
                CameraPosition.Builder().target(latLng).zoom(15f).bearing(20f).build()
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
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.edit -> {
                    true
                }
                R.id.share -> {
                    true
                }
                R.id.delete -> {


                    MaterialAlertDialogBuilder(requireContext())
                        .setIcon(al.viki.foundation.R.drawable.ic_outline_warning_amber)
                        .setTitle(R.string.delete_property_title)
                        .setMessage(getString(R.string.delete_messages, property.title))
                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                            homeViewModel.deleteProperty(property.id)
                            dialogInterface.dismiss()
                        }.setNegativeButton(R.string.cancel_title) { dialogInterface, _ ->
                            dialogInterface.dismiss()
                        }
                        .setCancelable(false)
                        .show()
                    true
                }
                else -> false
            }
        }
        collectLatestFlow(homeViewModel.delete) {
            when (it) {
                is State.Error -> {

                }
                is State.Loading -> {

                }
                is State.Success -> {
                    if (it.t == true) {
                        findNavController().popBackStack()
                    }
                }
            }
        }
        Firebase
            .storage
            .reference
            .child("photos/${property.id}")
            .listAll()
            .addOnSuccessListener {
                val photoUiList = it.items.map { storageReference ->
                    PhotoUi("https://firebasestorage.googleapis.com/v0/b/viki-135b4.appspot.com/o/photos%2F${args.property.id}%2F${storageReference.name}?alt=media")
                }
                if (photoUiList.isNotEmpty()) {
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