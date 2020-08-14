package com.example.remoteservice

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.util.Log

class RemoteService : Service() {
    companion object {
        const val TAG = "RemoteService"
    }

    val listeners = arrayListOf<IRemoteServiceCallback>()
    private val binder = object : IRemoteService.Stub() {
        override fun addCallback(callback: IRemoteServiceCallback): Boolean {
            Log.d(TAG, "Add callback : $callback")
            listeners.add(callback)
            return true;
        }

        override fun removeCallback(callback: IRemoteServiceCallback?): Boolean {
            Log.d(TAG, "Remove callback : $callback")
            listeners.remove(callback)
            return true;
        }
    }

    private val runnable = {
        Log.d(TAG, "running runnable")

    }

    override fun onBind(p0: Intent?): IBinder? {
        handler.sendEmptyMessageDelayed(0, 5000)
        return binder
    }

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            listeners.forEach { listener ->
                listener.onItemAdded("new item");
                listener.onItemAdded("old item");
            }
            sendEmptyMessageDelayed(0, 5000)
        }
    }

}