package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        private LoadExtendedGamesImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3496y(status);
        }

        /* renamed from: y */
        public LoadExtendedGamesResult m3496y(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl Kg;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        private LoadGameInstancesImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3498z(status);
        }

        /* renamed from: z */
        public LoadGameInstancesResult m3498z(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl Kh;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        private LoadGameSearchSuggestionsImpl() {
        }

        /* renamed from: A */
        public LoadGameSearchSuggestionsResult m3499A(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl Ki;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3499A(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl() {
        }

        /* renamed from: B */
        public LoadGamesResult m3501B(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl Kj;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.empty(14));
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
            return m3501B(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$10 */
    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        /* renamed from: a */
        protected void m3679a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2789a((C0128d) this, this.Ka, this.Kb, false, true, false, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$11 */
    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        /* renamed from: a */
        protected void m3681a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2789a((C0128d) this, this.Ka, this.Kb, true, false, this.JQ, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$12 */
    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        /* renamed from: a */
        protected void m3683a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2789a((C0128d) this, this.Ka, this.Kb, true, true, false, this.Kc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$13 */
    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        /* renamed from: a */
        protected void m3685a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2831c(this, this.Kd, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$14 */
    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Kb;
        final /* synthetic */ String Kd;

        /* renamed from: a */
        protected void m3687a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2831c(this, this.Kd, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$15 */
    class AnonymousClass15 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String Kd;

        /* renamed from: a */
        protected void m3689a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2854k(this, this.Kd);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$1 */
    class C11691 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl JZ;

        C11691(GamesMetadataImpl gamesMetadataImpl) {
            this.JZ = gamesMetadataImpl;
            super();
        }

        /* renamed from: a */
        protected void m3691a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2845g(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class C11702 extends LoadExtendedGamesImpl {
        final /* synthetic */ String JT;

        /* renamed from: a */
        protected void m3693a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2851i((C0128d) this, this.JT);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class C11713 extends LoadGameInstancesImpl {
        final /* synthetic */ String JT;

        /* renamed from: a */
        protected void m3695a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2853j(this, this.JT);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$4 */
    class C11724 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3697a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2818b(this, null, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$5 */
    class C11735 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3699a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2818b(this, null, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$6 */
    class C11746 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JS;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3701a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2818b(this, this.JS, this.Kb, false, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$7 */
    class C11757 extends LoadExtendedGamesImpl {
        final /* synthetic */ String JS;
        final /* synthetic */ int Kb;

        /* renamed from: a */
        protected void m3703a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2818b(this, this.JS, this.Kb, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$8 */
    class C11768 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ int Kb;
        final /* synthetic */ int Ke;
        final /* synthetic */ boolean Kf;

        /* renamed from: a */
        protected void m3705a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2779a((C0128d) this, this.Kb, this.Ke, this.Kf, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$9 */
    class C11779 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String Ka;
        final /* synthetic */ int Kb;
        final /* synthetic */ boolean Kc;

        /* renamed from: a */
        protected void m3707a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2789a((C0128d) this, this.Ka, this.Kb, false, false, this.JQ, this.Kc);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).go();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.mo1086a(new C11691(this));
    }
}
