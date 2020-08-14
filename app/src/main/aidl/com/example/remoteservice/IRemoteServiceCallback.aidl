// IRemoteServiceListener.aidl
package com.example.remoteservice;

interface IRemoteServiceCallback {
    void onItemAdded(String name);
    void onItemRemoved(String name);
}
