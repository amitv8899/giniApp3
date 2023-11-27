package com.example.giniapp3.Service
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import com.example.giniapp3.R

class ServiceApp :Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString()->start()
            Actions.STOP.toString()->stopSelf()
        }


        return super.onStartCommand(intent, flags, startId)
    }
    private fun start(){
        val notif = NotificationCompat.Builder(this,"running")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("this is title")
            .setContentText("this is body")
            .build()
        startForeground(1,notif)

    }
    enum class  Actions{
        START,STOP
    }
}