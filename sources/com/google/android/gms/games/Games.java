package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
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
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;

public final class Games {
    public static final Api<GamesOptions> API = new Api(wy, wx, SCOPE_GAMES);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Scope HV = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> HW = new Api(wy, wx, HV);
    public static final Multiplayer HX = new MultiplayerImpl();
    public static final Acls HY = new AclsImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final C0125c<GamesClientImpl> wx = new C0125c();
    private static final C0124b<GamesClientImpl, GamesOptions> wy = new C05761();

    /* renamed from: com.google.android.gms.games.Games$1 */
    static class C05761 implements C0124b<GamesClientImpl, GamesOptions> {
        C05761() {
        }

        /* renamed from: a */
        public GamesClientImpl m1751a(Context context, Looper looper, fc fcVar, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (gamesOptions == null) {
                GamesOptions gamesOptions2 = new GamesOptions();
            }
            return new GamesClientImpl(context, looper, fcVar.eG(), fcVar.eC(), connectionCallbacks, onConnectionFailedListener, fcVar.eF(), fcVar.eD(), fcVar.eH(), gamesOptions.HZ, gamesOptions.Ia, gamesOptions.Ib, gamesOptions.Ic, gamesOptions.Id);
        }

        public int getPriority() {
            return 1;
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends C0901b<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl() {
            super(Games.wx);
        }
    }

    public static final class GamesOptions implements Optional {
        final boolean HZ;
        final boolean Ia;
        final int Ib;
        final boolean Ic;
        final int Id;

        public static final class Builder {
            boolean HZ;
            boolean Ia;
            int Ib;
            boolean Ic;
            int Id;

            private Builder() {
                this.HZ = false;
                this.Ia = true;
                this.Ib = 17;
                this.Ic = false;
                this.Id = 4368;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.Id = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.Ia = showConnectingPopup;
                this.Ib = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.Ia = showConnectingPopup;
                this.Ib = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.HZ = false;
            this.Ia = true;
            this.Ib = 17;
            this.Ic = false;
            this.Id = 4368;
        }

        private GamesOptions(Builder builder) {
            this.HZ = builder.HZ;
            this.Ia = builder.Ia;
            this.Ib = builder.Ib;
            this.Ic = builder.Ic;
            this.Id = builder.Id;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3475f(status);
        }

        /* renamed from: f */
        public Status m3475f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games$2 */
    static class C11572 extends SignOutImpl {
        C11572() {
            super();
        }

        /* renamed from: a */
        protected void m3653a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2813b((C0128d) this);
        }
    }

    private Games() {
    }

    /* renamed from: c */
    public static GamesClientImpl m362c(GoogleApiClient googleApiClient) {
        boolean z = true;
        fq.m985b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        fq.m981a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        GamesClientImpl gamesClientImpl = (GamesClientImpl) googleApiClient.mo1085a(wx);
        if (gamesClientImpl == null) {
            z = false;
        }
        fq.m981a(z, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gamesClientImpl;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m362c(apiClient).gz();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m362c(apiClient).gl();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m362c(apiClient).gy();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m362c(apiClient).gx();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m362c(apiClient).aX(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        fq.m986f(gamesContentView);
        m362c(apiClient).m2843f(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.mo1087b(new C11572());
    }
}
