package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1073a;
import com.google.android.gms.plus.internal.C1017e;

public final class hy implements Account {

    /* renamed from: com.google.android.gms.internal.hy$a */
    private static abstract class C1112a extends C1073a<Status> {
        private C1112a() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3563f(status);
        }

        /* renamed from: f */
        public Status m3563f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.hy$1 */
    class C12181 extends C1112a {
        final /* synthetic */ hy Uu;

        C12181(hy hyVar) {
            this.Uu = hyVar;
            super();
        }

        /* renamed from: a */
        protected void m3825a(C1017e c1017e) {
            c1017e.m3188n(this);
        }
    }

    /* renamed from: a */
    private static C1017e m2284a(GoogleApiClient googleApiClient, C0125c<C1017e> c0125c) {
        boolean z = true;
        fq.m985b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m981a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1017e c1017e = (C1017e) googleApiClient.mo1085a((C0125c) c0125c);
        if (c1017e == null) {
            z = false;
        }
        fq.m981a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1017e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m2284a(googleApiClient, Plus.wx).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m2284a(googleApiClient, Plus.wx).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1087b(new C12181(this));
    }
}
