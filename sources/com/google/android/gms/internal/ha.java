package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.internal.gz.C0663a;
import com.google.android.gms.internal.hq.C0670a;
import com.google.android.gms.location.C0312a;
import com.google.android.gms.location.C0312a.C0696a;
import com.google.android.gms.location.C0697b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface ha extends IInterface {

    /* renamed from: com.google.android.gms.internal.ha$a */
    public static abstract class C0665a extends Binder implements ha {

        /* renamed from: com.google.android.gms.internal.ha$a$a */
        private static class C0664a implements ha {
            private IBinder kn;

            C0664a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public void mo1777a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1778a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            /* renamed from: a */
            public void mo1779a(PendingIntent pendingIntent, gz gzVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1780a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.kn.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1781a(gz gzVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1782a(hg hgVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hgVar != null) {
                        obtain.writeInt(1);
                        hgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1783a(hi hiVar, hs hsVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hiVar != null) {
                        obtain.writeInt(1);
                        hiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1784a(hk hkVar, hs hsVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hkVar != null) {
                        obtain.writeInt(1);
                        hkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1785a(ho hoVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hoVar != null) {
                        obtain.writeInt(1);
                        hoVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1786a(hs hsVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1787a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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
            public void mo1788a(LocationRequest locationRequest, C0312a c0312a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0312a != null ? c0312a.asBinder() : null);
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1789a(LocationRequest locationRequest, C0312a c0312a, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c0312a != null ? c0312a.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1790a(C0312a c0312a) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(c0312a != null ? c0312a.asBinder() : null);
                    this.kn.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1791a(LatLng latLng, hg hgVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hgVar != null) {
                        obtain.writeInt(1);
                        hgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1792a(LatLngBounds latLngBounds, int i, hg hgVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (hgVar != null) {
                        obtain.writeInt(1);
                        hgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1793a(LatLngBounds latLngBounds, int i, String str, hg hgVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (hgVar != null) {
                        obtain.writeInt(1);
                        hgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1794a(String str, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1795a(String str, LatLngBounds latLngBounds, hg hgVar, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hgVar != null) {
                        obtain.writeInt(1);
                        hgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1796a(List<hd> list, PendingIntent pendingIntent, gz gzVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1797a(String[] strArr, gz gzVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(gzVar != null ? gzVar.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location aW(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.kn.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0697b aX(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.kn.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    C0697b aB = obtain2.readInt() != 0 ? C0697b.CREATOR.aB(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return aB;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.kn;
            }

            /* renamed from: b */
            public void mo1800b(String str, hs hsVar, hq hqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (hsVar != null) {
                        obtain.writeInt(1);
                        hsVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hqVar != null ? hqVar.asBinder() : null);
                    this.kn.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location hP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    Location location = obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return location;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
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
        }

        /* renamed from: W */
        public static ha m2271W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ha)) ? new C0664a(iBinder) : (ha) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            hs hsVar = null;
            Location hP;
            LocationRequest createFromParcel;
            String readString;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1796a(data.createTypedArrayList(hd.CREATOR), data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, C0663a.m2248V(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1779a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null, C0663a.m2248V(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1797a(data.createStringArray(), C0663a.m2248V(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1781a(C0663a.m2248V(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1777a(data.readLong(), data.readInt() != 0, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    removeActivityUpdates(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hP = hP();
                    reply.writeNoException();
                    if (hP != null) {
                        reply.writeInt(1);
                        hP.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1788a(createFromParcel, C0696a.m2333U(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1787a(data.readInt() != 0 ? LocationRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1790a(C0696a.m2333U(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1778a(data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setMockMode(z);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    setMockLocation(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1792a(data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt() != 0 ? hg.CREATOR.aD(data) : null, data.readInt() != 0 ? hs.CREATOR.aI(data) : null, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1794a(readString, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLng createFromParcel2 = data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null;
                    hg aD = data.readInt() != 0 ? hg.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1791a(createFromParcel2, aD, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hg aD2 = data.readInt() != 0 ? hg.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1782a(aD2, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1784a(data.readInt() != 0 ? hk.CREATOR.aF(data) : null, data.readInt() != 0 ? hs.CREATOR.aI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1786a(data.readInt() != 0 ? hs.CREATOR.aI(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (data.readInt() != 0) {
                        createFromParcel = LocationRequest.CREATOR.createFromParcel(data);
                    }
                    mo1789a(createFromParcel, C0696a.m2333U(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hP = aW(data.readString());
                    reply.writeNoException();
                    if (hP != null) {
                        reply.writeInt(1);
                        hP.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case Keys.VOLUME_DOWN /*25*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    hi aE = data.readInt() != 0 ? hi.CREATOR.aE(data) : null;
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1783a(aE, hsVar);
                    return true;
                case Keys.POWER /*26*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1780a(data.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    return true;
                case Keys.f10F /*34*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    C0697b aX = aX(data.readString());
                    reply.writeNoException();
                    if (aX != null) {
                        reply.writeInt(1);
                        aX.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case Keys.f18N /*42*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1800b(readString, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Keys.f21Q /*45*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    mo1795a(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? hg.CREATOR.aD(data) : null, data.readInt() != 0 ? hs.CREATOR.aI(data) : null, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Keys.f22R /*46*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    ho hoVar = data.readInt() != 0 ? (ho) ho.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1785a(hoVar, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case Keys.f23S /*47*/:
                    data.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    LatLngBounds createFromParcel3 = data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null;
                    int readInt = data.readInt();
                    String readString2 = data.readString();
                    hg aD3 = data.readInt() != 0 ? hg.CREATOR.aD(data) : null;
                    if (data.readInt() != 0) {
                        hsVar = hs.CREATOR.aI(data);
                    }
                    mo1793a(createFromParcel3, readInt, readString2, aD3, hsVar, C0670a.m2281Y(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo1777a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1778a(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1779a(PendingIntent pendingIntent, gz gzVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1780a(Location location, int i) throws RemoteException;

    /* renamed from: a */
    void mo1781a(gz gzVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1782a(hg hgVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1783a(hi hiVar, hs hsVar) throws RemoteException;

    /* renamed from: a */
    void mo1784a(hk hkVar, hs hsVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1785a(ho hoVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1786a(hs hsVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1787a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo1788a(LocationRequest locationRequest, C0312a c0312a) throws RemoteException;

    /* renamed from: a */
    void mo1789a(LocationRequest locationRequest, C0312a c0312a, String str) throws RemoteException;

    /* renamed from: a */
    void mo1790a(C0312a c0312a) throws RemoteException;

    /* renamed from: a */
    void mo1791a(LatLng latLng, hg hgVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1792a(LatLngBounds latLngBounds, int i, hg hgVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1793a(LatLngBounds latLngBounds, int i, String str, hg hgVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1794a(String str, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1795a(String str, LatLngBounds latLngBounds, hg hgVar, hs hsVar, hq hqVar) throws RemoteException;

    /* renamed from: a */
    void mo1796a(List<hd> list, PendingIntent pendingIntent, gz gzVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo1797a(String[] strArr, gz gzVar, String str) throws RemoteException;

    Location aW(String str) throws RemoteException;

    C0697b aX(String str) throws RemoteException;

    /* renamed from: b */
    void mo1800b(String str, hs hsVar, hq hqVar) throws RemoteException;

    Location hP() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
