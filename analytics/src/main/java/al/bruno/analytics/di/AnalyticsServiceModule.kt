package al.bruno.analytics.di

import al.bruno.analytics.AnalyticsServiceFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsServiceModule {
    @Binds
    abstract fun provideAnalyticsServiceFactory(analyticsServiceProviderFactory: AnalyticsServiceProviderFactory): AnalyticsServiceFactory
}