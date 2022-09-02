package al.viki.ui.details

import al.bruno.core.State
import al.viki.R
import al.viki.databinding.FragmentRequestDetailsBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.foundation.root.RootFragment
import al.viki.ui.home.HomeViewModel
import al.viki.ui.request.RequestViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class RequestDetailsFragment : RootFragment() {
    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[HomeViewModel::class.java]
    }
    private val args: RequestDetailsFragmentArgs by navArgs()
    private var mapFragment: SupportMapFragment? = null

    private var _binding: FragmentRequestDetailsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRequestDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val property = args.request
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
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
                        .setTitle(R.string.delete_request_title)
                        .setMessage(getString(R.string.delete_messages, property.title))
                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                            homeViewModel.deleteRequest(property.id)
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
        binding?.request = property
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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mapFragment = null
    }
}