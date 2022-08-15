package al.viki
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * CoroutineScope(SupervisorJob() + Dispatchers.IO)
 */

@HiltAndroidApp
class VikiApplication : Application()

