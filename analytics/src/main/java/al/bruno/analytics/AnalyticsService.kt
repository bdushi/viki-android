package al.bruno.analytics

interface AnalyticsService {
    fun logEvent(eventName: String, vararg params: Pair<String, Any?>)
    fun setUserId(id: String)
    fun setUserProperty(name: String, value: String)
    fun setDefaultEventParameters(vararg params: Pair<String, Any?>)
}