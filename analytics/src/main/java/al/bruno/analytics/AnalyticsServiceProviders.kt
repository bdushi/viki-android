package al.bruno.analytics

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AnalyticsServiceProviders @Inject constructor(private val analyticsProviders: MutableList<AnalyticsService>): AnalyticsService {
    override fun logEvent(eventName: String, vararg params: Pair<String, Any?>) {
        analyticsProviders.forEach {
            it.logEvent(eventName, *params)
        }
    }

    override fun setUserId(id: String) {
        analyticsProviders.forEach {
            it.setUserId(id)
        }
    }

    override fun setUserProperty(name: String, value: String) {
        analyticsProviders.forEach {
            it.setUserProperty(name, value)
        }
    }

    override fun setDefaultEventParameters(vararg params: Pair<String, Any?>) {
        analyticsProviders.forEach {
            it.setDefaultEventParameters(*params)
        }
    }

    fun addProvider(provider: AnalyticsService) {
        analyticsProviders.add(provider)
    }

    fun removeProvider(provider: AnalyticsService) {
        analyticsProviders.remove(provider)
    }
}