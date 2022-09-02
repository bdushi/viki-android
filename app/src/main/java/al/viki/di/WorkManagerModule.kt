package al.viki.di

import al.viki.factory.VikiWorkerFactory
import android.content.Context
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WorkManagerModule : Initializer<WorkManager> {
    @Provides
    @Singleton
    override fun create(context: Context): WorkManager {
        return WorkManager
            .getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    @Singleton
    @Provides
    fun provideWorkManagerConfiguration(vikiWorkerFactory: VikiWorkerFactory): Configuration {
        return Configuration
            .Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(vikiWorkerFactory)
            .build()
    }
}