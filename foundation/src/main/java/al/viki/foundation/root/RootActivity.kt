package al.viki.foundation.root

import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class RootActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

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

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
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

    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentInjector
    }
}