package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0189c;
import com.google.android.gms.dynamic.C0189c.C0573a;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;
import com.google.android.gms.internal.iz.C0677a;
import com.google.android.gms.internal.ja.C0679a;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface jc extends IInterface {

    /* renamed from: com.google.android.gms.internal.jc$a */
    public static abstract class C0683a extends Binder implements jc {

        /* renamed from: com.google.android.gms.internal.jc$a$a */
        private static class C0682a implements jc {
            private IBinder kn;

            C0682a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public iz mo1853a(C0190d c0190d, C0189c c0189c, WalletFragmentOptions walletFragmentOptions, ja jaVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    obtain.writeStrongBinder(c0189c != null ? c0189c.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jaVar != null) {
                        iBinder = jaVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    iz aS = C0677a.aS(obtain2.readStrongBinder());
                    return aS;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static jc aV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jc)) ? new C0682a(iBinder) : (jc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    iz a = mo1853a(C0575a.m1749K(data.readStrongBinder()), C0573a.m1748J(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, C0679a.aT(data.readStrongBinder()));
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    iz mo1853a(C0190d c0190d, C0189c c0189c, WalletFragmentOptions walletFragmentOptions, ja jaVar) throws RemoteException;
}
