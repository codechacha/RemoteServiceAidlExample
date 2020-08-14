/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.remoteservice;

import android.util.Log;

public interface IRemoteService extends android.os.IInterface
{
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements IRemoteService
  {
    private static final String DESCRIPTOR = "com.example.remoteservice.IRemoteService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.remoteservice.IRemoteService interface,
     * generating a proxy if needed.
     */
    public static IRemoteService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof IRemoteService))) {
        return ((IRemoteService)iin);
      }
      return new Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_addCallback:
        {
          data.enforceInterface(descriptor);
          IRemoteServiceCallback _arg0;
          _arg0 = IRemoteServiceCallback.Stub.asInterface(data.readStrongBinder());
          Log.d("IRemoteService", "(stub) addCallback: " + _arg0);
          boolean _result = this.addCallback(_arg0);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        case TRANSACTION_removeCallback:
        {
          data.enforceInterface(descriptor);
          IRemoteServiceCallback _arg0;
          _arg0 = IRemoteServiceCallback.Stub.asInterface(data.readStrongBinder());
          boolean _result = this.removeCallback(_arg0);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements IRemoteService
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public boolean addCallback(IRemoteServiceCallback callback) throws android.os.RemoteException
      {
        Log.d("IRemoteService", "(proxy) addCallback: " + callback);
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((callback!=null))?(callback.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_addCallback, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().addCallback(callback);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public boolean removeCallback(IRemoteServiceCallback callbac) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((callbac!=null))?(callbac.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_removeCallback, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().removeCallback(callbac);
          }
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static IRemoteService sDefaultImpl;
    }
    static final int TRANSACTION_addCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_removeCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static IRemoteService getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
  }
  public boolean addCallback(IRemoteServiceCallback callback) throws android.os.RemoteException;
  public boolean removeCallback(IRemoteServiceCallback callbac) throws android.os.RemoteException;
}
