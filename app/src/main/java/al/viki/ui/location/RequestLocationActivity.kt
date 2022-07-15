package al.viki.ui.location

import al.viki.BuildConfig
import al.viki.R
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.snackbar.Snackbar

class RequestLocationActivity : AppCompatActivity() {
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_location)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            this.googleMap = googleMap
            googleMap.uiSettings.isZoomControlsEnabled = true
            googleMap.uiSettings.isMyLocationButtonEnabled = true
            googleMap.uiSettings.setAllGesturesEnabled(true)
            googleMap.uiSettings.isCompassEnabled = true
            googleMap.setOnMapClickListener {
                setResult(Activity.RESULT_OK, Intent().putExtra("LAT_LNG", it))
                finish()
            }
        }
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            when {
                it.getOrDefault(
                    Manifest.permission.ACCESS_FINE_LOCATION, false
                ) || it.getOrDefault(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    false
                ) -> {
                    googleMap.isMyLocationEnabled = true
                }
                else -> {
                    Snackbar
                        .make(
                            findViewById(android.R.id.content),
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
        }.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}