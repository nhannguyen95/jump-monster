package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.maps.internal.n */
public interface C0328n extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.n$a */
    public static abstract class C0756a extends Binder implements C0328n {

        /* renamed from: com.google.android.gms.maps.internal.n$a$a */
        private static class C0755a implements C0328n {
            private IBinder kn;

            C0755a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public boolean onMyLocationButtonClick() throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0756a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
        }

        public static C0328n aq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0328n)) ? new C0755a(iBinder) : (C0328n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    boolean onMyLocationButtonClick = onMyLocationButtonClick();
                    reply.writeNoException();
                    reply.writeInt(onMyLocationButtonClick ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean onMyLocationButtonClick() throws RemoteException;
}
