package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0123a;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.hw;
import com.google.android.gms.internal.hx;

public final class Panorama {
    public static final Api<NoOptions> API = new Api(wy, wx, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new hw();
    public static final C0125c<hx> wx = new C0125c();
    static final C0124b<hx, NoOptions> wy = new C07881();

    /* renamed from: com.google.android.gms.panorama.Panorama$1 */
    static class C07881 implements C0124b<hx, NoOptions> {
        C07881() {
        }

        /* renamed from: a */
        public /* synthetic */ C0123a mo1042a(Context context, Looper looper, fc fcVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2385c(context, looper, fcVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* renamed from: c */
        public hx m2385c(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new hx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    private Panorama() {
    }
}
