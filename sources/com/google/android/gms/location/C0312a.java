package com.google.android.gms.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.location.a */
public interface C0312a extends IInterface {

    /* renamed from: com.google.android.gms.location.a$a */
    public static abstract class C0696a extends Binder implements C0312a {

        /* renamed from: com.google.android.gms.location.a$a$a */
        private static class C0695a implements C0312a {
            private IBinder kn;

            C0695a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void onLocationChanged(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0696a() {
            attachInterface(this, "com.google.android.gms.location.ILocationListener");
        }

        /* renamed from: U */
        public static C0312a m2333U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0312a)) ? new C0695a(iBinder) : (C0312a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.ILocationListener");
                    onLocationChanged(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.ILocationListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onLocationChanged(Location location) throws RemoteException;
}
