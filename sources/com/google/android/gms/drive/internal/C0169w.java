package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.internal.w */
public interface C0169w extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.w$a */
    public static abstract class C0564a extends Binder implements C0169w {

        /* renamed from: com.google.android.gms.drive.internal.w$a$a */
        private static class C0563a implements C0169w {
            private IBinder kn;

            C0563a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1155a(OnEventResponse onEventResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
                    if (onEventResponse != null) {
                        obtain.writeInt(1);
                        onEventResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
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
        }

        public C0564a() {
            attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
        }

        /* renamed from: I */
        public static C0169w m1728I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0169w)) ? new C0563a(iBinder) : (C0169w) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
                    mo1155a(data.readInt() != 0 ? (OnEventResponse) OnEventResponse.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1155a(OnEventResponse onEventResponse) throws RemoteException;
}
