package com.example.tinderfiap_challenge

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.tinderfiap_challenge.navigation.NavigationGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationGraph()
        }
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Match Notification"
            val descriptionText = "Notification for matches"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("match_notification_channel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}

@SuppressLint("MissingPermission")
fun sendMatchNotification(context: Context) {
    val builder = NotificationCompat.Builder(context, "match_notification_channel")
        .setSmallIcon(R.drawable.ic_person)
        .setContentTitle("It's a Match!")
        .setContentText("You and another user have liked each other.")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    with(NotificationManagerCompat.from(context)) {
        notify(1, builder.build())
    }
}



