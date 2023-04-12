package al.bruno.analytics

import com.facebook.appevents.AppEventsLogger
import javax.inject.Inject

class FacebookAnalyticsService @Inject constructor(private val facebookAnalytics: AppEventsLogger) : AnalyticsService {
    override fun logEvent(eventName: String, vararg params: Pair<String, Any?>) {
        facebookAnalytics.logEvent(eventName, params.toBundle())
    }

    override fun setUserId(id: String) {
        // Not needed for Facebook
    }

    override fun setUserProperty(name: String, value: String) {
        // Not needed for Facebook
    }

    override fun setDefaultEventParameters(vararg params: Pair<String, Any?>) {
        // Not needed for Facebook
    }
}