package al.bruno.analytics.events

import al.bruno.analytics.FirebaseAnalyticsService
import al.bruno.analytics.toBundle
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class FirebaseAnalyticsEvents @Inject constructor(private val firebaseAnalytics: FirebaseAnalyticsService) {
    fun logEvent(eventName: String, vararg params: Pair<String, Any?>) {
        firebaseAnalytics.logEvent(eventName, *params)
    }
    fun logEvent(
        userId: String,
        applicationId: String,
        versionName: String
    ) {
        firebaseAnalytics.setDefaultEventParameters(
            Pair(APP_PACKAGE_NAME, applicationId),
            Pair(APP_VERSION_NAME, versionName)
        )
    }

    fun logEvent(
        eventName: String,
        userId: String,
        applicationId: String,
        versionName: String,
        vararg params: Pair<String, Any?>) {
        firebaseAnalytics.logEvent(eventName, *params)
        firebaseAnalytics.setDefaultEventParameters(
            Pair(APP_PACKAGE_NAME, applicationId),
            Pair(APP_VERSION_NAME, versionName)
        )
    }

    fun logScreenView(screenName: String, screenClass: String) {
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, screenName);
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass);
//        bundle.putString(MyAppAnalyticsConstants.Param.TOPIC, topic);
        firebaseAnalytics
            .logEvent(
                FirebaseAnalytics.Event.SCREEN_VIEW,
                Pair(FirebaseAnalytics.Param.SCREEN_NAME, screenName),
                Pair(FirebaseAnalytics.Param.SCREEN_CLASS, screenClass),
            )
    }
}

//fun Array<Pair<String, Any?>>.toBundle(): Bundle {
//    val bundle = Bundle()
//    this.forEach {
//        bundle.putString(it.first, it.second.toString())
//    }
//    return bundle
//}