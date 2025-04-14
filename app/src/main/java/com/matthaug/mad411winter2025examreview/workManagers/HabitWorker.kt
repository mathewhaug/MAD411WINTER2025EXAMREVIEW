package com.matthaug.mad411winter2025examreview.workManagers

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.matthaug.mad411winter2025examreview.R

class HabitWorker(appContext: Context, params: WorkerParameters) : Worker(appContext, params) {
    override fun doWork(): Result {
        sendHabitReminder(applicationContext)
        return Result.success()
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun sendHabitReminder(context: Context) {
        val builder = NotificationCompat.Builder(context, "habit_channel")
            .setContentTitle("Habit Reminder")
            .setContentText("Don't forget to log your habit today!")
            .setSmallIcon(R.drawable.ic_notification)
        NotificationManagerCompat.from(context).notify(1, builder.build())
    }
}
