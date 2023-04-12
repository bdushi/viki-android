package al.bruno.analytics.di

import al.bruno.analytics.AnalyticsService
import al.bruno.analytics.AnalyticsServiceFactory
import al.bruno.analytics.FacebookAnalyticsService
import al.bruno.analytics.FirebaseAnalyticsService
import al.bruno.analytics.events.FirebaseAnalyticsEvents
import android.content.Context
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AnalyticsModule {

    @Reusable
    @Provides
    fun provideFirebaseAnalytics(@ApplicationContext app: Context): FirebaseAnalytics =
        FirebaseAnalytics.getInstance(app)

    @Reusable
    @Provides
    fun provideFacebookAnalytics(@ApplicationContext app: Context): AppEventsLogger =
        AppEventsLogger.newLogger(app)

    @Provides
    @Reusable
    fun provideFirebaseAnalyticsService(firebaseAnalytics: FirebaseAnalytics): FirebaseAnalyticsService {
        return FirebaseAnalyticsService(firebaseAnalytics)
    }

    @Provides
    @Reusable
    fun provideFacebookAnalyticsService(appEventsLogger: AppEventsLogger): FacebookAnalyticsService {
        return FacebookAnalyticsService(appEventsLogger)
    }

    @Provides
    @Reusable
    fun firebaseAnalyticsEvents(firebaseAnalyticsService: FirebaseAnalyticsService) = FirebaseAnalyticsEvents(firebaseAnalyticsService)

    @Provides
    fun provideDefaultAnalyticsService(
        firebaseAnalyticsService: FirebaseAnalyticsService
    ): MutableList<AnalyticsService> {
        return mutableListOf(firebaseAnalyticsService)
    }

//    @Provides
//    fun provideAnalyticsServiceFactory(factory: DaggerAnalyticsServiceFactory.Factory): AnalyticsServiceFactory {
//        return factory.create(
//            firebaseAnalytics = Firebase.analytics,
//            facebookAnalytics = Facebook.getAnalyticsInstance(this)
//        )
//    }
}