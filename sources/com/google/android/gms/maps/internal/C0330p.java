package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* renamed from: com.google.android.gms.maps.internal.p */
public interface C0330p extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.p$a */
    public static abstract class C0760a extends Binder implements C0330p {

        /* renamed from: com.google.android.gms.maps.internal.p$a$a */
        private static class C0759a implements C0330p {
            private IBinder kn;

            C0759a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    if (camera != null) {
                        obtain.writeInt(1);
                        camera.writeToParcel(obtain, 0);
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

        public C0760a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
        }

        public static C0330p as(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0330p)) ? new C0759a(iBinder) : (C0330p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    onStreetViewPanoramaCameraChange(data.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) throws RemoteException;
}
