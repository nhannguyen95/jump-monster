package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;
import com.google.android.gms.internal.bs.C0604a;

public interface br extends IInterface {

    /* renamed from: com.google.android.gms.internal.br$a */
    public static abstract class C0602a extends Binder implements br {

        /* renamed from: com.google.android.gms.internal.br$a$a */
        private static class C0601a implements br {
            private IBinder kn;

            C0601a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1622a(C0190d c0190d, ah ahVar, String str, bs bsVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bsVar != null) {
                        iBinder = bsVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1623a(C0190d c0190d, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bsVar != null) {
                        iBinder = bsVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1624a(C0190d c0190d, ak akVar, ah ahVar, String str, bs bsVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bsVar != null) {
                        iBinder = bsVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1625a(C0190d c0190d, ak akVar, ah ahVar, String str, String str2, bs bsVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bsVar != null) {
                        iBinder = bsVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0190d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0602a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        /* renamed from: j */
        public static br m2052j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof br)) ? new C0601a(iBinder) : (br) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ah ahVar = null;
            C0190d view;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1624a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? ak.CREATOR.m616b(data) : null, data.readInt() != 0 ? ah.CREATOR.m612a(data) : null, data.readString(), C0604a.m2054k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = getView();
                    reply.writeNoException();
                    if (view != null) {
                        asBinder = view.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    view = C0575a.m1749K(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ahVar = ah.CREATOR.m612a(data);
                    }
                    mo1622a(view, ahVar, data.readString(), C0604a.m2054k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    showInterstitial();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    destroy();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1625a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? ak.CREATOR.m616b(data) : null, data.readInt() != 0 ? ah.CREATOR.m612a(data) : null, data.readString(), data.readString(), C0604a.m2054k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    mo1623a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? ah.CREATOR.m612a(data) : null, data.readString(), data.readString(), C0604a.m2054k(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    pause();
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    resume();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1622a(C0190d c0190d, ah ahVar, String str, bs bsVar) throws RemoteException;

    /* renamed from: a */
    void mo1623a(C0190d c0190d, ah ahVar, String str, String str2, bs bsVar) throws RemoteException;

    /* renamed from: a */
    void mo1624a(C0190d c0190d, ak akVar, ah ahVar, String str, bs bsVar) throws RemoteException;

    /* renamed from: a */
    void mo1625a(C0190d c0190d, ak akVar, ah ahVar, String str, String str2, bs bsVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0190d getView() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
