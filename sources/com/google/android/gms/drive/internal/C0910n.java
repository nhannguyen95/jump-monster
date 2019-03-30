package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0154c;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0167u.C0560a;
import com.google.android.gms.drive.internal.C0556l.C1090j;
import com.google.android.gms.drive.internal.C0556l.C1147k;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.C0976e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0910n extends ff<C0167u> {
    private DriveId Fh;
    private DriveId Fi;
    final ConnectionCallbacks Fj;
    Map<DriveId, Map<Listener<?>, C0916s<?>>> Fk = new HashMap();
    private final String wG;

    public C0910n(Context context, Looper looper, fc fcVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.wG = (String) fq.m983b(fcVar.eC(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.Fj = connectionCallbacks;
    }

    /* renamed from: F */
    protected C0167u m2650F(IBinder iBinder) {
        return C0560a.m1717G(iBinder);
    }

    /* renamed from: a */
    <C extends DriveEvent> PendingResult<Status> m2651a(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<C> listener) {
        PendingResult<Status> c1147k;
        fq.m985b(C0154c.m248a(i, driveId), (Object) "id");
        fq.m983b((Object) listener, (Object) "listener");
        fq.m981a(isConnected(), "Client must be connected");
        synchronized (this.Fk) {
            Map map = (Map) this.Fk.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.Fk.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1147k = new C1147k(googleApiClient, Status.Bv);
            } else {
                final C0916s c0916s = new C0916s(getLooper(), i, listener);
                map.put(listener, c0916s);
                c1147k = googleApiClient.mo1087b(new C1090j(this) {
                    final /* synthetic */ C0910n Fo;

                    /* renamed from: a */
                    protected void m3635a(C0910n c0910n) throws RemoteException {
                        c0910n.fE().mo1129a(new AddEventListenerRequest(driveId, i, null), c0916s, null, new al(this));
                    }
                });
            }
        }
        return c1147k;
    }

    /* renamed from: a */
    protected void mo2683a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.Fh = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.Fi = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.mo2683a(i, iBinder, bundle);
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        String packageName = getContext().getPackageName();
        fq.m986f(c0976e);
        fq.m986f(packageName);
        fq.m986f(eL());
        fmVar.mo1742a(c0976e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, eL(), this.wG, new Bundle());
    }

    /* renamed from: b */
    PendingResult<Status> m2654b(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<?> listener) {
        PendingResult<Status> c1147k;
        fq.m985b(C0154c.m248a(i, driveId), (Object) "id");
        fq.m983b((Object) listener, (Object) "listener");
        fq.m981a(isConnected(), "Client must be connected");
        synchronized (this.Fk) {
            Map map = (Map) this.Fk.get(driveId);
            if (map == null) {
                c1147k = new C1147k(googleApiClient, Status.Bv);
            } else {
                final C0916s c0916s = (C0916s) map.remove(listener);
                if (c0916s == null) {
                    c1147k = new C1147k(googleApiClient, Status.Bv);
                } else {
                    if (map.isEmpty()) {
                        this.Fk.remove(driveId);
                    }
                    c1147k = googleApiClient.mo1087b(new C1090j(this) {
                        final /* synthetic */ C0910n Fo;

                        /* renamed from: a */
                        protected void m3637a(C0910n c0910n) throws RemoteException {
                            c0910n.fE().mo1141a(new RemoveEventListenerRequest(driveId, i), c0916s, null, new al(this));
                        }
                    });
                }
            }
        }
        return c1147k;
    }

    protected String bg() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bh() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public void disconnect() {
        C0167u c0167u = (C0167u) eM();
        if (c0167u != null) {
            try {
                c0167u.mo1136a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.Fk.clear();
    }

    public C0167u fE() {
        return (C0167u) eM();
    }

    public DriveId fF() {
        return this.Fh;
    }

    public DriveId fG() {
        return this.Fi;
    }

    /* renamed from: r */
    protected /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return m2650F(iBinder);
    }
}
