package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* renamed from: com.google.android.gms.maps.internal.q */
public interface C0331q extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.q$a */
    public static abstract class C0762a extends Binder implements C0331q {

        /* renamed from: com.google.android.gms.maps.internal.q$a$a */
        private static class C0761a implements C0331q {
            private IBinder kn;

            C0761a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
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
        }

        public C0762a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
        }

        public static C0331q at(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0331q)) ? new C0761a(iBinder) : (C0331q) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                    onStreetViewPanoramaChange(data.readInt() != 0 ? StreetViewPanoramaLocation.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) throws RemoteException;
}
