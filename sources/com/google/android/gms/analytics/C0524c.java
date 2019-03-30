package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.eg.C0621a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0524c implements C0086b {
    private Context mContext;
    private ServiceConnection sj;
    private C0088b sk;
    private C0089c sl;
    private eg sm;

    /* renamed from: com.google.android.gms.analytics.c$a */
    final class C0087a implements ServiceConnection {
        final /* synthetic */ C0524c sn;

        C0087a(C0524c c0524c) {
            this.sn = c0524c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m35y("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m35y("bound to service");
                    this.sn.sm = C0621a.m2094t(binder);
                    this.sn.bU();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.sn.mContext.unbindService(this);
            this.sn.sj = null;
            this.sn.sl.mo1026a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m35y("service disconnected: " + component);
            this.sn.sj = null;
            this.sn.sk.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c$b */
    public interface C0088b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c$c */
    public interface C0089c {
        /* renamed from: a */
        void mo1026a(int i, Intent intent);
    }

    public C0524c(Context context, C0088b c0088b, C0089c c0089c) {
        this.mContext = context;
        if (c0088b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.sk = c0088b;
        if (c0089c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.sl = c0089c;
    }

    private eg bS() {
        bT();
        return this.sm;
    }

    private void bU() {
        bV();
    }

    private void bV() {
        this.sk.onConnected();
    }

    /* renamed from: a */
    public void mo1010a(Map<String, String> map, long j, String str, List<ef> list) {
        try {
            bS().mo1687a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m33w("sendHit failed: " + e);
        }
    }

    public void bR() {
        try {
            bS().bR();
        } catch (RemoteException e) {
            aa.m33w("clear hits failed: " + e);
        }
    }

    protected void bT() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.sj != null) {
            aa.m33w("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.sj = new C0087a(this);
        boolean bindService = this.mContext.bindService(intent, this.sj, Keys.CONTROL_LEFT);
        aa.m35y("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.sj = null;
            this.sl.mo1026a(1, null);
        }
    }

    public void disconnect() {
        this.sm = null;
        if (this.sj != null) {
            try {
                this.mContext.unbindService(this.sj);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.sj = null;
            this.sk.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.sm != null;
    }
}
