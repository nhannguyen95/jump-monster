package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.jd.C0685a;
import com.google.android.gms.internal.je.C0687a;
import com.google.android.gms.wallet.C0851d;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public interface jb extends IInterface {

    /* renamed from: com.google.android.gms.internal.jb$a */
    public static abstract class C0681a extends Binder implements jb {

        /* renamed from: com.google.android.gms.internal.jb$a$a */
        private static class C0680a implements jb {
            private IBinder kn;

            C0680a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1845a(Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1846a(iv ivVar, Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (ivVar != null) {
                        obtain.writeInt(1);
                        ivVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1847a(FullWalletRequest fullWalletRequest, Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (fullWalletRequest != null) {
                        obtain.writeInt(1);
                        fullWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1848a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jd jdVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jdVar != null) {
                        iBinder = jdVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1849a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (maskedWalletRequest != null) {
                        obtain.writeInt(1);
                        maskedWalletRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1850a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (notifyTransactionStatusRequest != null) {
                        obtain.writeInt(1);
                        notifyTransactionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1851a(C0851d c0851d, Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    if (c0851d != null) {
                        obtain.writeInt(1);
                        c0851d.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1852a(String str, String str2, Bundle bundle, je jeVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.internal.IOwService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (jeVar != null) {
                        iBinder = jeVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }
        }

        public static jb aU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof jb)) ? new C0680a(iBinder) : (jb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1849a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1847a(data.readInt() != 0 ? (FullWalletRequest) FullWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1852a(data.readString(), data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1850a(data.readInt() != 0 ? (NotifyTransactionStatusRequest) NotifyTransactionStatusRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1845a(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1851a(data.readInt() != 0 ? (C0851d) C0851d.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1848a(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0685a.aW(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wallet.internal.IOwService");
                    mo1846a(data.readInt() != 0 ? (iv) iv.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, C0687a.aX(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.internal.IOwService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1845a(Bundle bundle, je jeVar) throws RemoteException;

    /* renamed from: a */
    void mo1846a(iv ivVar, Bundle bundle, je jeVar) throws RemoteException;

    /* renamed from: a */
    void mo1847a(FullWalletRequest fullWalletRequest, Bundle bundle, je jeVar) throws RemoteException;

    /* renamed from: a */
    void mo1848a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, jd jdVar) throws RemoteException;

    /* renamed from: a */
    void mo1849a(MaskedWalletRequest maskedWalletRequest, Bundle bundle, je jeVar) throws RemoteException;

    /* renamed from: a */
    void mo1850a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1851a(C0851d c0851d, Bundle bundle, je jeVar) throws RemoteException;

    /* renamed from: a */
    void mo1852a(String str, String str2, Bundle bundle, je jeVar) throws RemoteException;
}
