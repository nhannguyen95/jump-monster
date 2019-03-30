package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        private LoadRequestSummariesImpl() {
        }

        /* renamed from: N */
        public LoadRequestSummariesResult m3535N(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl KX;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3535N(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl() {
        }

        /* renamed from: O */
        public LoadRequestsResult m3537O(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl KY;

                public GameRequestBuffer getRequests(int type) {
                    return null;
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
            return m3537O(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        private SendRequestImpl() {
        }

        /* renamed from: P */
        public SendRequestResult m3539P(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl KZ;

                public Status getStatus() {
                    return status;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3539P(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl() {
        }

        /* renamed from: Q */
        public UpdateRequestsResult m3541Q(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl La;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
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
            return m3541Q(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4 */
    class C12044 extends SendRequestImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KS;
        final /* synthetic */ int KT;
        final /* synthetic */ byte[] KU;
        final /* synthetic */ int KV;

        /* renamed from: a */
        protected void m3789a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2802a((C0128d) this, this.JT, this.KS, this.KT, this.KU, this.KV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5 */
    class C12055 extends SendRequestImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KS;
        final /* synthetic */ int KT;
        final /* synthetic */ byte[] KU;
        final /* synthetic */ int KV;

        /* renamed from: a */
        protected void m3791a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2802a((C0128d) this, this.JT, this.KS, this.KT, this.KU, this.KV);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6 */
    class C12066 extends UpdateRequestsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ String[] KO;
        final /* synthetic */ String KW;

        /* renamed from: a */
        protected void m3793a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2798a((C0128d) this, this.JT, this.KW, this.KO);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7 */
    class C12077 extends LoadRequestsImpl {
        final /* synthetic */ String JT;
        final /* synthetic */ int KQ;
        final /* synthetic */ int KR;
        final /* synthetic */ String KW;
        final /* synthetic */ int Kk;

        /* renamed from: a */
        protected void m3795a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2794a((C0128d) this, this.JT, this.KW, this.KQ, this.KR, this.Kk);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8 */
    class C12088 extends LoadRequestSummariesImpl {
        final /* synthetic */ int KR;
        final /* synthetic */ String KW;

        /* renamed from: a */
        protected void m3797a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m2839d(this, this.KW, this.KR);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo1087b(new UpdateRequestsImpl(this) {
            final /* synthetic */ RequestsImpl KP;

            /* renamed from: a */
            protected void m3783a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2824b((C0128d) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo1087b(new UpdateRequestsImpl(this) {
            final /* synthetic */ RequestsImpl KP;

            /* renamed from: a */
            protected void m3785a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2835c((C0128d) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gB();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gD();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m362c(apiClient).gC();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m362c(apiClient).m2774a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.mo1086a(new LoadRequestsImpl(this) {
            final /* synthetic */ RequestsImpl KP;

            /* renamed from: a */
            protected void m3787a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m2778a((C0128d) this, requestDirection, types, sortOrder);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m362c(apiClient).m2810a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m362c(apiClient).gv();
    }
}
