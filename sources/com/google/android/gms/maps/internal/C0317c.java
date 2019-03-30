package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0190d.C0575a;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.C0712a;
import com.google.android.gms.maps.internal.IMapFragmentDelegate.C0718a;
import com.google.android.gms.maps.internal.IMapViewDelegate.C0720a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.C0726a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.C0728a;
import com.google.android.gms.maps.model.internal.C0346a;
import com.google.android.gms.maps.model.internal.C0346a.C0771a;

/* renamed from: com.google.android.gms.maps.internal.c */
public interface C0317c extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.c$a */
    public static abstract class C0734a extends Binder implements C0317c {

        /* renamed from: com.google.android.gms.maps.internal.c$a$a */
        private static class C0733a implements C0317c {
            private IBinder kn;

            C0733a(IBinder iBinder) {
                this.kn = iBinder;
            }

            /* renamed from: a */
            public IMapViewDelegate mo2035a(C0190d c0190d, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapViewDelegate ag = C0720a.ag(obtain2.readStrongBinder());
                    return ag;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IStreetViewPanoramaViewDelegate mo2036a(C0190d c0190d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaViewDelegate az = C0728a.az(obtain2.readStrongBinder());
                    return az;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo2037a(C0190d c0190d, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    obtain.writeInt(i);
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

            /* renamed from: g */
            public void mo2038g(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public IMapFragmentDelegate mo2039h(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    IMapFragmentDelegate af = C0718a.af(obtain2.readStrongBinder());
                    return af;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public IStreetViewPanoramaFragmentDelegate mo2040i(C0190d c0190d) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(c0190d != null ? c0190d.asBinder() : null);
                    this.kn.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    IStreetViewPanoramaFragmentDelegate ay = C0726a.ay(obtain2.readStrongBinder());
                    return ay;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate ix() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kn.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    ICameraUpdateFactoryDelegate Z = C0712a.m2344Z(obtain2.readStrongBinder());
                    return Z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0346a iy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.kn.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    C0346a aB = C0771a.aB(obtain2.readStrongBinder());
                    return aB;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static C0317c ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0317c)) ? new C0733a(iBinder) : (C0317c) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2038g(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate h = mo2039h(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    if (h != null) {
                        iBinder = h.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate a = mo2035a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a != null) {
                        iBinder = a.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate ix = ix();
                    reply.writeNoException();
                    if (ix != null) {
                        iBinder = ix.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    C0346a iy = iy();
                    reply.writeNoException();
                    if (iy != null) {
                        iBinder = iy.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    mo2037a(C0575a.m1749K(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate a2 = mo2036a(C0575a.m1749K(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate i = mo2040i(C0575a.m1749K(data.readStrongBinder()));
                    reply.writeNoException();
                    if (i != null) {
                        iBinder = i.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IMapViewDelegate mo2035a(C0190d c0190d, GoogleMapOptions googleMapOptions) throws RemoteException;

    /* renamed from: a */
    IStreetViewPanoramaViewDelegate mo2036a(C0190d c0190d, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    /* renamed from: a */
    void mo2037a(C0190d c0190d, int i) throws RemoteException;

    /* renamed from: g */
    void mo2038g(C0190d c0190d) throws RemoteException;

    /* renamed from: h */
    IMapFragmentDelegate mo2039h(C0190d c0190d) throws RemoteException;

    /* renamed from: i */
    IStreetViewPanoramaFragmentDelegate mo2040i(C0190d c0190d) throws RemoteException;

    ICameraUpdateFactoryDelegate ix() throws RemoteException;

    C0346a iy() throws RemoteException;
}
