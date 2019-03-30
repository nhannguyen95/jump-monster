package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;

public interface fn extends IInterface {

    /* renamed from: com.google.android.gms.internal.fn$a */
    public static abstract class C0653a extends Binder implements fn {

        /* renamed from: com.google.android.gms.internal.fn$a$a */
        private static class C0652a implements fn {
            private IBinder kn;

            C0652a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public C0190d mo1763a(C0190d c0190d, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        /* renamed from: D */
        public static fn m2207D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof fn)) ? new C0652a(iBinder) : (fn) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0190d a = mo1763a(C0575a.m1749K(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0190d mo1763a(C0190d c0190d, int i, int i2) throws RemoteException;
}
