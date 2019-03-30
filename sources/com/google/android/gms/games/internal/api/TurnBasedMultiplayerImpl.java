package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String wp;

        public CancelMatchImpl(String id) {
            this.wp = id;
        }

        /* renamed from: R */
        public CancelMatchResult m3544R(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl Lj;

                public String getMatchId() {
                    return this.Lj.wp;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3544R(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl() {
        }

        /* renamed from: S */
        public InitiateMatchResult m3546S(final Status status) {
            return new InitiateMatchResult(this) {
                final /* synthetic */ InitiateMatchImpl Lk;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3546S(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl() {
        }

        /* renamed from: T */
        public LeaveMatchResult m3548T(final Status status) {
            return new LeaveMatchResult(this) {
                final /* synthetic */ LeaveMatchImpl Ll;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3548T(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl() {
        }

        /* renamed from: U */
        public LoadMatchResult m3550U(final Status status) {
            return new LoadMatchResult(this) {
                final /* synthetic */ LoadMatchImpl Lm;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3550U(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl() {
        }

        /* renamed from: V */
        public LoadMatchesResult m3552V(final Status status) {
            return new LoadMatchesResult(this) {
                final /* synthetic */ LoadMatchesImpl Ln;

                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
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
            return m3552V(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl() {
        }

        /* renamed from: W */
        public UpdateMatchResult m3554W(final Status status) {
            return new UpdateMatchResult(this) {
                final /* synthetic */ UpdateMatchImpl Lo;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3554W(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String Ld;

        /* renamed from: a */
        protected void m3801a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2819b((C0128d) this, this.JT, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String Ld;

        /* renamed from: a */
        protected void m3803a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2832c((C0128d) this, this.JT, this.Ld);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl$13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Le;
        final /* synthetic */ int[] Lf;

        /* renamed from: a */
        protected void m3805a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2790a((C0128d) this, this.JT, this.Le, this.Lf);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.mo1087b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3811a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2842e(this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo1087b(new CancelMatchImpl(this, matchId) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3821a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2846g(this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.mo1087b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3807a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2783a((C0128d) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m362c(apiClient).m2858m(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m362c(apiClient).m2856l(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m362c(apiClient).aB(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final ParticipantResult... results) {
        return apiClient.mo1087b(new UpdateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3815a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2801a((C0128d) this, matchId, matchData, results);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gr();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gA();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m362c(apiClient).m2773a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m362c(apiClient).m2773a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo1087b(new LeaveMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3817a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2844f(this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.mo1087b(new LeaveMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3819a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2792a((C0128d) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo1086a(new LoadMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3799a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2848h(this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.mo1086a(new LoadMatchesImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3823a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2781a((C0128d) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m362c(apiClient).m2809a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo1087b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3809a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2838d((C0128d) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.mo1087b(new UpdateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl Lc;

            /* renamed from: a */
            protected void m3813a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2800a((C0128d) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m362c(apiClient).gu();
    }
}
