package al.viki

import al.bruno.core.interceptor.AuthorizationInterceptor
import al.bruno.foodies.interceptor.Session
import al.viki.authentication.AuthenticationActivity
import al.viki.core.AuthRepository
import android.app.Application
import android.content.Intent
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltAndroidApp
class VikiApplication : Application() {

    @Inject lateinit var authorizationInterceptor: AuthorizationInterceptor
    @Inject lateinit var trackingRepository: AuthRepository
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        // Used to Re-direct user into LoginActivity
        authorizationInterceptor.setSession(object : Session {
            override fun invalidate() {
                runBlocking {
                    withContext(Dispatchers.IO) {
                        trackingRepository.clear()
                    }
                }
                startActivity(
                    Intent(
                        this@VikiApplication,
                        AuthenticationActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                )
            }
        })
    }
}