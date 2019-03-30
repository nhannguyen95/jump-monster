package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        private LoadNotifyAclImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3492x(status);
        }

        /* renamed from: x */
        public LoadAclResult m3492x(Status status) {
            return AclsImpl.m1984v(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        private UpdateNotifyAclImpl() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3494f(status);
        }

        /* renamed from: f */
        public Status m3494f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2 */
    class C11672 extends LoadNotifyAclImpl {
        /* renamed from: a */
        protected void m3675a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2850i(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3 */
    class C11683 extends UpdateNotifyAclImpl {
        final /* synthetic */ String JY;

        /* renamed from: a */
        protected void m3677a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2857m((C0128d) this, this.JY);
        }
    }

    /* renamed from: v */
    private static LoadAclResult m1984v(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
