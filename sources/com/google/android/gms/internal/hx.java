package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ff.C0275b;
import com.google.android.gms.internal.ff.C0976e;
import com.google.android.gms.internal.hu.C0672a;
import com.google.android.gms.internal.hv.C0674a;
import com.google.android.gms.panorama.PanoramaApi.C1013a;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class hx extends ff<hv> {

    /* renamed from: com.google.android.gms.internal.hx$b */
    final class C0982b extends C0672a {
        final /* synthetic */ hx TE;
        private final C0128d<C1013a> TF;
        private final C0128d<PanoramaResult> TG;
        private final Uri TH;

        public C0982b(hx hxVar, C0128d<C1013a> c0128d, C0128d<PanoramaResult> c0128d2, Uri uri) {
            this.TE = hxVar;
            this.TF = c0128d;
            this.TG = c0128d2;
            this.TH = uri;
        }

        /* renamed from: a */
        public void mo1810a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.TH != null) {
                this.TE.getContext().revokeUriPermission(this.TH, 1);
            }
            Status status = new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.TG != null) {
                this.TE.m2169a(new C0983c(this.TE, this.TG, status, intent));
            } else if (this.TF != null) {
                this.TE.m2169a(new C1070a(this.TE, this.TF, status, i2, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hx$c */
    final class C0983c extends C0275b<C0128d<PanoramaResult>> implements PanoramaResult {
        private final Status TC;
        private final Intent TD;
        final /* synthetic */ hx TE;

        public C0983c(hx hxVar, C0128d<PanoramaResult> c0128d, Status status, Intent intent) {
            this.TE = hxVar;
            super(hxVar, c0128d);
            this.TC = status;
            this.TD = intent;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m3071c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m3071c(C0128d<PanoramaResult> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.TC;
        }

        public Intent getViewerIntent() {
            return this.TD;
        }
    }

    /* renamed from: com.google.android.gms.internal.hx$a */
    final class C1070a extends C0275b<C0128d<C1013a>> implements C1013a {
        public final Status TC;
        public final Intent TD;
        final /* synthetic */ hx TE;
        public final int type;

        public C1070a(hx hxVar, C0128d<C1013a> c0128d, Status status, int i, Intent intent) {
            this.TE = hxVar;
            super(hxVar, c0128d);
            this.TC = status;
            this.type = i;
            this.TD = intent;
        }

        /* renamed from: a */
        protected /* synthetic */ void mo1214a(Object obj) {
            m3413c((C0128d) obj);
        }

        /* renamed from: c */
        protected void m3413c(C0128d<C1013a> c0128d) {
            c0128d.mo1074b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.TC;
        }

        public Intent getViewerIntent() {
            return this.TD;
        }
    }

    public hx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    /* renamed from: a */
    public void m3072a(C0128d<PanoramaResult> c0128d, Uri uri, boolean z) {
        m3074a(new C0982b(this, null, c0128d, z ? uri : null), uri, null, z);
    }

    /* renamed from: a */
    protected void mo2684a(fm fmVar, C0976e c0976e) throws RemoteException {
        fmVar.mo1737a(c0976e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: a */
    public void m3074a(C0982b c0982b, Uri uri, Bundle bundle, boolean z) {
        bT();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((hv) eM()).mo1811a(c0982b, uri, bundle, z);
        } catch (RemoteException e) {
            c0982b.mo1810a(8, null, 0, null);
        }
    }

    public hv aN(IBinder iBinder) {
        return C0674a.aM(iBinder);
    }

    protected String bg() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    /* renamed from: r */
    public /* synthetic */ IInterface mo2687r(IBinder iBinder) {
        return aN(iBinder);
    }
}
