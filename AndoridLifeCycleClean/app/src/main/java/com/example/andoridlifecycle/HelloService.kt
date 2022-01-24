package com.example.andoridlifecycle

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*
import java.net.URL

class HelloService : Service() {
    private var startMode: Int = 0             // indicates how to behave if the service is killed
    private var binder: IBinder? = HelloServiceBinder()        // interface for clients that bind
    private var allowRebind: Boolean = false   // indicates whether onRebind should be used

    inner class HelloServiceBinder : Binder() {
        fun getService(): HelloService = this@HelloService
    }

    override fun onCreate() {
        // The service is being created
        Log.i(Globals.TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // The service is starting, due to a call to startService()
        Log.i(Globals.TAG, "Service onStart")
        return startMode
    }

    override fun onBind(intent: Intent): IBinder? {
        // A client is binding to the service with bindService()
        Log.i(Globals.TAG, "Service onBind")
        return binder
    }

    override fun onUnbind(intent: Intent): Boolean {
        // All clients have unbound with unbindService()
        Log.i(Globals.TAG, "Service onUnbind")
        return allowRebind
    }

    override fun onRebind(intent: Intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
        Log.i(Globals.TAG, "Service onRebind")
    }

    override fun onDestroy() {
        // The service is no longer used and is being destroyed
        Log.i(Globals.TAG, "Service onDestroy")
    }
}