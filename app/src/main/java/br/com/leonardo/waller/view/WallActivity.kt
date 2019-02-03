package br.com.leonardo.waller.view

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.leonardo.waller.R
import br.com.leonardo.waller.util.WLRBroadcastReceiver
import java.util.Calendar

class WallActivity : AppCompatActivity() {

    // MARK: - View Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        //TODO: - Save for multi module navigation
//        val newIntent = Intent(Intent.ACTION_VIEW).setClassName(
//            "br.com.leonardo.waller",
//            UnplashSettings.className)
//
//
//        startActivity(newIntent)

        scheduleDailyWallpaperChange()
    }

    // MARK: - View configuration

    // MARK: - Daily Wallpaper Handlers

    private fun scheduleDailyWallpaperChange() {

        val notificationIntent = Intent(this@WallActivity, WLRBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this@WallActivity, 0, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT)

        val calendar = Calendar.getInstance()

        if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) >= 9) {
            calendar.add(Calendar.DAY_OF_YEAR, 1) // add, not set!
        }

        calendar.set(Calendar.HOUR_OF_DAY, 9)
        calendar.add(Calendar.MINUTE, 1)
        calendar.set(Calendar.SECOND, 0)

        val futureInMillis = 5000L
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent)

//        val alarmManager = getSystemService(Context.ALARM_SERVICE) as? AlarmManager
//        alarmManager?.setRepeating(AlarmManager.RTC, calendar.timeInMillis,
//                AlarmManager.INTERVAL_DAY, pendingIntent)
    }
}

