package com.matthaug.mad411winter2025examreview.services

import android.app.Service
import android.app.Service.START_STICKY
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat.startForeground
import com.matthaug.mad411winter2025examreview.R

class HabitTimerService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification = NotificationCompat.Builder(this, "habit_channel")
            .setContentTitle("Habit Timer Running")
            .setContentText("Tracking meditation...")
            .setSmallIcon(R.drawable.ic_timer)
            .build()

        startForeground(1, notification)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
