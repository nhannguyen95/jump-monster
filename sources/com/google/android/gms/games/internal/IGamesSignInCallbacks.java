package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface IGamesSignInCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesSignInCallbacks {

        private static class Proxy implements IGamesSignInCallbacks {
            private IBinder kn;

            Proxy(IBinder remote) {
                this.kn = remote;
            }

            /* renamed from: H */
            public void mo1422H(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: I */
            public void mo1423I(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aZ(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.kn.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            /* renamed from: b */
            public void mo1425b(int i, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void ba(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    obtain.writeInt(i);
                    this.kn.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1427e(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
        }

        /* renamed from: O */
        public static IGamesSignInCallbacks m1951O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesSignInCallbacks)) ? new Proxy(iBinder) : (IGamesSignInCallbacks) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            DataHolder dataHolder = null;
            switch (code) {
                case 5001:
                    Intent intent;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    int readInt = data.readInt();
                    if (data.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(data);
                    }
                    mo1425b(readInt, intent);
                    reply.writeNoException();
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo1422H(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo1423I(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    aZ(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    if (data.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo1427e(dataHolder);
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    ba(data.readInt());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: H */
    void mo1422H(DataHolder dataHolder) throws RemoteException;

    /* renamed from: I */
    void mo1423I(DataHolder dataHolder) throws RemoteException;

    void aZ(int i) throws RemoteException;

    /* renamed from: b */
    void mo1425b(int i, Intent intent) throws RemoteException;

    void ba(int i) throws RemoteException;

    /* renamed from: e */
    void mo1427e(DataHolder dataHolder) throws RemoteException;
}
