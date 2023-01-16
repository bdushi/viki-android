package al.viki

import al.viki.common.Entry
import al.viki.model.PropertyUi.Companion.mapToPropertyUi
import al.viki.model.RequestUi.Companion.mapToRequestUi
import al.viki.ui.main.MainActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.os.bundleOf
import androidx.navigation.NavDeepLinkBuilder
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * https://firebase.google.com/docs/cloud-messaging/android/client
 *
 * https://firebase.google.com/docs/cloud-messaging/android/topic-messaging
 */

class VikiMessagesService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        createNotification(message)
    }

    override fun onNewToken(token: String) {
        Log.d(VikiMessagesService::class.java.name, token)
    }

    private fun createNotification(message: RemoteMessage) {
        val channel = NotificationChannel(
            getString(R.string.default_channel_id),
            getString(R.string.default_channel_description),
            NotificationManager.IMPORTANCE_DEFAULT
        )
            .apply {
                description = getString(R.string.default_channel_description)
            }
        val builder =
            NotificationCompat.Builder(this, getString(R.string.default_channel_id))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setContentIntent(
                if(message.data.getValue("entry") == Entry.PROPERTIES.name) {
                    NavDeepLinkBuilder(this)
                        .setGraph(R.navigation.nav_viki)
                        .addDestination(
                            R.id.propertyDetailsFragment,
                            bundleOf(
                                "property" to mapToPropertyUi(message.data)
                            )
                        )
                        .setComponentName(MainActivity::class.java)
                        .createPendingIntent()
                } else {
                    NavDeepLinkBuilder(this)
                        .setGraph(R.navigation.nav_viki)
                        .addDestination(
                            R.id.requestDetailsFragment,
                            bundleOf(
                                "request" to mapToRequestUi(message.data)
                            )
                        )
                        .setComponentName(MainActivity::class.java)
                        .createPendingIntent()
                }
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            // important when you want to update a specific notification before it´s clicked by the user
            // more or less random number, not important to be absolutely unique
            createNotificationChannel(channel)
            notify(((System.currentTimeMillis() % Integer.MAX_VALUE)).toInt(), builder.build())
        }
    }
}

