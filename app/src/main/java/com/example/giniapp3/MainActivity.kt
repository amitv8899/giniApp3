package com.example.giniapp3

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.giniapp3.Service.ServiceApp
import com.example.giniapp3.brodcast.AirPlaneReceiver
import com.example.giniapp3.ui.theme.GiniApp3Theme
import java.util.jar.Manifest

class MainActivity : ComponentActivity() {
    private val rec = AirPlaneReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.FOREGROUND_SERVICE),0)
        }
        registerReceiver(
            rec,
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        )

        setContent {
            GiniApp3Theme {
              Column(Modifier.fillMaxSize()) {
                  Button(onClick = {
                      Intent(applicationContext, ServiceApp ::class.java).also {
                          it.action =ServiceApp.Actions.START.toString()
                          startService(it)
                      }

                  }) {
                      Text(text = "start")
                  }
                  Button(onClick = {  Intent(applicationContext, ServiceApp ::class.java).also {
                      it.action =ServiceApp.Actions.STOP.toString()
                      startService(it)
                  } }) {
                      Text(text = "stop")

                  }

              }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(rec)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GiniApp3Theme {
        Greeting("Android")
    }
}