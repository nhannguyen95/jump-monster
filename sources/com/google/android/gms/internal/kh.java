package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

public interface kh extends IInterface {

    /* renamed from: com.google.android.gms.internal.kh$a */
    public static abstract class C0688a extends Binder implements kh {
        public C0688a() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            kk kkVar = null;
            switch (code) {
                case 1:
                    DataHolder createFromParcel;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        createFromParcel = DataHolder.CREATOR.createFromParcel(data);
                    }
                    mo3179M(createFromParcel);
                    return true;
                case 2:
                    ki kiVar;
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kiVar = (ki) ki.CREATOR.createFromParcel(data);
                    }
                    mo3180a(kiVar);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kkVar = (kk) kk.CREATOR.createFromParcel(data);
                    }
                    mo3181a(kkVar);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    if (data.readInt() != 0) {
                        kkVar = (kk) kk.CREATOR.createFromParcel(data);
                    }
                    mo3182b(kkVar);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: M */
    void mo3179M(DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo3180a(ki kiVar) throws RemoteException;

    /* renamed from: a */
    void mo3181a(kk kkVar) throws RemoteException;

    /* renamed from: b */
    void mo3182b(kk kkVar) throws RemoteException;
}
