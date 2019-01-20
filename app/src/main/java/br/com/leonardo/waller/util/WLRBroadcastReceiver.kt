package br.com.leonardo.waller.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/**
 * Created by Leonardo on 13/02/18.
 *
 * All rights reserved.
 */
class WLRBroadcastReceiver: BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("LOG","WLRBroadcastReceiver: onReceive")
        Toast.makeText(context, "New Wallpaper incoming!", Toast.LENGTH_LONG).show()
    }
}