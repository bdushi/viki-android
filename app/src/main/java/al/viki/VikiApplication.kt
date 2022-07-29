package al.viki

import al.bruno.core.interceptor.AuthInterceptor
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.common.TOKEN
import al.viki.core.AuthRepository
import android.app.Application
import android.content.Intent
import android.content.Intent.*
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@HiltAndroidApp
class VikiApplication : Application() {
    @Inject lateinit var trackingRepository: AuthRepository
    @Inject lateinit var authInterceptor: AuthInterceptor
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    override fun onCreate() {
        super.onCreate()
        applicationScope.launch {
            trackingRepository.token().collectLatest {
                val token: String? = it[stringPreferencesKey(TOKEN)]
                if (token != null) {
                    authInterceptor.token = token
                } else {
                    startActivity(
                        Intent(this@VikiApplication, AuthenticationActivity::class.java)
                            .setFlags(FLAG_ACTIVITY_NEW_TASK)
                    )
                }
            }
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        applicationScope.cancel()
    }
}

