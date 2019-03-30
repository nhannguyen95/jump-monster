package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.dynamic.C0190d.C0575a;

/* renamed from: com.google.android.gms.dynamic.c */
public interface C0189c extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.c$a */
    public static abstract class C0573a extends Binder implements C0189c {

        /* renamed from: com.google.android.gms.dynamic.c$a$a */
        private static class C0572a implements C0189c {
            private IBinder kn;

            C0572a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            /* renamed from: b */
            public void mo1165b(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1166c(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0190d fX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0189c fY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0189c J = C0573a.m1748J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0190d fZ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0189c ga() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    C0189c J = C0573a.m1748J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getArguments() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getRetainInstance() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(7, obtain, obtain2, 0);
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

            public String getTag() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean getUserVisibleHint() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(11, obtain, obtain2, 0);
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

            public C0190d getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    C0190d K = C0575a.m1749K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isAdded() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(13, obtain, obtain2, 0);
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

            public boolean isDetached() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(14, obtain, obtain2, 0);
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

            public boolean isHidden() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(15, obtain, obtain2, 0);
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

            public boolean isInLayout() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(16, obtain, obtain2, 0);
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

            public boolean isRemoving() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(17, obtain, obtain2, 0);
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

            public boolean isResumed() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(18, obtain, obtain2, 0);
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

            public boolean isVisible() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    this.kn.transact(19, obtain, obtain2, 0);
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

            public void setHasOptionsMenu(boolean hasMenu) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (hasMenu) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMenuVisibility(boolean menuVisible) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (menuVisible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRetainInstance(boolean retain) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (retain) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserVisibleHint(boolean isVisibleToUser) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (isVisibleToUser) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startActivityForResult(Intent intent, int requestCode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(requestCode);
                    this.kn.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0573a() {
            attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
        }

        /* renamed from: J */
        public static C0189c m1748J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0189c)) ? new C0572a(iBinder) : (C0189c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Intent intent = null;
            boolean z = false;
            C0190d fX;
            IBinder asBinder;
            int id;
            C0189c fY;
            boolean retainInstance;
            int i;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    fX = fX();
                    reply.writeNoException();
                    if (fX != null) {
                        asBinder = fX.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    Bundle arguments = getArguments();
                    reply.writeNoException();
                    if (arguments != null) {
                        reply.writeInt(1);
                        arguments.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    id = getId();
                    reply.writeNoException();
                    reply.writeInt(id);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    fY = fY();
                    reply.writeNoException();
                    if (fY != null) {
                        asBinder = fY.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    fX = fZ();
                    reply.writeNoException();
                    if (fX != null) {
                        asBinder = fX.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = getRetainInstance();
                    reply.writeNoException();
                    reply.writeInt(retainInstance ? 1 : 0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    String tag = getTag();
                    reply.writeNoException();
                    reply.writeString(tag);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    fY = ga();
                    reply.writeNoException();
                    if (fY != null) {
                        asBinder = fY.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    id = getTargetRequestCode();
                    reply.writeNoException();
                    reply.writeInt(id);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = getUserVisibleHint();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    fX = getView();
                    reply.writeNoException();
                    if (fX != null) {
                        asBinder = fX.asBinder();
                    }
                    reply.writeStrongBinder(asBinder);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isAdded();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isDetached();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isHidden();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isInLayout();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isRemoving();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isResumed();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    retainInstance = isVisible();
                    reply.writeNoException();
                    if (retainInstance) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    mo1165b(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setHasOptionsMenu(z);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMenuVisibility(z);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setRetainInstance(z);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setUserVisibleHint(z);
                    reply.writeNoException();
                    return true;
                case Keys.VOLUME_DOWN /*25*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(data);
                    }
                    startActivity(intent);
                    reply.writeNoException();
                    return true;
                case Keys.POWER /*26*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    if (data.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(data);
                    }
                    startActivityForResult(intent, data.readInt());
                    reply.writeNoException();
                    return true;
                case Keys.CAMERA /*27*/:
                    data.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
                    mo1166c(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    void mo1165b(C0190d c0190d) throws RemoteException;

    /* renamed from: c */
    void mo1166c(C0190d c0190d) throws RemoteException;

    C0190d fX() throws RemoteException;

    C0189c fY() throws RemoteException;

    C0190d fZ() throws RemoteException;

    C0189c ga() throws RemoteException;

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    C0190d getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;
}
