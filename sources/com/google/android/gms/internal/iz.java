package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public interface iz extends IInterface {

    /* renamed from: com.google.android.gms.internal.iz$a */
    public static abstract class C0677a extends Binder implements iz {

        /* renamed from: com.google.android.gms.internal.iz$a$a */
        private static class C0676a implements iz {
            private IBinder kn;

            C0676a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1831a(C0190d c0190d, WalletFragmentOptions walletFragmentOptions, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (walletFragmentOptions != null) {
                        obtain.writeInt(1);
                        walletFragmentOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            public IBinder asBinder() {
                return this.kn;
            }

            public int getState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.kn.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void initialize(WalletFragmentInitParams initParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    if (initParams != null) {
                        obtain.writeInt(1);
                        initParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onActivityResult(int requestCode, int resultCode, Intent data) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    obtain.writeInt(requestCode);
                    obtain.writeInt(resultCode);
                    if (data != null) {
                        obtain.writeInt(1);
                        data.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0190d onCreateView(C0190d inflaterWrapper, C0190d containerWrapper, Bundle savedInstanceState) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    obtain.writeStrongBinder(inflaterWrapper != null ? inflaterWrapper.asBinder() : null);
                    if (containerWrapper != null) {
                        iBinder = containerWrapper.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSaveInstanceState(Bundle outState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        outState.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStart() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setEnabled(boolean enabled) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    if (enabled) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateMaskedWalletRequest(MaskedWalletRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static iz aS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof iz)) ? new C0676a(iBinder) : (iz) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    mo1831a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? (WalletFragmentOptions) WalletFragmentOptions.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onCreate(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    C0190d onCreateView = onCreateView(C0575a.m1749K(data.readStrongBinder()), C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (onCreateView != null) {
                        iBinder = onCreateView.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onStart();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onResume();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onPause();
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onStop();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    Bundle bundle = data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null;
                    onSaveInstanceState(bundle);
                    reply.writeNoException();
                    if (bundle != null) {
                        reply.writeInt(1);
                        bundle.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    onActivityResult(data.readInt(), data.readInt(), data.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    initialize(data.readInt() != 0 ? (WalletFragmentInitParams) WalletFragmentInitParams.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    updateMaskedWalletRequest(data.readInt() != 0 ? (MaskedWalletRequest) MaskedWalletRequest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    setEnabled(data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    int state = getState();
                    reply.writeNoException();
                    reply.writeInt(state);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wallet.fragment.internal.IWalletFragmentDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1831a(C0190d c0190d, WalletFragmentOptions walletFragmentOptions, Bundle bundle) throws RemoteException;

    int getState() throws RemoteException;

    void initialize(WalletFragmentInitParams walletFragmentInitParams) throws RemoteException;

    void onActivityResult(int i, int i2, Intent intent) throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    C0190d onCreateView(C0190d c0190d, C0190d c0190d2, Bundle bundle) throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;

    void onStart() throws RemoteException;

    void onStop() throws RemoteException;

    void setEnabled(boolean z) throws RemoteException;

    void updateMaskedWalletRequest(MaskedWalletRequest maskedWalletRequest) throws RemoteException;
}
