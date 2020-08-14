package com.example.remoteservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log

@Suppress("JAVA_CLASS_ON_COMPANION")
class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private var bound = false;
    private var iRemoteService: IRemoteService? = null

    private var callback = object : IRemoteServiceCallback.Stub() {
        override fun onItemAdded(name: String?) {
            Log.d(TAG, "onItemAdded: $name")
            bound = true
        }

        override fun onItemRemoved(name: String?) {
            Log.d(TAG, "onItemRemoved: $name")
            bound = false
        }

    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            Log.d(TAG, "onServiceConnected: $className")
            iRemoteService = IRemoteService.Stub.asInterface(service)
            iRemoteService!!.addCallback(callback)
        }

        override fun onServiceDisconnected(className: ComponentName) {
            Log.d(TAG, "onServiceDisconnected: $className")
            iRemoteService = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (!bound) {
            val intent = Intent(this, RemoteService::class.java)
            bindService(intent, connection, Context.BIND_AUTO_CREATE);
        }
    }

    override fun onStop() {
        super.onStop()
        if (bound) {
            iRemoteService!!.removeCallback(callback)
            unbindService(connection)
        }
    }
}