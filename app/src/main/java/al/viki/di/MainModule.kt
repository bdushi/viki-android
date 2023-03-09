package al.viki.di

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MainModule {
    @Reusable
    @Provides
    fun providesFirebaseAnalytics(context: Application) = FirebaseAnalytics.getInstance(context)
//        Firebase.analytics
}