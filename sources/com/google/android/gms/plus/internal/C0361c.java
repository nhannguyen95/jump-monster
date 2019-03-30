package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;

/* renamed from: com.google.android.gms.plus.internal.c */
public interface C0361c extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.c$a */
    public static abstract class C0803a extends Binder implements C0361c {

        /* renamed from: com.google.android.gms.plus.internal.c$a$a */
        private static class C0802a implements C0361c {
            private IBinder kn;

            C0802a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public C0190d mo2209a(C0190d c0190d, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public C0190d mo2210a(C0190d c0190d, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(2, obtain, obtain2, 0);
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

        public static C0361c aP(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0361c)) ? new C0802a(iBinder) : (C0361c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            C0190d a;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = mo2209a(C0575a.m1749K(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    a = mo2210a(C0575a.m1749K(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0190d mo2209a(C0190d c0190d, int i, int i2, String str, int i3) throws RemoteException;

    /* renamed from: a */
    C0190d mo2210a(C0190d c0190d, int i, int i2, String str, String str2) throws RemoteException;
}
