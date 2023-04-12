package al.bruno.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

class FirebaseAnalyticsService @Inject constructor(private val firebaseAnalytics: FirebaseAnalytics) : AnalyticsService {
    override fun logEvent(eventName: String, vararg params: Pair<String, Any?>) {
        firebaseAnalytics.logEvent(eventName, params.toBundle())
    }

    override fun setUserId(id: String) {
        firebaseAnalytics.setUserId(id)
    }

    override fun setUserProperty(name: String, value: String) {
        firebaseAnalytics.setUserProperty(name, value)
    }

    override fun setDefaultEventParameters(vararg params: Pair<String, Any?>) {
       firebaseAnalytics.setDefaultEventParameters(params.toBundle())
    }
}
