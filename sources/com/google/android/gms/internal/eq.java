package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface eq extends IInterface {

    /* renamed from: com.google.android.gms.internal.eq$a */
    public static abstract class C0629a extends Binder implements eq {
        public C0629a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2907z(data.readInt());
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    ApplicationMetadata applicationMetadata = data.readInt() != 0 ? (ApplicationMetadata) ApplicationMetadata.CREATOR.createFromParcel(data) : null;
                    String readString = data.readString();
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo2900a(applicationMetadata, readString, readString2, z);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2897A(data.readInt());
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    String readString3 = data.readString();
                    double readDouble = data.readDouble();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo2903b(readString3, readDouble, z);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2905d(data.readString(), data.readString());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2904b(data.readString(), data.createByteArray());
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2899C(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2898B(data.readInt());
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    onApplicationDisconnected(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2902a(data.readString(), data.readLong(), data.readInt());
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    mo2901a(data.readString(), data.readLong());
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: A */
    void mo2897A(int i) throws RemoteException;

    /* renamed from: B */
    void mo2898B(int i) throws RemoteException;

    /* renamed from: C */
    void mo2899C(int i) throws RemoteException;

    /* renamed from: a */
    void mo2900a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo2901a(String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo2902a(String str, long j, int i) throws RemoteException;

    /* renamed from: b */
    void mo2903b(String str, double d, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo2904b(String str, byte[] bArr) throws RemoteException;

    /* renamed from: d */
    void mo2905d(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;

    /* renamed from: z */
    void mo2907z(int i) throws RemoteException;
}
