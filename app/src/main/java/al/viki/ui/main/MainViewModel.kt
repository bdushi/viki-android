package al.viki.ui.main

import al.viki.BuildConfig
import al.viki.core.AuthRepository
import android.os.Bundle
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.analytics.ktx.setConsent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val firebaseAnalytics: FirebaseAnalytics
) : ViewModel() {
    fun clear() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    suspend fun token(): StateFlow<Preferences> {
        return authRepository.token().stateIn(viewModelScope)
    }

    fun logEvent() {
        firebaseAnalytics.resetAnalyticsData()
        firebaseAnalytics.setUserId("skashuta")
        firebaseAnalytics.setDefaultEventParameters(
            toBundle(
                Pair("app_package_name", BuildConfig.APPLICATION_ID),
                Pair("app_version_name", BuildConfig.VERSION_NAME)
            )
        )
    }
    fun logEvent(name: String, vararg params: Pair<String, Any?>) {
        firebaseAnalytics.logEvent(name, toBundle(*params))
        firebaseAnalytics.setUserId("skashuta")
        firebaseAnalytics.setDefaultEventParameters(
            toBundle(
                Pair("app_package_name", BuildConfig.APPLICATION_ID),
                Pair("app_version_name", BuildConfig.VERSION_NAME)
            )
        )
    }
    private fun toBundle(vararg params: Pair<String, Any?>): Bundle {
        val bundle = Bundle()
        params.forEach {
            bundle.putString(it.first, it.second.toString())
        }
        return bundle
    }
}

//fun Array<Pair<String, Any?>>.toBundle(): Bundle {
//    val bundle = Bundle()
//    this.forEach {
//        bundle.putString(it.first, it.second.toString())
//    }
//    return bundle
//}