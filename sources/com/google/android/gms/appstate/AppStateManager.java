package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;

public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(wy, wx, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final C0125c<ei> wx = new C0125c();
    private static final C0124b<ei, NoOptions> wy = new C05371();

    /* renamed from: com.google.android.gms.appstate.AppStateManager$1 */
    static class C05371 implements C0124b<ei, NoOptions> {
        C05371() {
        }

        /* renamed from: a */
        public ei m1635a(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ei(context, looper, connectionCallbacks, onConnectionFailedListener, fcVar.eC(), (String[]) fcVar.eE().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$a */
    public static abstract class C1043a<R extends Result> extends C0901b<R, ei> {
        public C1043a() {
            super(AppStateManager.wx);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$b */
    private static abstract class C1080b extends C1043a<StateDeletedResult> {
        private C1080b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$c */
    private static abstract class C1081c extends C1043a<StateListResult> {
        private C1081c() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3435e(status);
        }

        /* renamed from: e */
        public StateListResult m3435e(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ C1081c wF;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$d */
    private static abstract class C1082d extends C1043a<Status> {
        private C1082d() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3437f(status);
        }

        /* renamed from: f */
        public Status m3437f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$e */
    private static abstract class C1083e extends C1043a<StateResult> {
        private C1083e() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3439g(status);
        }

        /* renamed from: g */
        public StateResult m3439g(Status status) {
            return AppStateManager.m75a(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$7 */
    static class C11227 extends C1081c {
        C11227() {
            super();
        }

        /* renamed from: a */
        protected void m3583a(ei eiVar) {
            eiVar.m3004a(this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$9 */
    static class C11249 extends C1082d {
        C11249() {
            super();
        }

        /* renamed from: a */
        protected void m3587a(ei eiVar) {
            eiVar.m3009b((C0128d) this);
        }
    }

    private AppStateManager() {
    }

    /* renamed from: a */
    private static StateResult m75a(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    /* renamed from: a */
    public static ei m76a(GoogleApiClient googleApiClient) {
        boolean z = true;
        fq.m985b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m981a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ei eiVar = (ei) googleApiClient.mo1085a(wx);
        if (eiVar == null) {
            z = false;
        }
        fq.m981a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return eiVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo1087b(new C1080b() {
            /* renamed from: a */
            protected void m3577a(ei eiVar) {
                eiVar.m3005a((C0128d) this, stateKey);
            }

            /* renamed from: c */
            public StateDeletedResult m3578c(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ C11205 wC;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }

            /* renamed from: d */
            public /* synthetic */ Result mo2670d(Status status) {
                return m3578c(status);
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m76a(googleApiClient).dw();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m76a(googleApiClient).dv();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1086a(new C11227());
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo1086a(new C1083e() {
            /* renamed from: a */
            protected void m3581a(ei eiVar) {
                eiVar.m3010b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.mo1087b(new C1083e() {
            /* renamed from: a */
            protected void m3585a(ei eiVar) {
                eiVar.m3006a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1087b(new C11249());
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.mo1087b(new C1083e() {
            /* renamed from: a */
            protected void m3573a(ei eiVar) {
                eiVar.m3007a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.mo1087b(new C1083e() {
            /* renamed from: a */
            protected void m3575a(ei eiVar) {
                eiVar.m3007a(this, stateKey, data);
            }
        });
    }
}
