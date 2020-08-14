// IRemoteService.aidl
package com.example.remoteservice;

import com.example.remoteservice.IRemoteServiceCallback;

interface IRemoteService {
    boolean addCallback(IRemoteServiceCallback callback);
    boolean removeCallback(IRemoteServiceCallback callbac);
}
