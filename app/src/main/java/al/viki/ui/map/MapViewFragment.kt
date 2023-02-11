package al.viki.ui.map

import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.FragmentMapViewBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.ClusterItemUi
import al.viki.ui.filter.FilterDialog
import al.viki.ui.home.HomeViewModel
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.material.snackbar.Snackbar
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.ClusterManager.OnClusterClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapViewFragment : Fragment(R.layout.fragment_map_view), ClusterManager.OnClusterItemClickListener<ClusterItemUi>, OnClusterClickListener<ClusterItemUi> {
    private var _binding: FragmentMapViewBinding? = null
    private val binding get() = _binding
    private var googleMap: GoogleMap? = null
    private var mapView: SupportMapFragment? = null
    private var clusterManager: ClusterManager<ClusterItemUi>? = null
    private val args: MapViewFragmentArgs by navArgs()
    private val homeViewModel: HomeViewModel by viewModels()
    private val requestLocationPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) ||
                        it.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMapViewBinding.bind(view)
        binding?.mapViewTopAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding?.mapViewTopAppBar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.filter -> {
                    FilterDialog
                        .Builder()
                        .build()
                        .setOnFilterListener { filter ->
                            filter?.let { it ->
                                homeViewModel.properties(
                                    query = it.getQuery()
                                )
                            }
                        }
                        .show(
                            parentFragmentManager,
                            FilterDialog::class.java.name
                        )
                    true
                }
                else -> false
            }
        }
        mapView = (childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment)
        mapView?.getMapAsync { googleMap ->
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
            this.googleMap = googleMap
            if(clusterManager == null)
                clusterManager = ClusterManager<ClusterItemUi>(requireContext(), googleMap)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(41.3275, 19.8187), 10.5f))
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.setOnCameraIdleListener(clusterManager)
            googleMap.setOnMarkerClickListener(clusterManager)
            googleMap.setOnInfoWindowClickListener(clusterManager)
            clusterManager?.run {
                renderer = ItemRenderer(requireContext(), googleMap, this)
                setOnClusterClickListener(this@MapViewFragment)
                setOnClusterItemClickListener(this@MapViewFragment)
                cluster(this)
            }
        }

        homeViewModel.properties(query = args.filter.getQuery())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        googleMap?.clear()
        googleMap = null
        clusterManager?.clearItems()
        clusterManager = null
        mapView?.onDestroyView()
        mapView = null
    }

    override fun onClusterItemClick(item: ClusterItemUi): Boolean {
        if(item.isRequest) {
            findNavController()
                .navigate(
                    MapViewFragmentDirections
                        .actionMapViewFragmentToRequestDetailsFragment(
                            item.id
                        )
                )
        }
         else {
            findNavController()
                .navigate(
                    MapViewFragmentDirections
                        .actionMapViewFragmentToPropertyDetailsFragment(
                            item.id
                        )
                )
        }
        return true
    }

    override fun onClusterClick(cluster: Cluster<ClusterItemUi>): Boolean {
        val builder = LatLngBounds.builder()
        for (item in cluster.items) {
            builder.include(item.position)
        }
        googleMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 100))
        return true
    }

    private fun cluster(clusterManager: ClusterManager<ClusterItemUi>) {
        collectLatestFlow(homeViewModel.clusterItem) {
            when (it) {
                is State.Error -> {
                    binding?.mapViewProgressIndicator?.visibility = View.GONE
                }
                is State.Loading -> {
                    binding?.mapViewProgressIndicator?.visibility = View.VISIBLE
                }
                is State.Success -> {
                    binding?.mapViewProgressIndicator?.visibility = View.GONE
                    it.t?.let { items ->
                        googleMap?.clear()
                        clusterManager.clearItems()
                        clusterManager.run {
                            addItems(
                                items.map { item ->
                                    Glide
                                        .with(requireContext())
                                        .asDrawable()
                                        .load(item.url)
                                        .onlyRetrieveFromCache(true)
                                        .into(object : CustomTarget<Drawable>() {
                                            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                                                item.drawable = resource
                                            }

                                            override fun onLoadCleared(placeholder: Drawable?) {
                                                item.drawable = placeholder
                                            }

                                        })
                                    item
                                }
                            )
                            cluster()
                        }
                    }
                }
            }
        }
    }
}