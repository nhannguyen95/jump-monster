package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.hy;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.ia;
import com.google.android.gms.internal.ib;
import com.google.android.gms.plus.internal.C0808h;
import com.google.android.gms.plus.internal.C1017e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(wy, wx, new Scope[0]);
    public static final Account AccountApi = new hy();
    public static final Moments MomentsApi = new ia();
    public static final People PeopleApi = new ib();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final C0359a TI = new hz();
    public static final C0125c<C1017e> wx = new C0125c();
    static final C0124b<C1017e, PlusOptions> wy = new C07891();

    /* renamed from: com.google.android.gms.plus.Plus$1 */
    static class C07891 implements C0124b<C1017e, PlusOptions> {
        C07891() {
        }

        /* renamed from: a */
        public C1017e m2387a(Context context, Looper looper, fc fcVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1017e(context, looper, connectionCallbacks, onConnectionFailedListener, new C0808h(fcVar.eC(), fcVar.eF(), (String[]) plusOptions.TK.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String TJ;
        final Set<String> TK;

        public static final class Builder {
            String TJ;
            final Set<String> TK = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                fq.m983b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.TK.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.TJ = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.TJ = null;
            this.TK = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.TJ = builder.TJ;
            this.TK = builder.TK;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus$a */
    public static abstract class C1073a<R extends Result> extends C0901b<R, C1017e> {
        public C1073a() {
            super(Plus.wx);
        }
    }

    private Plus() {
    }

    /* renamed from: a */
    public static C1017e m1293a(GoogleApiClient googleApiClient, C0125c<C1017e> c0125c) {
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
}
