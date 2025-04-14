package com.matthaug.mad411winter2025examreview.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BATTERY_LOW) {
            Toast.makeText(context, "Sync paused due to low battery", Toast.LENGTH_SHORT).show()
        }
    }
}
