package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1073a;
import com.google.android.gms.plus.internal.C1017e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class ia implements Moments {

    /* renamed from: com.google.android.gms.internal.ia$a */
    private static abstract class C1113a extends C1073a<LoadMomentsResult> {
        private C1113a() {
        }

        public LoadMomentsResult aa(final Status status) {
            return new LoadMomentsResult(this) {
                final /* synthetic */ C1113a UC;

                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return aa(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ia$b */
    private static abstract class C1114b extends C1073a<Status> {
        private C1114b() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3566f(status);
        }

        /* renamed from: f */
        public Status m3566f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ia$c */
    private static abstract class C1115c extends C1073a<Status> {
        private C1115c() {
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3568f(status);
        }

        /* renamed from: f */
        public Status m3568f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ia$1 */
    class C12191 extends C1113a {
        final /* synthetic */ ia Uv;

        C12191(ia iaVar) {
            this.Uv = iaVar;
            super();
        }

        /* renamed from: a */
        protected void m3827a(C1017e c1017e) {
            c1017e.m3186l(this);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1086a(new C12191(this));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.mo1086a(new C1113a(this) {
            final /* synthetic */ ia Uv;

            /* renamed from: a */
            protected void m3829a(C1017e c1017e) {
                c1017e.m3181a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.mo1087b(new C1114b(this) {
            final /* synthetic */ ia Uv;

            /* renamed from: a */
            protected void m3833a(C1017e c1017e) {
                c1017e.removeMoment(momentId);
                m1653a(Status.Bv);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.mo1087b(new C1115c(this) {
            final /* synthetic */ ia Uv;

            /* renamed from: a */
            protected void m3831a(C1017e c1017e) {
                c1017e.m3182a((C0128d) this, moment);
            }
        });
    }
}
