package al.viki.ui.request

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentNewRequestBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.*
import al.viki.foundation.root.RootFragment
import al.viki.ui.home.HomeViewModel
import al.viki.ui.location.RequestLocationActivity
import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar

class NewRequestFragment : RootFragment() {
    private val newRequestUi = NewRequestUi()
    private val requestViewModel: RequestViewModel by lazy {
        ViewModelProvider(this, viewModelProvider)[RequestViewModel::class.java]
    }
    private var _binding: FragmentNewRequestBinding? = null
    private val binding get() = _binding

    private val requestLocation =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.getParcelableExtra<LocationUi>("LAT_LNG")?.let { locationUi ->
                    newRequestUi.location = locationUi
                }
            }
        }
    @SuppressLint("MissingPermission")
    private val requestLocationPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    Manifest.permission.ACCESS_FINE_LOCATION, false
                ) || it.getOrDefault(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    false
                ) -> {
                    LocationServices
                        .getFusedLocationProviderClient(requireActivity())
                        .lastLocation
                        .addOnSuccessListener { location ->
                            location?.let { loc ->
                                newRequestUi.location = LocationUi(
                                    loc.longitude,
                                    loc.latitude
                                )
                            }
                        }
                }
                else -> {
                    binding?.let { newPropertyView ->
                        Snackbar
                            .make(
                                newPropertyView.root,
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

    private val cityAdapter =
        DropDownAdapter<CityUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val currencyAdapter =
        DropDownAdapter<CurrencyUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val propertyTypeAdapter =
        DropDownAdapter<PropertyTypeUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val unitAdapter =
        DropDownAdapter<UnitUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requestViewModel.cities
        _binding = FragmentNewRequestBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding?.newRequestUi = newRequestUi
        binding?.cityAdapter = cityAdapter
        binding?.currencyAdapter = currencyAdapter
        binding?.propertyTypeAdapter = propertyTypeAdapter
        binding?.unitAdapter = unitAdapter
        binding?.onClick = View.OnClickListener {
            when (it.id) {
                R.id.new_request_location -> {
                    requestLocation.launch(
                        Intent(
                            requireContext(),
                            RequestLocationActivity::class.java
                        )
                    )
                }
                R.id.new_request_save -> {
                    binding?.newRequestUi?.let { newPropertyUi ->
                        requestViewModel.save(newPropertyUi)
                    }
                }
            }
        }

        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) -> {
                LocationServices
                    .getFusedLocationProviderClient(requireActivity())
                    .lastLocation
                    .addOnSuccessListener { location ->
                        location?.let {
                            newRequestUi.location = LocationUi(
                                it.longitude,
                                it.latitude
                            )
                        }
                    }
            }
            else -> {
                requestLocationPermissions.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }

        collectLatestFlow(requestViewModel.cities) {
            when (it) {
                is State.Success -> {
                    it.t?.let { cities ->
                        cityAdapter.setItem(cities)
                    }
                }
                is State.Error -> {}
                is State.Loading -> TODO()
            }
        }

        collectLatestFlow(requestViewModel.propertyTypes) {
            when (it) {
                is State.Success -> {
                    it.t?.let { propertyType ->
                        propertyTypeAdapter.setItem(propertyType)
                    }
                }
                is State.Error -> {}
                is State.Loading -> TODO()
            }
        }

        collectLatestFlow(requestViewModel.currencies) {
            when (it) {
                is State.Success -> {
                    it.t?.let { currencies ->
                        currencyAdapter.setItem(currencies)
                    }
                }
                is State.Error -> {

                }
                is State.Loading -> TODO()
            }
        }

        collectLatestFlow(requestViewModel.units) {
            when (it) {
                is State.Success -> {
                    it.t?.let { units ->
                        unitAdapter.setItem(units)
                    }
                }
                is State.Error -> {

                }
                is State.Loading -> {

                }
            }
        }

        collectLatestFlow(requestViewModel.request) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let {
                        findNavController().popBackStack()
                    }
                }
                is State.Loading -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}