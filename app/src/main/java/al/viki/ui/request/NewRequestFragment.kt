package al.viki.ui.request

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.common.collectFlow
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentNewRequestBinding
import al.viki.model.*
import al.viki.ui.location.RequestLocationActivity
import al.viki.ui.property.PropertyViewModel
import al.viki.ui.property.UploadWorker
import android.Manifest
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
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewRequestFragment : Fragment() {
    private val newRequestUi = NewRequestUi()
    private val requestViewModel: RequestViewModel by viewModels()
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
                        .addOnCompleteListener { loc ->
                            newRequestUi.location = LocationUi(
                                loc.result.longitude,
                                loc.result.latitude
                            )
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
                R.id.new_property_location -> {
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
                    .addOnCompleteListener { loc ->
                        newRequestUi.location = LocationUi(
                            loc.result.longitude,
                            loc.result.latitude
                        )
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

        collectFlow(requestViewModel.cities) {
            when (it) {
                is State.Success -> {
                    it.t?.let { cities ->
                        cityAdapter.setItem(cities)
                    }
                }
                is State.Error -> {}
                is State.Unauthorized -> {}
                is State.Loading -> TODO()
            }
        }

        collectFlow(requestViewModel.propertyTypes) {
            when (it) {
                is State.Success -> {
                    it.t?.let { propertyType ->
                        propertyTypeAdapter.setItem(propertyType)
                    }
                }
                is State.Error -> {}
                is State.Unauthorized -> {}
                is State.Loading -> TODO()
            }
        }

        collectFlow(requestViewModel.currencies) {
            when (it) {
                is State.Success -> {
                    it.t?.let { currencies ->
                        currencyAdapter.setItem(currencies)
                    }
                }
                is State.Error -> {

                }
                is State.Unauthorized -> {

                }
                is State.Loading -> TODO()
            }
        }

        collectFlow(requestViewModel.units) {
            when (it) {
                is State.Success -> {
                    it.t?.let { units ->
                        unitAdapter.setItem(units)
                    }
                }
                is State.Error -> {

                }
                is State.Unauthorized -> {

                }
                is State.Loading -> TODO()
            }
        }

        collectFlow(requestViewModel.request) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let {
                        findNavController().popBackStack()
                    }
                }
                is State.Unauthorized -> {}
                is State.Loading -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}