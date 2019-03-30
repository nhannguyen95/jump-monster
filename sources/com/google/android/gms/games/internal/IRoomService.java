package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface IRoomService extends IInterface {

    public static abstract class Stub extends Binder implements IRoomService {

        private static class Proxy implements IRoomService {
            private IBinder kn;

            /* renamed from: B */
            public void mo1438B(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(1008, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1439a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException {
                IBinder iBinder2 = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeStrongBinder(iBinder);
                    if (iRoomServiceCallbacks != null) {
                        iBinder2 = iRoomServiceCallbacks.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    this.kn.transact(1001, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1440a(DataHolder dataHolder, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(1006, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1441a(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kn.transact(1004, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1442a(byte[] bArr, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1009, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1443a(byte[] bArr, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeByteArray(bArr);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(1010, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aM(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kn.transact(1013, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void aN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    this.kn.transact(1014, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void gM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1002, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1003, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1005, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void gP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    this.kn.transact(1007, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo1450p(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1011, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo1451q(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(1012, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1001:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1439a(data.readStrongBinder(), com.google.android.gms.games.internal.IRoomServiceCallbacks.Stub.m1981Q(data.readStrongBinder()));
                    return true;
                case 1002:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gM();
                    return true;
                case 1003:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gN();
                    return true;
                case 1004:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1441a(data.readString(), data.readString(), data.readString());
                    return true;
                case 1005:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gO();
                    return true;
                case 1006:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    DataHolder createFromParcel = data.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1440a(createFromParcel, z);
                    return true;
                case 1007:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    gP();
                    return true;
                case 1008:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1438B(z);
                    return true;
                case 1009:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1442a(data.createByteArray(), data.readString(), data.readInt());
                    return true;
                case 1010:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1443a(data.createByteArray(), data.createStringArray());
                    return true;
                case 1011:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1450p(data.readString(), data.readInt());
                    return true;
                case 1012:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    mo1451q(data.readString(), data.readInt());
                    return true;
                case 1013:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    aM(data.readString());
                    return true;
                case 1014:
                    data.enforceInterface("com.google.android.gms.games.internal.IRoomService");
                    aN(data.readString());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IRoomService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: B */
    void mo1438B(boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1439a(IBinder iBinder, IRoomServiceCallbacks iRoomServiceCallbacks) throws RemoteException;

    /* renamed from: a */
    void mo1440a(DataHolder dataHolder, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1441a(String str, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo1442a(byte[] bArr, String str, int i) throws RemoteException;

    /* renamed from: a */
    void mo1443a(byte[] bArr, String[] strArr) throws RemoteException;

    void aM(String str) throws RemoteException;

    void aN(String str) throws RemoteException;

    void gM() throws RemoteException;

    void gN() throws RemoteException;

    void gO() throws RemoteException;

    void gP() throws RemoteException;

    /* renamed from: p */
    void mo1450p(String str, int i) throws RemoteException;

    /* renamed from: q */
    void mo1451q(String str, int i) throws RemoteException;
}
