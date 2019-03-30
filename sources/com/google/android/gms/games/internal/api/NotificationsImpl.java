package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C11001 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String KB;

        /* renamed from: H */
        public GameMuteStatusChangeResult m3513H(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C11001 KC;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m3515a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2833c((C0128d) this, this.KB, true);
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3513H(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C11012 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String KB;

        /* renamed from: H */
        public GameMuteStatusChangeResult m3517H(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C11012 KD;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m3519a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2833c((C0128d) this, this.KB, false);
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3517H(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C11023 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String KB;

        /* renamed from: I */
        public GameMuteStatusLoadResult m3521I(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C11023 KE;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: a */
        protected void m3523a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2859n(this, this.KB);
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3521I(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        private ContactSettingLoadImpl() {
        }

        /* renamed from: J */
        public ContactSettingLoadResult m3525J(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl KH;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3525J(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        private ContactSettingUpdateImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3528f(status);
        }

        /* renamed from: f */
        public Status m3528f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C11904 extends ContactSettingLoadImpl {
        /* renamed from: a */
        protected void m3737a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2852j(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C11915 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean KF;
        final /* synthetic */ Bundle KG;

        /* renamed from: a */
        protected void m3739a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2804a((C0128d) this, this.KF, this.KG);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m362c(apiClient).aY(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 7);
    }
}
