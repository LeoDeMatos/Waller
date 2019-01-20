package br.com.leonardo.waller.view

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import br.com.leonardo.waller.R
import br.com.leonardo.waller.util.WLRBroadcastReceiver
import br.com.leonardo.waller.view.adapter.DefaultViewPagerAdapter
import br.com.leonardo.waller.view.fragment.BaseFragment
import br.com.leonardo.waller.view.fragment.FavoritesWallFragment
import br.com.leonardo.waller.view.fragment.MainWallFragment
import java.util.*


class WallActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall)

        configureViewPager()

        scheduleDailyWallpaperChange()
    }

    //MARK: View configuration
    private fun configureViewPager() {
        mViewPager = findViewById(R.id.main_wall_pager)

        val fragmentList = mutableListOf<BaseFragment>(MainWallFragment(), FavoritesWallFragment())
        val adapter = DefaultViewPagerAdapter<String>(supportFragmentManager, fragments = fragmentList)

        mViewPager.adapter = adapter
    }

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

