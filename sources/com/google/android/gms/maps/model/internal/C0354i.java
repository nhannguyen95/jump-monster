package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: com.google.android.gms.maps.model.internal.i */
public interface C0354i extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.i$a */
    public static abstract class C0787a extends Binder implements C0354i {

        /* renamed from: com.google.android.gms.maps.model.internal.i$a$a */
        private static class C0786a implements C0354i {
            private IBinder kn;

            C0786a(IBinder iBinder) {
                this.kn = iBinder;
            }

            public IBinder asBinder() {
                return this.kn;
            }

            public Tile getTile(int x, int y, int zoom) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    obtain.writeInt(x);
                    obtain.writeInt(y);
                    obtain.writeInt(zoom);
                    this.kn.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    Tile createFromParcel = obtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0787a() {
            attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        public static C0354i aK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0354i)) ? new C0786a(iBinder) : (C0354i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    Tile tile = getTile(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (tile != null) {
                        reply.writeInt(1);
                        tile.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Tile getTile(int i, int i2, int i3) throws RemoteException;
}
