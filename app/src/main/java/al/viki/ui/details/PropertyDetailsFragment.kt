package al.viki.ui.details

import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.FragmentPropertyDetailsBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.PropertiesUi
import al.viki.model.PropertyUi
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
import dagger.hilt.android.AndroidEntryPoint

/**
 * https://cloud.google.com/storage/docs/json_api/v1/objects/list
 */

@AndroidEntryPoint
class PropertyDetailsFragment : DetailsFragment<FragmentPropertyDetailsBinding>() {
    private val detailsViewModel: DetailsViewModel by viewModels()
    private val homeViewModel: HomeViewModel by viewModels()
    private val args: PropertyDetailsFragmentArgs by navArgs()
    private var mapFragment: SupportMapFragment? = null
    private val isPhotoNotEmpty = ObservableBoolean(false)
    private var propertiesUi: PropertiesUi? = null
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
        detailsViewModel.property(args.id)
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        mapFragment =
            childFragmentManager.findFragmentById(R.id.details_property_location_in_map) as SupportMapFragment

        binding?.isNotEmpty = isPhotoNotEmpty
        binding?.adapter = photoAdapter
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
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.share -> {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "${BuildConfig.HOST_NAME}property/${args.id}")
                        type = "text/plain"
                    }
                    startActivity(Intent.createChooser(sendIntent, getString(R.string.app_name)))
                    true
                }
                R.id.delete -> {
                    MaterialAlertDialogBuilder(requireContext())
                        .setIcon(al.viki.foundation.R.drawable.ic_outline_warning_amber)
                        .setTitle(R.string.delete_property_title)
                        .setMessage(getString(R.string.delete_messages, propertiesUi?.title))
                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                            homeViewModel.deleteProperty(args.id)
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
        binding?.propertyDetailsErrorRefresh?.setOnClickListener {
            detailsViewModel.property(args.id)
        }
        collectLatestFlow(detailsViewModel.properties) {
            when (it) {
                is State.Error -> {
                    binding?.propertyDetailsError?.visibility = View.VISIBLE
                    binding?.propertyDetails?.visibility = View.GONE
                    binding?.propertyDetailsProgressIndicator?.visibility = View.GONE
                }
                is State.Loading -> {
                    binding?.propertyDetailsProgressIndicator?.visibility = View.VISIBLE
                    binding?.propertyDetailsError?.visibility = View.GONE
                    binding?.propertyDetails?.visibility = View.GONE
                }
                is State.Success -> {
                    binding?.propertyDetails?.visibility = View.VISIBLE
                    binding?.propertyDetailsError?.visibility = View.GONE
                    binding?.propertyDetailsProgressIndicator?.visibility = View.GONE
                    propertiesUi = it.t
                    it.t?.let { property ->
                        binding?.property = property
                        mapFragment?.getMapAsync { map ->
                            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
                            map.uiSettings.isZoomControlsEnabled = true
                            map.uiSettings.setAllGesturesEnabled(true)
                            map.uiSettings.isCompassEnabled = true
                            val latLng = LatLng(property.latitude, property.longitude)
                            val cameraPosition =
                                CameraPosition.Builder().target(latLng).zoom(15f).bearing(20f)
                                    .build()
                            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                            map.addMarker(
                                MarkerOptions()
                                    .position(
                                        latLng
                                    )
                            )
                        }
                        if (property.images.isNotEmpty()) {
                            isPhotoNotEmpty.set(false)
                            photoAdapter.submitList(property.images)
                            binding?.let { detailsProperty ->
                                TabLayoutMediator(
                                    detailsProperty.detailsPropertyItemDotIndicator,
                                    detailsProperty.detailsPropertyItem
                                ) { _, _ ->
                                    //Some implementation
                                }.attach()
                            }
                        } else {
                            isPhotoNotEmpty.set(true)
                        }
                    }
                }
            }
        }
        collectLatestFlow(homeViewModel.delete) {
            when (it) {
                is State.Error -> {
                    binding?.propertyDetailsError?.visibility = View.VISIBLE
                    binding?.propertyDetails?.visibility = View.GONE
                    binding?.propertyDetailsProgressIndicator?.visibility = View.GONE
                }
                is State.Loading -> {
                    binding?.propertyDetailsProgressIndicator?.visibility = View.VISIBLE
                    binding?.propertyDetailsError?.visibility = View.GONE
                    binding?.propertyDetails?.visibility = View.GONE
                }
                is State.Success -> {
                    if (it.t == true) {
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mapFragment = null
    }
}