package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface db extends IInterface {

    /* renamed from: com.google.android.gms.internal.db$a */
    public static abstract class C0615a extends Binder implements db {

        /* renamed from: com.google.android.gms.internal.db$a$a */
        private static class C0614a implements db {
            private IBinder kn;

            C0614a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            /* renamed from: b */
            public cz mo1684b(cx cxVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (cxVar != null) {
                        obtain.writeInt(1);
                        cxVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    cz g = obtain2.readInt() != 0 ? cz.CREATOR.m722g(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return g;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0615a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        /* renamed from: s */
        public static db m2086s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof db)) ? new C0614a(iBinder) : (db) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    cz b = mo1684b(data.readInt() != 0 ? cx.CREATOR.m719f(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    cz mo1684b(cx cxVar) throws RemoteException;
}
