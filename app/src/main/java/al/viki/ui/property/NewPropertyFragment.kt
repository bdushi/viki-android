package al.viki.ui.property

import al.bruno.adapter.CustomListAdapter
import al.bruno.adapter.DropDownAdapter
import al.bruno.adapter.OnClickListener
import al.bruno.core.State
import al.viki.BuildConfig
import al.viki.R
import al.viki.common.TOPIC
import al.viki.common.photoDiffUtil
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentNewPropertyBinding
import al.viki.databinding.NewPropertyPhotoItemBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.*
import al.viki.ui.location.RequestLocationActivity
import al.viki.ui.main.MainActivity
import android.Manifest
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.LocationServices
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import dagger.hilt.android.AndroidEntryPoint
import java.security.AccessController.checkPermission

/**
 * https://firebase.google.com/docs/storage/android/upload-files#kotlin+ktx
 */

@AndroidEntryPoint
class NewPropertyFragment : Fragment(), View.OnClickListener, OnClickListener<ImagesUi> {
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

    private val photoAdapter =
        CustomListAdapter<ImagesUi, NewPropertyPhotoItemBinding>(
            R.layout.new_property_photo_item, { t, vm ->
                vm.photo = t
                vm.onClick = this
            },
            photoDiffUtil
        )

    private val requestLocation =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                if (Build.VERSION.SDK_INT >= 33) {
                    it.data?.getParcelableExtra("LAT_LNG", LocationUi::class.java)
                        ?.let { locationUi ->
                            newPropertyUi.location = locationUi
                        }
                } else {
                    it.data?.getParcelableExtra<LocationUi>("LAT_LNG")?.let { locationUi ->
                        newPropertyUi.location = locationUi
                    }
                }
            }
        }

    private val requestGallery =
        registerForActivityResult(
            object : ActivityResultContract<Intent, Uri?>() {
                override fun createIntent(context: Context, input: Intent): Intent {
                    return input
                }

                override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
                    return if (resultCode == Activity.RESULT_OK) {
                        intent?.data
                    } else {
                        null
                    }
                }
            }
        ) { uri: Uri? ->
            uri?.let {
                context?.contentResolver?.openInputStream(uri)
                propertyViewModel.photoUi(it)
            }
        }

    @SuppressLint("MissingPermission")
    private val requestLocationPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { it ->
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
                                newPropertyUi.location = LocationUi(
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

    private val requestFilePermissions =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (Environment.isExternalStorageManager()) {
                        val intent =
                            Intent(
                                Intent.ACTION_PICK,
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                            )
                        intent.type = "image/*"
                        requestGallery.launch(intent)
                    } else {
                        // show Android 11+ PermissionDialog
                        MaterialAlertDialogBuilder(requireContext())
                            .setTitle(R.string.allow_access)
                            .setMessage(R.string.allow_access_detail)
                            .setPositiveButton(R.string.settings) { dialog, _ ->
                                val intent = Intent().apply {
                                    action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                                    data = Uri.fromParts("package", requireContext().packageName, null)
                                }
                                dialog.dismiss()
                                android11PlusSettingResultLauncher.launch(intent)
                            }
                            .setNegativeButton(R.string.not_now) { dialog, _ ->
                                dialog.dismiss()
                            }.show()
                    }
                } else {
                    // Permission Granted for android marshmallow+
                    val intent =
                        Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        )
                    intent.type = "image/*"
                    requestGallery.launch(intent)
                }
            } else {
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

    @RequiresApi(Build.VERSION_CODES.R)
    private val android11PlusSettingResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Environment.isExternalStorageManager()) {
                val intent =
                    Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                    )
                intent.type = "image/*"
                requestGallery.launch(intent)
            } else {
                startActivity(
                    Intent(
                        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + BuildConfig.APPLICATION_ID)
                    )
                )
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

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectLatestFlow(propertyViewModel.cities) {
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

        collectLatestFlow(propertyViewModel.propertyTypes) {
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

        collectLatestFlow(propertyViewModel.currencies) {
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

        collectLatestFlow(propertyViewModel.units) {
            when (it) {
                is State.Success -> {
                    it.t?.let { units ->
                        unitAdapter.setItem(units)
                    }
                }
                is State.Error -> {

                }
                is State.Loading -> TODO()
            }
        }

        collectLatestFlow(propertyViewModel.operations) {
            when (it) {
                is State.Success -> {
                    it.t?.let { operations ->
                        operationAdapter.setItem(operations)
                    }
                }
                is State.Error -> {}
                is State.Loading -> TODO()
            }
        }

        collectLatestFlow(propertyViewModel.properties) {
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

        /**
         * android:visibility="@{propertyViewModel.photo.isEmpty() ? View.GONE : View.VISIBLE }"
         */
        collectLatestFlow(propertyViewModel.photo) {
            photoAdapter.submitList(it)
        }

        binding?.lifecycleOwner = this
        binding?.propertyViewModel = propertyViewModel
        binding?.newProperty = newPropertyUi
        binding?.cityAdapter = cityAdapter
        binding?.currencyAdapter = currencyAdapter
        binding?.propertyTypeAdapter = propertyTypeAdapter
        binding?.unitAdapter = unitAdapter
        binding?.operationAdapter = operationAdapter
        binding?.photoAdapter = photoAdapter
        binding?.onClick = this
        when (PackageManager.PERMISSION_GRANTED) {
            checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION),
            checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) -> {
                LocationServices
                    .getFusedLocationProviderClient(requireActivity())
                    .lastLocation
                    .addOnSuccessListener { location ->
                        location?.let {
                            newPropertyUi.location = LocationUi(
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

        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.new_photo -> {
                    if (checkSelfPermission(
                            requireContext(),
                            READ_EXTERNAL_STORAGE
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                            if (Environment.isExternalStorageManager()) {
                                val intent =
                                    Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                                    )
                                intent.type = "image/*"
                                requestGallery.launch(intent)
                            } else {
                                MaterialAlertDialogBuilder(requireContext())
                                    .setTitle(R.string.allow_access)
                                    .setMessage(R.string.allow_access_detail)
                                    .setPositiveButton(R.string.settings) { dialog, _ ->
                                        val intent = Intent().apply {
                                            action = Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                                            data = Uri.fromParts("package", requireContext().packageName, null)
                                        }
                                        dialog.dismiss()
                                        android11PlusSettingResultLauncher.launch(intent)
                                    }
                                    .setNegativeButton(R.string.not_now) { dialog, _ ->
                                        dialog.dismiss()
                                    }.show()
                            }
                        } else {
                            val intent =
                                Intent(
                                    Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                                )
                            intent.type = "image/*"
                            requestGallery.launch(intent)
                        }
                    } else {
                        requestFilePermissions.launch(READ_EXTERNAL_STORAGE)
                    }
                    true
                }
                else -> false
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(view: View, t: ImagesUi) {
        when (view.id) {
            R.id.add_new_property_photo_close -> {
                propertyViewModel.photoUi(imagesUi = t)
            }
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.new_property_location -> {
                requestLocation.launch(
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


