package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public interface eg extends IInterface {

    /* renamed from: com.google.android.gms.internal.eg$a */
    public static abstract class C0621a extends Binder implements eg {

        /* renamed from: com.google.android.gms.internal.eg$a$a */
        private static class C0620a implements eg {
            private IBinder kn;

            C0620a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1687a(Map map, long j, String str, List<ef> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    obtain.writeMap(map);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void bR() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: t */
        public static eg m2094t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof eg)) ? new C0620a(iBinder) : (eg) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    mo1687a(data.readHashMap(getClass().getClassLoader()), data.readLong(), data.readString(), data.createTypedArrayList(ef.CREATOR));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    bR();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                    String version = getVersion();
                    reply.writeNoException();
                    reply.writeString(version);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1687a(Map map, long j, String str, List<ef> list) throws RemoteException;

    void bR() throws RemoteException;

    String getVersion() throws RemoteException;
}
