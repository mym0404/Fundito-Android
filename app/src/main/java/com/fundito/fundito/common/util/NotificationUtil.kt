package com.fundito.fundito.common.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.fundito.fundito.R
import com.fundito.fundito.di.AppScope
import com.fundito.fundito.presentation.splash.SplashActivity
import javax.inject.Inject

/**
 * Created by mj on 02, January, 2020
 */
@AppScope
class NotificationUtil @Inject constructor(private val context: Context) {

    companion object {
        private const val NOTI_CHANNEL_ID = "NOTI_CHANNEL_ID"
        private const val NOTI_CHANNEL_NAME = "앱 알림"

        private const val NOTI_ID = 100
    }

    init {
        initNotificationChannel()
    }


    private fun initNotificationChannel() {
        if(Build.VERSION.SDK_INT >= 26) {
            val nm = NotificationManagerCompat.from(context)
            val channel = NotificationChannel(NOTI_CHANNEL_ID, NOTI_CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)
            nm.createNotificationChannel(channel)
        }
    }

    fun showNotification(title: String?, body: String?) {
        val nm = NotificationManagerCompat.from(context)
        val noti = NotificationCompat.Builder(context, NOTI_CHANNEL_ID)
            .setContentTitle(title ?: "Fundito")
            .setContentText(body ?: "New Notification")
            .setSmallIcon(R.drawable.small_logo)
            .setPriority(Notification.PRIORITY_MAX)
            .setAutoCancel(true)
            .setContentIntent(
                PendingIntent.getActivity(context,200, Intent(context,SplashActivity::class.java),0)
            )
            .build()

        nm.notify(NOTI_ID,noti)

    }

}