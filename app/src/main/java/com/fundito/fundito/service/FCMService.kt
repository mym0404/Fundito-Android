package com.fundito.fundito.service

import com.facebook.AccessToken
import com.fundito.fundito.common.util.NotificationUtil
import com.fundito.fundito.common.util.SPUtil
import com.fundito.fundito.data.service.NetworkClient
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * Created by mj on 02, January, 2020
 */
class FCMService : FirebaseMessagingService() {

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        /**
         * If signinned, Update FCM Token
         */
        val accessToken = AccessToken.getCurrentAccessToken()
        val isFacebookLogined = accessToken != null && !accessToken.isExpired

        if(!SPUtil.accessToken.isBlank() && isFacebookLogined) {
            GlobalScope.launch {
                kotlin.runCatching {
                    NetworkClient.userService.signIn(accessToken.token,p0)
                }
            }
        }
    }

    override fun onMessageReceived(p0: RemoteMessage) {
        val notiUtil = NotificationUtil(applicationContext)
        Timber.e(p0.toString())
        Timber.e(p0.data.toString())
        val title = p0.data.get("title") ?: "Fundito"
        val body = p0.data.get("message") ?: "Fundito Notification!"
        notiUtil.showNotification( title,body)
    }
}