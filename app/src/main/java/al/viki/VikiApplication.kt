package al.viki

import al.viki.di.DaggerAppComponent
import al.viki.factory.VikiWorkerFactory
import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.WorkManager
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * CoroutineScope(SupervisorJob() + Dispatchers.IO)
 * @WorkManger Doc https://developer.android.com/training/dependency-injection/hilt-jetpack#kotlin
 * @Hilt https://developer.android.com/training/dependency-injection/hilt-android
 * @Share https://developer.android.com/training/sharing/send#java
 * @Hilt_WorkManger https://developer.android.com/training/dependency-injection/hilt-jetpack
 */

class VikiApplication : Application(), Configuration.Provider, HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var configuration: Configuration

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory()
            .application(this)
            .inject(this)

    }

    override fun androidInjector() = activityInjector

    override fun getWorkManagerConfiguration() = configuration

}

