package com.example.giniapp3.brodcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings

class AirPlaneReceiver : BroadcastReceiver()  {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isAirPlaneOn = Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON
            ) != 0
            println("the airplane is : $isAirPlaneOn")

        }
    }
}