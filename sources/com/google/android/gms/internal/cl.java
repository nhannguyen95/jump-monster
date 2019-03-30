package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;

public interface cl extends IInterface {

    /* renamed from: com.google.android.gms.internal.cl$a */
    public static abstract class C0609a extends Binder implements cl {

        /* renamed from: com.google.android.gms.internal.cl$a$a */
        private static class C0608a implements cl {
            private IBinder kn;

            C0608a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public IBinder mo1673a(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    IBinder readStrongBinder = obtain2.readStrongBinder();
                    return readStrongBinder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        /* renamed from: n */
        public static cl m2067n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof cl)) ? new C0608a(iBinder) : (cl) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    IBinder a = mo1673a(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo1673a(C0190d c0190d) throws RemoteException;
}
