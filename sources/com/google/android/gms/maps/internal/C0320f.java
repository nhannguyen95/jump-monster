package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0349d;
import com.google.android.gms.maps.model.internal.C0349d.C0777a;

/* renamed from: com.google.android.gms.maps.internal.f */
public interface C0320f extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.f$a */
    public static abstract class C0740a extends Binder implements C0320f {

        /* renamed from: com.google.android.gms.maps.internal.f$a$a */
        private static class C0739a implements C0320f {
            private IBinder kn;

            C0739a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo2046a(C0349d c0349d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(c0349d != null ? c0349d.asBinder() : null);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void onIndoorBuildingFocused() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0740a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static C0320f ai(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0320f)) ? new C0739a(iBinder) : (C0320f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    mo2046a(C0777a.aE(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo2046a(C0349d c0349d) throws RemoteException;

    void onIndoorBuildingFocused() throws RemoteException;
}
