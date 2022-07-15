package al.viki.ui.property

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.common.collectFlow
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentNewPropertyBinding
import al.viki.model.*
import al.viki.ui.location.RequestLocationActivity
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NewPropertyFragment : Fragment(), View.OnClickListener {
    private val newPropertyUi = NewPropertyUi()
    private val propertyViewModel: PropertyViewModel by viewModels()
    private var _binding: FragmentNewPropertyBinding? = null
    private val binding get() = _binding

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
    private val operationAdapter =
        DropDownAdapter<OperationUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }

    private val mStartForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.getParcelableExtra<LocationUi>("LAT_LNG")?.let { locationUi ->
                    newPropertyUi.location = locationUi
                }
            }
        }

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                result.data?.data?.let {
                    requireActivity().contentResolver.query(
                        it,
                        filePathColumn,
                        null,
                        null,
                        null
                    )?.let { cursor ->
                        cursor.moveToFirst()
                        while (!cursor.isAfterLast) {
                            val picturePath =
                                cursor.getString(cursor.getColumnIndex(filePathColumn[0]))
                            cursor.moveToNext()
//                            Compressor.compress(requireContext(), File(picturePath))
                        }
                        cursor.close()
                    }
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
                            newPropertyUi.location = LocationUi(
                                loc.result.longitude,
                                loc.result.latitude
                            )
                        }
                }
                else -> {
                    binding?.let { newPropertyView ->
                        Snackbar
                            .make(
                                newPropertyView.newPropertyRootView,
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewPropertyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectFlow(propertyViewModel.cities) {
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

        collectFlow(propertyViewModel.propertyTypes) {
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

        collectFlow(propertyViewModel.currencies) {
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

        collectFlow(propertyViewModel.units) {
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

        collectFlow(propertyViewModel.operations) {
            when (it) {
                is State.Success -> {
                    it.t?.let { operations ->
                        operationAdapter.setItem(operations)
                    }
                }
                is State.Error -> {}
                is State.Unauthorized -> {}
                is State.Loading -> TODO()
            }
        }

        collectFlow(propertyViewModel.properties) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    if (it.t == 201)
                        findNavController().popBackStack()
                }
                is State.Unauthorized -> {}
                is State.Loading -> {}
            }
        }

        binding?.lifecycleOwner = this
        binding?.propertyViewModel = propertyViewModel
        binding?.newProperty = newPropertyUi
        binding?.cityAdapter = cityAdapter
        binding?.currencyAdapter = currencyAdapter
        binding?.propertyTypeAdapter = propertyTypeAdapter
        binding?.unitAdapter = unitAdapter
        binding?.operationAdapter = operationAdapter
        binding?.onClick = this
        when (PackageManager.PERMISSION_GRANTED) {
            checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION),
            checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                LocationServices
                    .getFusedLocationProviderClient(requireActivity())
                    .lastLocation
                    .addOnCompleteListener { loc ->
                        newPropertyUi.location = LocationUi(
                            loc.result.longitude,
                            loc.result.latitude
                        )
                    }
            } else -> {
                requestLocationPermissions.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.new_property_photo -> {
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
                intent.action = Intent.ACTION_GET_CONTENT
                startForResult.launch(intent)
            }
            R.id.new_property_location -> {
                mStartForResult.launch(
                    Intent(
                        requireContext(),
                        RequestLocationActivity::class.java
                    )
                )
//                    registerForActivityResult(object : ActivityResultContract<RequestLocationActivity, LocationUi?>() {
//                        override fun createIntent(context: Context, input: RequestLocationActivity): Intent {
//                            return Intent(context, RequestLocationActivity::class.java)
//                        }
//
//                        override fun parseResult(resultCode: Int, intent: Intent?): LocationUi? {
//                            return intent?.getParcelableExtra("LOCATION")
//                        }
//                    }) { result ->
//                        result?.let { locationUi ->
//                            newPropertyUi.location = locationUi
//                        }
//                    }
            }
            R.id.new_property_save -> {
                binding?.newProperty?.let { newPropertyUi ->
                    propertyViewModel.save(newPropertyUi)
                }
            }
        }
    }
}


