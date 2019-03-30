package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadExtendedPlayersImpl extends BaseGamesApiMethodImpl<LoadExtendedPlayersResult> {
        private LoadExtendedPlayersImpl() {
        }

        /* renamed from: K */
        public LoadExtendedPlayersResult m3529K(final Status status) {
            return new LoadExtendedPlayersResult(this) {
                final /* synthetic */ LoadExtendedPlayersImpl KL;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3529K(status);
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        private LoadOwnerCoverPhotoUrisImpl() {
        }

        /* renamed from: L */
        public LoadOwnerCoverPhotoUrisResult m3531L(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult(this) {
                final /* synthetic */ LoadOwnerCoverPhotoUrisImpl KM;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3531L(status);
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl() {
        }

        /* renamed from: M */
        public LoadPlayersResult m3533M(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl KN;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3533M(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3741a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2814b((C0128d) this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3743a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2814b((C0128d) this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3745a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2828c(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3747a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2828c(this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3749a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2837d(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3751a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2837d(this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        /* renamed from: a */
        protected void m3753a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2840d(this, this.Kd, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        /* renamed from: a */
        protected void m3755a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2840d(this, this.Kd, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ int KJ;

        /* renamed from: a */
        protected void m3757a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2787a((C0128d) this, this.JT, this.KJ, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class AnonymousClass19 extends LoadExtendedPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3759a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2841e(this, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class AnonymousClass20 extends LoadExtendedPlayersImpl {
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3763a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2841e(this, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class AnonymousClass21 extends LoadOwnerCoverPhotoUrisImpl {
        /* renamed from: a */
        protected void m3765a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2847h(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$2 */
    class C11932 extends LoadPlayersImpl {
        final /* synthetic */ String[] KK;

        /* renamed from: a */
        protected void m3767a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2805a((C0128d) this, this.KK);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$7 */
    class C11987 extends LoadPlayersImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3777a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2796a((C0128d) this, "playedWith", this.JT, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$8 */
    class C11998 extends LoadPlayersImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3779a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2796a((C0128d) this, "playedWith", this.JT, this.Kb, true, false);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gn();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gm();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gw();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3781a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2803a((C0128d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3769a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2780a((C0128d) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3771a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2780a((C0128d) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3775a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2788a((C0128d) this, "playedWith", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3761a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2784a((C0128d) this, playerId);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo1086a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl KI;

            /* renamed from: a */
            protected void m3773a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2788a((C0128d) this, "playedWith", pageSize, false, forceReload);
            }
        });
    }
}
