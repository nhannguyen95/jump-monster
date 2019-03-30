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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl() {
        }

        /* renamed from: D */
        public LeaderboardMetadataResult m3505D(final Status status) {
            return new LeaderboardMetadataResult(this) {
                final /* synthetic */ LoadMetadataImpl Kx;

                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.empty(14));
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
            return m3505D(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl() {
        }

        /* renamed from: E */
        public LoadPlayerScoreResult m3507E(final Status status) {
            return new LoadPlayerScoreResult(this) {
                final /* synthetic */ LoadPlayerScoreImpl Ky;

                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3507E(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl() {
        }

        /* renamed from: F */
        public LoadScoresResult m3509F(final Status status) {
            return new LoadScoresResult(this) {
                final /* synthetic */ LoadScoresImpl Kz;

                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.empty(14));
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
            return m3509F(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl() {
        }

        /* renamed from: G */
        public SubmitScoreResult m3511G(final Status status) {
            return new SubmitScoreResult(this) {
                final /* synthetic */ SubmitScoreImpl KA;

                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.empty(14));
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
            return m3511G(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        /* renamed from: a */
        protected void m3715a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2795a((C0128d) this, this.JT, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;
        final /* synthetic */ int Kq;
        final /* synthetic */ int Kr;
        final /* synthetic */ int Ks;

        /* renamed from: a */
        protected void m3717a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2820b(this, this.JT, this.Kp, this.Kq, this.Kr, this.Ks, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8 */
    class C11888 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;

        /* renamed from: a */
        protected void m3733a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2822b((C0128d) this, this.JT, this.JQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9 */
    class C11899 extends LoadMetadataImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JT;
        final /* synthetic */ String Kp;

        /* renamed from: a */
        protected void m3735a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2797a((C0128d) this, this.JT, this.Kp, this.JQ);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gp();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m362c(apiClient).aA(leaderboardId);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection) {
        return apiClient.mo1086a(new LoadPlayerScoreImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3723a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2793a((C0128d) this, null, leaderboardId, span, leaderboardCollection);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.mo1086a(new LoadMetadataImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3721a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2799a((C0128d) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo1086a(new LoadMetadataImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3719a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2823b((C0128d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, final LeaderboardScoreBuffer buffer, final int maxResults, final int pageDirection) {
        return apiClient.mo1086a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3729a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2782a((C0128d) this, buffer, maxResults, pageDirection);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo1086a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3727a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2817b(this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo1086a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3725a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2786a((C0128d) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m362c(apiClient).m2791a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.mo1087b(new SubmitScoreImpl(this) {
            final /* synthetic */ LeaderboardsImpl Ko;

            /* renamed from: a */
            protected void m3731a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2791a((C0128d) this, str, j, str2);
            }
        });
    }
}
