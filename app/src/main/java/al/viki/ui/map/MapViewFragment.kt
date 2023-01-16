package al.viki.ui.map

import al.bruno.core.State
import al.viki.R
import al.viki.databinding.FragmentMapViewBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.ClusterItem
import al.viki.ui.home.HomeViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.SupportMapFragment
import com.google.maps.android.clustering.ClusterManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapViewFragment : Fragment(R.layout.fragment_map_view) {
    private val args: MapViewFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by viewModels()

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMapViewBinding.bind(view)
        binding.topAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.game_map_view) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            val clusterManager = ClusterManager<ClusterItem>(requireContext(), googleMap)
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.setAllGesturesEnabled(true)
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.isMyLocationEnabled = true
            googleMap.setOnCameraIdleListener(clusterManager)
            googleMap.setOnMarkerClickListener(clusterManager)
            clusterManager.renderer = ItemRenderer(requireContext(), googleMap, clusterManager)
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