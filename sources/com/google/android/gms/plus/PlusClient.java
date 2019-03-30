package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0366i;
import com.google.android.gms.plus.internal.C1017e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1017e TL;

    @Deprecated
    public static class Builder {
        private final ConnectionCallbacks TQ;
        private final OnConnectionFailedListener TR;
        private final C0366i TS = new C0366i(this.mContext);
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.TQ = connectionCallbacks;
            this.TR = connectionFailedListener;
        }

        public PlusClient build() {
            return new PlusClient(new C1017e(this.mContext, this.TQ, this.TR, this.TS.iZ()));
        }

        public Builder clearScopes() {
            this.TS.iY();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.TS.bh(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.TS.m1326f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.TS.m1325e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    PlusClient(C1017e plusClientImpl) {
        this.TL = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.TL.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.TL.connect();
    }

    @Deprecated
    public void disconnect() {
        this.TL.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.TL.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.TL.getCurrentPerson();
    }

    C1017e iI() {
        return this.TL;
    }

    @Deprecated
    public boolean isConnected() {
        return this.TL.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.TL.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.TL.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.TL.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener) {
        this.TL.m3186l(new C0128d<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2388a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().eq(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2388a((LoadMomentsResult) obj);
            }
        });
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.TL.m3181a(new C0128d<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2390a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().eq(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2390a((LoadMomentsResult) obj);
            }
        }, maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.TL.m3183a(new C0128d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2396a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2396a((LoadPeopleResult) obj);
            }
        }, (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, String... personIds) {
        this.TL.m3185d(new C0128d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2398a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2398a((LoadPeopleResult) obj);
            }
        }, personIds);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.TL.m3179a(new C0128d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2392a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2392a((LoadPeopleResult) obj);
            }
        }, orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, String pageToken) {
        this.TL.m3189o(new C0128d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: a */
            public void m2394a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eq(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2394a((LoadPeopleResult) obj);
            }
        }, pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.TL.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.TL.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.TL.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final OnAccessRevokedListener listener) {
        this.TL.m3188n(new C0128d<Status>(this) {
            final /* synthetic */ PlusClient TN;

            /* renamed from: Y */
            public void m2400Y(Status status) {
                listener.onAccessRevoked(status.getStatus().eq());
            }

            /* renamed from: b */
            public /* synthetic */ void mo1074b(Object obj) {
                m2400Y((Status) obj);
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.TL.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.TL.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.TL.m3182a(null, moment);
    }
}
