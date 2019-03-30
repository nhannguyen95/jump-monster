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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3487t(status);
        }

        /* renamed from: t */
        public LoadAchievementsResult m3487t(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl JW;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String wp;

        public UpdateImpl(String id) {
            this.wp = id;
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3490u(status);
        }

        /* renamed from: u */
        public UpdateAchievementResult m3490u(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl JX;

                public String getAchievementId() {
                    return this.JX.wp;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean JQ;
        final /* synthetic */ String JS;
        final /* synthetic */ String JT;

        /* renamed from: a */
        public void m3655a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2821b((C0128d) this, this.JS, this.JT, this.JQ);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gq();
    }

    public void increment(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3667a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2785a(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3669a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2785a((C0128d) this, id, numSteps);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo1086a(new LoadImpl(this) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3657a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2834c((C0128d) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3659a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2815b(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3661a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2815b((C0128d) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3671a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2816b(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3673a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2816b((C0128d) this, id, numSteps);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3663a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2829c(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo1087b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl JR;

            /* renamed from: a */
            public void m3665a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2829c((C0128d) this, id);
            }
        });
    }
}
