package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.internal.fk;
import com.google.android.gms.internal.fk.C0647a;
import com.google.android.gms.internal.gg;
import com.google.android.gms.plus.internal.C0360b.C0801a;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C0362d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d$a */
    public static abstract class C0805a extends Binder implements C0362d {

        /* renamed from: com.google.android.gms.plus.internal.d$a$a */
        private static class C0804a implements C0362d {
            private IBinder kn;

            C0804a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public fk mo2211a(C0360b c0360b, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.kn.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    fk A = C0647a.m2174A(obtain2.readStrongBinder());
                    return A;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2212a(gg ggVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (ggVar != null) {
                        obtain.writeInt(1);
                        ggVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2213a(C0360b c0360b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2214a(C0360b c0360b, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.kn.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2215a(C0360b c0360b, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
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

            /* renamed from: a */
            public void mo2216a(C0360b c0360b, gg ggVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    if (ggVar != null) {
                        obtain.writeInt(1);
                        ggVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2217a(C0360b c0360b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2218a(C0360b c0360b, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2219a(C0360b c0360b, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeStringList(list);
                    this.kn.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            /* renamed from: b */
            public void mo2220b(C0360b c0360b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    this.kn.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo2221b(C0360b c0360b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo2222c(C0360b c0360b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo2224d(C0360b c0360b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo2225e(C0360b c0360b, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(c0360b != null ? c0360b.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String iK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean iL() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String iM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.kn.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.kn.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0362d aQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0362d)) ? new C0804a(iBinder) : (C0362d) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            gg ggVar = null;
            String accountName;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2217a(C0801a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2218a(C0801a.aO(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2221b(C0801a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2212a(data.readInt() != 0 ? gg.CREATOR.m1025x(data) : null);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = getAccountName();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    clearDefaultAccount();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2213a(C0801a.aO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2215a(C0801a.aO(data.readStrongBinder()), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2214a(C0801a.aO(data.readStrongBinder()), data.readInt(), data.readString(), data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null, data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 16:
                    IBinder asBinder;
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    fk a = mo2211a(C0801a.aO(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (a != null) {
                        asBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    removeMoment(data.readString());
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2222c(C0801a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2220b(C0801a.aO(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Keys.f10F /*34*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2219a(C0801a.aO(data.readStrongBinder()), data.createStringArrayList());
                    reply.writeNoException();
                    return true;
                case Keys.f16L /*40*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2224d(C0801a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Keys.f17M /*41*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = iK();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Keys.f18N /*42*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    boolean iL = iL();
                    reply.writeNoException();
                    reply.writeInt(iL ? 1 : 0);
                    return true;
                case Keys.f19O /*43*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    accountName = iM();
                    reply.writeNoException();
                    reply.writeString(accountName);
                    return true;
                case Keys.f20P /*44*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    mo2225e(C0801a.aO(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case Keys.f21Q /*45*/:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
                    C0360b aO = C0801a.aO(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        ggVar = gg.CREATOR.m1025x(data);
                    }
                    mo2216a(aO, ggVar);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    fk mo2211a(C0360b c0360b, int i, int i2, int i3, String str) throws RemoteException;

    /* renamed from: a */
    void mo2212a(gg ggVar) throws RemoteException;

    /* renamed from: a */
    void mo2213a(C0360b c0360b) throws RemoteException;

    /* renamed from: a */
    void mo2214a(C0360b c0360b, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo2215a(C0360b c0360b, Uri uri, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo2216a(C0360b c0360b, gg ggVar) throws RemoteException;

    /* renamed from: a */
    void mo2217a(C0360b c0360b, String str) throws RemoteException;

    /* renamed from: a */
    void mo2218a(C0360b c0360b, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo2219a(C0360b c0360b, List<String> list) throws RemoteException;

    /* renamed from: b */
    void mo2220b(C0360b c0360b) throws RemoteException;

    /* renamed from: b */
    void mo2221b(C0360b c0360b, String str) throws RemoteException;

    /* renamed from: c */
    void mo2222c(C0360b c0360b, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    /* renamed from: d */
    void mo2224d(C0360b c0360b, String str) throws RemoteException;

    /* renamed from: e */
    void mo2225e(C0360b c0360b, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    String iK() throws RemoteException;

    boolean iL() throws RemoteException;

    String iM() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
