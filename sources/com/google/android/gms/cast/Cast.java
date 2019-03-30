package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0124b;
import com.google.android.gms.common.api.Api.C0125c;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(wy, wx, new Scope[0]);
    public static final CastApi CastApi = new C0539a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C0125c<en> wx = new C0125c();
    private static final C0124b<en, CastOptions> wy = new C05381();

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast$CastApi$a */
        public static final class C0539a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast$CastApi$a$6 */
            class C11306 extends C1085c {
                final /* synthetic */ C0539a xP;

                C11306(C0539a c0539a) {
                    this.xP = c0539a;
                    super();
                }

                /* renamed from: a */
                protected void m3599a(en enVar) throws RemoteException {
                    try {
                        enVar.m3052b(null, null, this);
                    } catch (IllegalStateException e) {
                        m3243x(2001);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast$CastApi$a$7 */
            class C11317 extends C1084b {
                final /* synthetic */ C0539a xP;

                C11317(C0539a c0539a) {
                    this.xP = c0539a;
                    super();
                }

                /* renamed from: a */
                protected void m3601a(en enVar) throws RemoteException {
                    try {
                        enVar.m3053e((C0128d) this);
                    } catch (IllegalStateException e) {
                        m3243x(2001);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast$CastApi$a$8 */
            class C11328 extends C1084b {
                final /* synthetic */ C0539a xP;

                C11328(C0539a c0539a) {
                    this.xP = c0539a;
                    super();
                }

                /* renamed from: a */
                protected void m3603a(en enVar) throws RemoteException {
                    try {
                        enVar.m3049a("", (C0128d) this);
                    } catch (IllegalStateException e) {
                        m3243x(2001);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((en) client.mo1085a(Cast.wx)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((en) client.mo1085a(Cast.wx)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((en) client.mo1085a(Cast.wx)).dI();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((en) client.mo1085a(Cast.wx)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.mo1087b(new C11306(this));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.mo1087b(new C1085c(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3597a(en enVar) throws RemoteException {
                        try {
                            enVar.m3052b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            m3243x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.mo1087b(new C1085c(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3595a(en enVar) throws RemoteException {
                        try {
                            enVar.m3052b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            m3243x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.mo1087b(new C1085c(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3591a(en enVar) throws RemoteException {
                        try {
                            enVar.m3051a(applicationId, false, (C0128d) this);
                        } catch (IllegalStateException e) {
                            m3243x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final boolean relaunchIfRunning) {
                return client.mo1087b(new C1085c(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3593a(en enVar) throws RemoteException {
                        try {
                            enVar.m3051a(applicationId, relaunchIfRunning, (C0128d) this);
                        } catch (IllegalStateException e) {
                            m3243x(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.mo1087b(new C11317(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((en) client.mo1085a(Cast.wx)).m3044V(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((en) client.mo1085a(Cast.wx)).dH();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.mo1087b(new C1084b(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3589a(en enVar) throws RemoteException {
                        try {
                            enVar.m3050a(namespace, message, (C0128d) this);
                        } catch (IllegalArgumentException e) {
                            m3243x(2001);
                        } catch (IllegalStateException e2) {
                            m3243x(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((en) client.mo1085a(Cast.wx)).m3048a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((en) client.mo1085a(Cast.wx)).m3055v(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((en) client.mo1085a(Cast.wx)).m3045a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.mo1087b(new C11328(this));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.mo1087b(new C1084b(this) {
                    final /* synthetic */ C0539a xP;

                    /* renamed from: a */
                    protected void m3605a(en enVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            m3242c(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            enVar.m3049a(sessionId, (C0128d) this);
                        } catch (IllegalStateException e) {
                            m3243x(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static abstract class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast$1 */
    static class C05381 implements C0124b<en, CastOptions> {
        C05381() {
        }

        /* renamed from: a */
        public en m1637a(Context context, Looper looper, fc fcVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            fq.m983b((Object) castOptions, (Object) "Setting the API options is required.");
            return new en(context, looper, castOptions.xT, (long) castOptions.xV, castOptions.xU, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice xT;
        final Listener xU;
        private final int xV;

        public static final class Builder {
            CastDevice xW;
            Listener xX;
            private int xY;

            private Builder(CastDevice castDevice, Listener castListener) {
                fq.m983b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                fq.m983b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.xW = castDevice;
                this.xX = castListener;
                this.xY = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.xY |= 1;
                } else {
                    this.xY &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.xT = builder.xW;
            this.xU = builder.xX;
            this.xV = builder.xY;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$a */
    protected static abstract class C1044a<R extends Result> extends C0901b<R, en> {
        public C1044a() {
            super(Cast.wx);
        }

        /* renamed from: c */
        public void m3242c(int i, String str) {
            m1653a(mo2670d(new Status(i, str, null)));
        }

        /* renamed from: x */
        public void m3243x(int i) {
            m1653a(mo2670d(new Status(i)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$b */
    private static abstract class C1084b extends C1044a<Status> {
        private C1084b() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3441f(status);
        }

        /* renamed from: f */
        public Status m3441f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$c */
    private static abstract class C1085c extends C1044a<ApplicationConnectionResult> {
        private C1085c() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3443h(status);
        }

        /* renamed from: h */
        public ApplicationConnectionResult m3443h(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ C1085c xZ;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
