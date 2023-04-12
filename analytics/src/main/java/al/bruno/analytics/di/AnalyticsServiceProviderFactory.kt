package al.bruno.analytics.di

import al.bruno.analytics.*
import al.bruno.analytics.AnalyticsServiceFactory
import javax.inject.Inject

//class AnalyticsServiceProviderFactory @AssistedInject constructor(
//    @Assisted("firebaseAnalytics") private val firebaseAnalytics: Provider<FirebaseAnalyticsService>,
//    @Assisted("facebookAnalytics") private val facebookAnalytics: Provider<FacebookAnalyticsService>
//) : AnalyticsServiceFactory {

class AnalyticsServiceProviderFactory @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalyticsService,
    private val facebookAnalytics: FacebookAnalyticsService
) : AnalyticsServiceFactory {
    override fun createAnalyticsService(analyticsType: AnalyticsType): AnalyticsService {
        return when (analyticsType) {
            AnalyticsType.FIREBASE -> firebaseAnalytics
            AnalyticsType.FACEBOOK -> facebookAnalytics
        }
    }

//    @AssistedFactory
//    interface Factory {
//        fun create(
//            @Assisted("firebaseAnalytics") firebaseAnalytics: FirebaseAnalyticsService,
//            @Assisted("facebookAnalytics") facebookAnalytics: FacebookAnalyticsService
//        ): AnalyticsServiceProviderFactory
//    }
}