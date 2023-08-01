package al.viki

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * CoroutineScope(SupervisorJob() + Dispatchers.IO)
 * @WorkManger Doc https://developer.android.com/training/dependency-injection/hilt-jetpack#kotlin
 * @Hilt https://developer.android.com/training/dependency-injection/hilt-android
 * @Share https://developer.android.com/training/sharing/send#java
 * @Hilt_WorkManger https://developer.android.com/training/dependency-injection/hilt-jetpack
 */

@HiltAndroidApp
class VikiApplication : Application(), Configuration.Provider {
    @Inject
    lateinit var vikiWorkerFactory: HiltWorkerFactory
    override val workManagerConfiguration: Configuration
        get() = Configuration
            .Builder()
            .setMinimumLoggingLevel(android.util.Log.DEBUG)
            .setWorkerFactory(vikiWorkerFactory)
            .build()

}

