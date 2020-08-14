/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.remoteservice;

import android.util.Log;

public interface IRemoteServiceCallback extends android.os.IInterface
{
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements IRemoteServiceCallback
  {
    private static final String DESCRIPTOR = "com.example.remoteservice.IRemoteServiceCallback";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.remoteservice.IRemoteServiceCallback interface,
     * generating a proxy if needed.
     */
    public static IRemoteServiceCallback asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof IRemoteServiceCallback))) {
        return ((IRemoteServiceCallback)iin);
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
        case TRANSACTION_onItemAdded:
        {
          data.enforceInterface(descriptor);
          String _arg0;
          _arg0 = data.readString();
          Log.d("IRemoteServiceCallback", "(stub) onItemAdded: " + _arg0);
          this.onItemAdded(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_onItemRemoved:
        {
          data.enforceInterface(descriptor);
          String _arg0;
          _arg0 = data.readString();
          this.onItemRemoved(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements IRemoteServiceCallback
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
      @Override public void onItemAdded(String name) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(name);
          Log.d("IRemoteServiceCallback", "(proxy) onItemAdded: " + name);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onItemAdded, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onItemAdded(name);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void onItemRemoved(String name) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(name);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onItemRemoved, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().onItemRemoved(name);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static IRemoteServiceCallback sDefaultImpl;
    }
    static final int TRANSACTION_onItemAdded = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onItemRemoved = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static IRemoteServiceCallback getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
  }
  public void onItemAdded(String name) throws android.os.RemoteException;
  public void onItemRemoved(String name) throws android.os.RemoteException;
}
