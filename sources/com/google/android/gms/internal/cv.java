package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.cu.C0237a;

public abstract class cv extends C0243do {
    private final cx mQ;
    private final C0237a pc;

    /* renamed from: com.google.android.gms.internal.cv$a */
    public static final class C0967a extends cv {
        private final Context mContext;

        public C0967a(Context context, cx cxVar, C0237a c0237a) {
            super(cxVar, c0237a);
            this.mContext = context;
        }

        public void be() {
        }

        public db bf() {
            return dc.m2990a(this.mContext, new ax(), new bg());
        }
    }

    /* renamed from: com.google.android.gms.internal.cv$b */
    public static final class C0968b extends cv implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object li = new Object();
        private final C0237a pc;
        private final cw pd;

        public C0968b(Context context, cx cxVar, C0237a c0237a) {
            super(cxVar, c0237a);
            this.pc = c0237a;
            this.pd = new cw(context, this, this, cxVar.kK.rs);
            this.pd.connect();
        }

        public void be() {
            synchronized (this.li) {
                if (this.pd.isConnected() || this.pd.isConnecting()) {
                    this.pd.disconnect();
                }
            }
        }

        public db bf() {
            db bi;
            synchronized (this.li) {
                try {
                    bi = this.pd.bi();
                } catch (IllegalStateException e) {
                    bi = null;
                }
            }
            return bi;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.pc.mo1681a(new cz(0));
        }

        public void onDisconnected() {
            dw.m820v("Disconnected from remote ad request service.");
        }
    }

    public cv(cx cxVar, C0237a c0237a) {
        this.mQ = cxVar;
        this.pc = c0237a;
    }

    /* renamed from: a */
    private static cz m2084a(db dbVar, cx cxVar) {
        try {
            return dbVar.mo1684b(cxVar);
        } catch (Throwable e) {
            dw.m818c("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    public final void aY() {
        try {
            cz czVar;
            db bf = bf();
            if (bf == null) {
                czVar = new cz(0);
            } else {
                czVar = m2084a(bf, this.mQ);
                if (czVar == null) {
                    czVar = new cz(0);
                }
            }
            be();
            this.pc.mo1681a(czVar);
        } catch (Throwable th) {
            be();
        }
    }

    public abstract void be();

    public abstract db bf();

    public final void onStop() {
        be();
    }
}
