package al.viki.ui.map

import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.FragmentMapViewBinding
import al.viki.databinding.FragmentNewPropertyBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.ClusterItem
import al.viki.model.PropertyUi
import al.viki.ui.home.HomeFragmentDirections
import al.viki.ui.home.HomeViewModel
import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.snackbar.Snackbar
import com.google.maps.android.clustering.ClusterManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapViewFragment : Fragment(R.layout.fragment_map_view) {
    private var _binding: FragmentMapViewBinding? = null
    private val binding get() = _binding
    private var googleMap: GoogleMap? = null
    private val args: MapViewFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by viewModels()
    private val requestLocationPermissions = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
        when {
            it.getOrDefault(
                Manifest.permission.ACCESS_FINE_LOCATION, false
            ) || it.getOrDefault(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                false
            ) -> {
                googleMap?.isMyLocationEnabled = true
            }
            else -> {
                binding?.let { view ->
                    Snackbar
                        .make(
                            view.mapViewRoot,
                            getString(R.string.permission_denied),
                            Snackbar.LENGTH_LONG
                        )
                        .setAction("Settings") {
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
    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapViewBinding.bind(view)
        binding?.mapViewTopAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            when (PackageManager.PERMISSION_GRANTED) {
                checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION),
                checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                    googleMap.isMyLocationEnabled = true
                } else -> {
                requestLocationPermissions.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
            }
            val clusterManager = ClusterManager<ClusterItem>(requireContext(), googleMap)
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.setAllGesturesEnabled(true)
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.setOnCameraIdleListener(clusterManager)
            googleMap.setOnMarkerClickListener(clusterManager)
            clusterManager.renderer = ItemRenderer(requireContext(), googleMap, clusterManager)
            clusterManager.setOnClusterItemClickListener {
                findNavController()
                    .navigate(MapViewFragmentDirections.actionMapViewFragmentToPropertyDetailsFragment(it.getId()))
                true
            }
            if (args.filter.properties) {
                collectLatestFlow(homeViewModel.items) {
                    when (it) {
                        is State.Error -> {}
                        is State.Loading -> {}
                        is State.Success ->
                            it.t?.let { items ->
                                clusterManager.run {
                                    clearItems()
                                    addItems(items)
                                    cluster()
                                }
                            }
                    }
                }
            } else {
                collectLatestFlow(homeViewModel.items) {
                    when (it) {
                        is State.Error -> {}
                        is State.Loading -> {}
                        is State.Success ->
                            it.t?.let { items ->
                                clusterManager.run {
                                    clearItems()
                                    addItems(items)
                                    cluster()
                                }
                            }
                    }
                }
            }
        }
        homeViewModel.items(query = args.filter.getQuery(), properties = args.filter.properties)
    }
}