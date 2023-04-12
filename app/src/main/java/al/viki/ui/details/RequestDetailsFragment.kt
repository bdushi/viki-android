package al.viki.ui.details

import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.FragmentRequestDetailsBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.PropertiesUi
import al.viki.model.RequestUi
import al.viki.ui.home.HomeViewModel
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RequestDetailsFragment : Fragment(R.layout.fragment_request_details) {
    private val homeViewModel: HomeViewModel by viewModels()
    private val detailsViewModel: DetailsViewModel by viewModels()
    private val args: RequestDetailsFragmentArgs by navArgs()
    private var mapFragment: SupportMapFragment? = null

    private var _binding: FragmentRequestDetailsBinding? = null
    private val binding get() = _binding

    private var request: PropertiesUi? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRequestDetailsBinding.bind(view)
        detailsViewModel.request(args.id)
        mapFragment =
            childFragmentManager.findFragmentById(R.id.details_property_location_in_map) as? SupportMapFragment
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.share -> {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "${BuildConfig.HOST_NAME}request/${args.id}")
                        type = "text/plain"
                    }
                    startActivity(Intent.createChooser(sendIntent, getString(R.string.app_name)))
                    true
                }
                R.id.delete -> {
                    MaterialAlertDialogBuilder(requireContext())
                        .setIcon(al.viki.foundation.R.drawable.ic_outline_warning_amber)
                        .setTitle(R.string.delete_request_title)
                        .setMessage(getString(R.string.delete_messages, request?.title))
                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                            homeViewModel.deleteRequest(args.id)
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
        binding?.requestDetailsErrorRefresh?.setOnClickListener {
            detailsViewModel.request(args.id)
        }
        collectLatestFlow(homeViewModel.delete) {
            when (it) {
                is State.Error -> {
                    binding?.requestDetailsError?.visibility = View.VISIBLE
                    binding?.requestDetails?.visibility = View.GONE
                    binding?.requestDetailsProgressIndicator?.visibility = View.GONE
                }
                is State.Loading -> {
                    binding?.requestDetailsProgressIndicator?.visibility = View.VISIBLE
                    binding?.requestDetailsError?.visibility = View.GONE
                    binding?.requestDetails?.visibility = View.GONE
                }
                is State.Success -> {
                    if (it.t == true) {
                        findNavController().popBackStack()
                    }
                }
            }
        }
        collectLatestFlow(detailsViewModel.properties) {
            when (it) {
                is State.Error -> {
                    binding?.requestDetailsError?.visibility = View.VISIBLE
                    binding?.requestDetails?.visibility = View.GONE
                    binding?.requestDetailsProgressIndicator?.visibility = View.GONE
                }
                is State.Loading -> {
                    binding?.requestDetailsProgressIndicator?.visibility = View.VISIBLE
                    binding?.requestDetailsError?.visibility = View.GONE
                    binding?.requestDetails?.visibility = View.GONE
                }
                is State.Success -> {
                    binding?.requestDetails?.visibility = View.VISIBLE
                    binding?.requestDetailsError?.visibility = View.GONE
                    binding?.requestDetailsProgressIndicator?.visibility = View.GONE
                    request = it.t
                    _binding?.request = it.t
                    it.t?.let { request ->
                        _binding?.request = request
                        mapFragment?.getMapAsync { map ->
                            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
                            map.uiSettings.isZoomControlsEnabled = true
                            map.uiSettings.setAllGesturesEnabled(true)
                            map.uiSettings.isCompassEnabled = true
                            val latLng = LatLng(request.latitude, request.longitude)
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