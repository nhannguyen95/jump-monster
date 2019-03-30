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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl() {
        }

        /* renamed from: C */
        public LoadInvitationsResult m3503C(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl Kn;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.empty(14));
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
            return m3503C(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2 */
    class C11792 extends LoadInvitationsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int Kk;

        /* renamed from: a */
        protected void m3711a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2830c((C0128d) this, this.JT, this.Kk);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3 */
    class C11803 extends LoadInvitationsImpl {
        final /* synthetic */ String Km;

        /* renamed from: a */
        protected void m3713a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2855l((C0128d) this, this.Km);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gs();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.mo1086a(new LoadInvitationsImpl(this) {
            final /* synthetic */ InvitationsImpl Kl;

            /* renamed from: a */
            protected void m3709a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2827c((C0128d) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m362c(apiClient).m2806a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m362c(apiClient).gt();
    }
}
