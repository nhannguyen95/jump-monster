package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;

public interface IGamesService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesService {

        private static class Proxy implements IGamesService {
            private IBinder kn;

            Proxy(IBinder remote) {
                this.kn = remote;
            }

            /* renamed from: A */
            public void mo1272A(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo1273a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1274a(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.kn.transact(9008, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1275a(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.kn.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1276a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1277a(GameRequestCluster gameRequestCluster, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.kn.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1278a(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.kn.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo1279a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1280a(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1281a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1282a(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1283a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    this.kn.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1284a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.kn.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1285a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.kn.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1286a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1287a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1288a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.kn.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1289a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kn.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1290a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1291a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kn.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1292a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.kn.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1293a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.kn.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1294a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1295a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1296a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kn.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1297a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1298a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1299a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1300a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1301a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.kn.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1302a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.kn.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1303a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.kn.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1304a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1305a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1306a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.kn.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1307a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.kn.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1308a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kn.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1309a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1310a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1311a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(GamesActivityResultCodes.RESULT_INVALID_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1312a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1313a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.kn.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1314a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.kn.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1315a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.kn.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1316a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.kn.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1317a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1318a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1319a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.kn.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo1320a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent aA(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(9004, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String aD(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String aE(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int aG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Uri aH(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    Uri uri = obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return uri;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aI(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelFileDescriptor aJ(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.kn.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void aY(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.kn.transact(5036, obtain, obtain2, 0);
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
            public int mo1330b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public Intent mo1331b(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.kn.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1332b(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1333b(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1334b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1335b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kn.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1336b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1337b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1338b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kn.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1339b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1340b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1341b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1342b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1343b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1344b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.kn.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1345b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1346b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1347b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1348b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo1349b(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.kn.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1350c(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1351c(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1352c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1353c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.kn.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1354c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.kn.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1355c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1356c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1357c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1358c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1359c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1360c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.kn.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo1361c(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.kn.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1362d(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1363d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1364d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1365d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1366d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo1367d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle dG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5004, obtain, obtain2, 0);
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

            /* renamed from: e */
            public void mo1369e(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1370e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.kn.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1371e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo1372e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public ParcelFileDescriptor mo1373f(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.kn.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, obtain, obtain2, 0);
                    obtain2.readException();
                    ParcelFileDescriptor parcelFileDescriptor = obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return parcelFileDescriptor;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1374f(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo1375f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo1376g(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo1377g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int gA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int gC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int gD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DataHolder gG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder createFromParcel = obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean gH() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5067, obtain, obtain2, 0);
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

            public DataHolder gI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    DataHolder createFromParcel = obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gJ() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void gL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(11002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String gl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String gm() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9003, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9005, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9006, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9007, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Intent gx() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    Intent intent = obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return intent;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int gy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String gz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.kn.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public RoomEntity mo1399h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                RoomEntity roomEntity = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        roomEntity = (RoomEntity) RoomEntity.CREATOR.createFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return roomEntity;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo1400h(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo1401i(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo1402i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo1403j(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.kn.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo1404j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo1405j(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo1406k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo1407k(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.kn.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo1408l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo1409l(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo1410m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo1411m(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo1412n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo1413n(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo1414o(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kn.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo1415o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo1416o(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.kn.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo1417p(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kn.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo1418p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo1419q(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kn.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo1420q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.kn.transact(9002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo1421r(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.kn.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        /* renamed from: N */
        public static IGamesService m1946N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesService)) ? new Proxy(iBinder) : (IGamesService) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            ZInvitationCluster zInvitationCluster = null;
            boolean z = false;
            String gz;
            DataHolder gG;
            IGamesCallbacks M;
            int readInt;
            boolean z2;
            String readString;
            int readInt2;
            IBinder readStrongBinder;
            Bundle bundle;
            String[] createStringArray;
            int a;
            String readString2;
            int readInt3;
            int readInt4;
            int readInt5;
            IGamesCallbacks M2;
            String readString3;
            ParcelFileDescriptor f;
            Intent gp;
            switch (code) {
                case 5001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1414o(data.readLong());
                    reply.writeNoException();
                    return true;
                case 5002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1282a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gz = gz();
                    reply.writeNoException();
                    reply.writeString(gz);
                    return true;
                case 5004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Bundle dG = dG();
                    reply.writeNoException();
                    if (dG != null) {
                        reply.writeInt(1);
                        dG.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1281a(data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gF();
                    reply.writeNoException();
                    return true;
                case 5007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gz = gl();
                    reply.writeNoException();
                    reply.writeString(gz);
                    return true;
                case 5012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gz = gm();
                    reply.writeNoException();
                    reply.writeString(gz);
                    return true;
                case 5013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gG = gG();
                    reply.writeNoException();
                    if (gG != null) {
                        reply.writeInt(1);
                        gG.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1294a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1287a(M, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1302a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1333b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1337b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1296a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1338b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1291a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1351c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1304a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1342b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readStrongBinder(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    readStrongBinder = data.readStrongBinder();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo1297a(M, readString, readInt2, readStrongBinder, bundle);
                    reply.writeNoException();
                    return true;
                case 5026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1362d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1369e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1411m(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5029:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1409l(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    IBinder readStrongBinder2 = data.readStrongBinder();
                    readInt2 = data.readInt();
                    createStringArray = data.createStringArray();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo1292a(M, readStrongBinder2, readInt2, createStringArray, bundle, data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5031:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1293a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readStrongBinder(), data.readString(), data.readInt() != 0, data.readLong());
                    reply.writeNoException();
                    return true;
                case 5032:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1355c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5033:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = mo1273a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.createByteArray(), data.readString(), data.readString());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5034:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = mo1330b(data.createByteArray(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5035:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gz = aE(data.readString());
                    reply.writeNoException();
                    reply.writeString(gz);
                    return true;
                case 5036:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    aY(data.readInt());
                    reply.writeNoException();
                    return true;
                case 5037:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1364d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5038:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1305a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5039:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    readInt5 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1308a(M, readString, readString2, readInt3, readInt4, readInt5, z);
                    reply.writeNoException();
                    return true;
                case 5040:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString = data.readString();
                    readString2 = data.readString();
                    readInt3 = data.readInt();
                    readInt4 = data.readInt();
                    readInt5 = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1344b(M, readString, readString2, readInt3, readInt4, readInt5, z);
                    reply.writeNoException();
                    return true;
                case 5041:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1343b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5042:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1371e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5043:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1375f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5044:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1285a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5045:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1299a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5046:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1334b(M, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5047:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1374f(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5048:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1352c(M, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case 5049:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1376g(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5050:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    aF(data.readString());
                    reply.writeNoException();
                    return true;
                case 5051:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1349b(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5052:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1377g(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5053:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    RoomEntity h = mo1399h(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    if (h != null) {
                        reply.writeInt(1);
                        h.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5054:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1312a(M2, readString3, z);
                    reply.writeNoException();
                    return true;
                case 5055:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1413n(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 5056:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1400h(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5057:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1404j(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5058:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1289a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 5059:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1417p(data.readLong());
                    reply.writeNoException();
                    return true;
                case 5060:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = aG(data.readString());
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 5061:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1402i(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 5062:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1401i(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 5063:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1318a(M, z, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 5064:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gz = aD(data.readString());
                    reply.writeNoException();
                    reply.writeString(gz);
                    return true;
                case 5065:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1405j(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 5066:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    Uri aH = aH(data.readString());
                    reply.writeNoException();
                    if (aH != null) {
                        reply.writeInt(1);
                        aH.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5067:
                    int i;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    z2 = gH();
                    reply.writeNoException();
                    if (z2) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 5068:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1272A(z);
                    reply.writeNoException();
                    return true;
                case 5501:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1341b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 5502:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gG = gI();
                    reply.writeNoException();
                    if (gG != null) {
                        reply.writeInt(1);
                        gG.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER /*6001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1317a(M2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /*6002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1310a(M2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /*6003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1363d(M, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION /*6004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1370e(M, readInt, z2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH /*6501*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    boolean z3 = data.readInt() != 0;
                    boolean z4 = data.readInt() != 0;
                    boolean z5 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1300a(M, readString, readInt2, z3, z4, z5, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE /*6502*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1346b(M2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION /*6503*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1347b(M2, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS /*6504*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1358c(M2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED /*6505*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1367d(M2, readString3, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_NOT_FOUND /*6506*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1345b(M2, readString3, readString, z);
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED /*6507*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f = mo1373f(data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (f != null) {
                        reply.writeInt(1);
                        f.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED /*7001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1406k(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID /*7002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1303a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED /*7003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString = data.readString();
                    readInt2 = data.readInt();
                    readStrongBinder = data.readStrongBinder();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo1339b(M, readString, readInt2, readStrongBinder, bundle);
                    reply.writeNoException();
                    return true;
                case 8001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1306a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    aI(data.readString());
                    reply.writeNoException();
                    return true;
                case 8003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1319a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 8004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readInt = data.readInt();
                    readInt2 = data.readInt();
                    createStringArray = data.createStringArray();
                    if (data.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    mo1286a(M, readInt, readInt2, createStringArray, bundle);
                    reply.writeNoException();
                    return true;
                case 8005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1408l(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1410m(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1313a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.createByteArray(), data.readString(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1314a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.createByteArray(), (ParticipantResult[]) data.createTypedArray(ParticipantResult.CREATOR));
                    reply.writeNoException();
                    return true;
                case 8009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1412n(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1415o(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1357c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1335b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case 8013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1419q(data.readLong());
                    reply.writeNoException();
                    return true;
                case 8014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1418p(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 8015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1366d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1372e(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1315a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 8018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1290a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1280a(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1336b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1332b(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8022:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gJ();
                    reply.writeNoException();
                    return true;
                case 8023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1298a(M2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 8024:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = gA();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 8025:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1407k(data.readString(), data.readString());
                    reply.writeNoException();
                    return true;
                case 8026:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1361c(data.readString(), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 8027:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1359c(M2, z);
                    reply.writeNoException();
                    return true;
                case 9001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1356c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1420q(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 9003:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gp();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9004:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = aA(data.readString());
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9005:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gq();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9006:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gr();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9007:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gs();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9008:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = mo1274a(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = mo1331b(data.readInt(), data.readInt(), data.readInt() != 0);
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gw();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = mo1278a(data.readInt() != 0 ? (RoomEntity) RoomEntity.CREATOR.createFromParcel(data) : null, data.readInt());
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gx();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gK();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = gy();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 9020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1365d(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9028:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1309a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt() != 0, data.readInt() != 0);
                    reply.writeNoException();
                    return true;
                case 9030:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    f = aJ(data.readString());
                    reply.writeNoException();
                    if (f != null) {
                        reply.writeInt(1);
                        f.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9031:
                    Uri uri;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    ParticipantEntity[] participantEntityArr = (ParticipantEntity[]) data.createTypedArray(ParticipantEntity.CREATOR);
                    readString = data.readString();
                    readString2 = data.readString();
                    Uri uri2 = data.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        uri = (Uri) Uri.CREATOR.createFromParcel(data);
                    }
                    gp = mo1279a(participantEntityArr, readString, readString2, uri2, uri);
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1353c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1421r(data.readLong());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1354c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1350c(data.readLong(), data.readString());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1316a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.createStringArray(), data.readInt(), data.createByteArray(), data.readInt());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /*10006*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1320a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED /*10007*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1348b(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case GamesActivityResultCodes.RESULT_INVALID_ROOM /*10008*/:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1311a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString(), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10009:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1284a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10010:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1307a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readString(), data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10011:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1295a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10012:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = mo1275a(data.readInt(), data.createByteArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10013:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = gC();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 10014:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1416o(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10015:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gp = gB();
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10016:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1283a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 10017:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    M2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder());
                    readString3 = data.readString();
                    readInt = data.readInt();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo1340b(M2, readString3, readInt, z);
                    reply.writeNoException();
                    return true;
                case 10018:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1288a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10019:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1301a(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.readString(), data.readInt(), data.createIntArray());
                    reply.writeNoException();
                    return true;
                case 10020:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1360c(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()), data.createStringArray());
                    reply.writeNoException();
                    return true;
                case 10021:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        zInvitationCluster = ZInvitationCluster.CREATOR.as(data);
                    }
                    gp = mo1276a(zInvitationCluster, data.readString(), data.readString());
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10022:
                    GameRequestCluster at;
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    if (data.readInt() != 0) {
                        at = GameRequestCluster.CREATOR.at(data);
                    }
                    gp = mo1277a(at, data.readString());
                    reply.writeNoException();
                    if (gp != null) {
                        reply.writeInt(1);
                        gp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10023:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    a = gD();
                    reply.writeNoException();
                    reply.writeInt(a);
                    return true;
                case 11001:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    mo1403j(com.google.android.gms.games.internal.IGamesCallbacks.Stub.m1826M(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 11002:
                    data.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    gL();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: A */
    void mo1272A(boolean z) throws RemoteException;

    /* renamed from: a */
    int mo1273a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo1274a(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: a */
    Intent mo1275a(int i, byte[] bArr, int i2, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo1276a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo1277a(GameRequestCluster gameRequestCluster, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo1278a(RoomEntity roomEntity, int i) throws RemoteException;

    /* renamed from: a */
    Intent mo1279a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    /* renamed from: a */
    void mo1280a(long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo1281a(IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1282a(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: a */
    void mo1283a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException;

    /* renamed from: a */
    void mo1284a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo1285a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo1286a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1287a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo1288a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo1289a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: a */
    void mo1290a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo1291a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo1292a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo1293a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo1294a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: a */
    void mo1295a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    /* renamed from: a */
    void mo1296a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1297a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1298a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1299a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo1300a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    /* renamed from: a */
    void mo1301a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo1302a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo1303a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException;

    /* renamed from: a */
    void mo1304a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1305a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo1306a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo1307a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo1308a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1309a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo1310a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1311a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo1312a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1313a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo1314a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo1315a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo1316a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    /* renamed from: a */
    void mo1317a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo1318a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo1319a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo1320a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    Intent aA(String str) throws RemoteException;

    String aD(String str) throws RemoteException;

    String aE(String str) throws RemoteException;

    void aF(String str) throws RemoteException;

    int aG(String str) throws RemoteException;

    Uri aH(String str) throws RemoteException;

    void aI(String str) throws RemoteException;

    ParcelFileDescriptor aJ(String str) throws RemoteException;

    void aY(int i) throws RemoteException;

    /* renamed from: b */
    int mo1330b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    Intent mo1331b(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1332b(long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo1333b(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: b */
    void mo1334b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo1335b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: b */
    void mo1336b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo1337b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: b */
    void mo1338b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1339b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo1340b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1341b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo1342b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo1343b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo1344b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1345b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1346b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1347b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo1348b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo1349b(String str, String str2, int i) throws RemoteException;

    /* renamed from: c */
    void mo1350c(long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo1351c(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: c */
    void mo1352c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo1353c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: c */
    void mo1354c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo1355c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: c */
    void mo1356c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo1357c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo1358c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo1359c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo1360c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo1361c(String str, String str2, int i) throws RemoteException;

    /* renamed from: d */
    void mo1362d(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: d */
    void mo1363d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo1364d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: d */
    void mo1365d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo1366d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: d */
    void mo1367d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    Bundle dG() throws RemoteException;

    /* renamed from: e */
    void mo1369e(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: e */
    void mo1370e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo1371e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: e */
    void mo1372e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: f */
    ParcelFileDescriptor mo1373f(Uri uri) throws RemoteException;

    /* renamed from: f */
    void mo1374f(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: f */
    void mo1375f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: g */
    void mo1376g(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: g */
    void mo1377g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    int gA() throws RemoteException;

    Intent gB() throws RemoteException;

    int gC() throws RemoteException;

    int gD() throws RemoteException;

    void gF() throws RemoteException;

    DataHolder gG() throws RemoteException;

    boolean gH() throws RemoteException;

    DataHolder gI() throws RemoteException;

    void gJ() throws RemoteException;

    Intent gK() throws RemoteException;

    void gL() throws RemoteException;

    String gl() throws RemoteException;

    String gm() throws RemoteException;

    Intent gp() throws RemoteException;

    Intent gq() throws RemoteException;

    Intent gr() throws RemoteException;

    Intent gs() throws RemoteException;

    Intent gw() throws RemoteException;

    Intent gx() throws RemoteException;

    int gy() throws RemoteException;

    String gz() throws RemoteException;

    /* renamed from: h */
    RoomEntity mo1399h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: h */
    void mo1400h(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: i */
    void mo1401i(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: i */
    void mo1402i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: j */
    void mo1403j(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: j */
    void mo1404j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: j */
    void mo1405j(String str, String str2) throws RemoteException;

    /* renamed from: k */
    void mo1406k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: k */
    void mo1407k(String str, String str2) throws RemoteException;

    /* renamed from: l */
    void mo1408l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: l */
    void mo1409l(String str, int i) throws RemoteException;

    /* renamed from: m */
    void mo1410m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: m */
    void mo1411m(String str, int i) throws RemoteException;

    /* renamed from: n */
    void mo1412n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: n */
    void mo1413n(String str, int i) throws RemoteException;

    /* renamed from: o */
    void mo1414o(long j) throws RemoteException;

    /* renamed from: o */
    void mo1415o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: o */
    void mo1416o(String str, int i) throws RemoteException;

    /* renamed from: p */
    void mo1417p(long j) throws RemoteException;

    /* renamed from: p */
    void mo1418p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: q */
    void mo1419q(long j) throws RemoteException;

    /* renamed from: q */
    void mo1420q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: r */
    void mo1421r(long j) throws RemoteException;
}
