package al.viki.foundation.root

import android.net.ConnectivityManager
import android.net.Network
import androidx.appcompat.app.AppCompatActivity

abstract class RootActivity : AppCompatActivity() {

    private var isNetworkAvailable = true
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isNetworkAvailable = true
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            isNetworkAvailable = false
        }

        override fun onUnavailable() {
            super.onUnavailable()
            isNetworkAvailable = false
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidInjection.inject(this)
//        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        installSplashScreen()
//        val connectivityManager =
//            getSystemService(ConnectivityManager::class.java) as ConnectivityManager
//        connectivityManager.requestNetwork(
//            NetworkRequest
//                .Builder()
//                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
//                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
//                .build(),
//            networkCallback,
//            Handler(Looper.getMainLooper()),
//            1000
//        )
//    }
}