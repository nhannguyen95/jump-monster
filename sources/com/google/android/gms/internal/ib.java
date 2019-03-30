package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0129a.C0128d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1073a;
import com.google.android.gms.plus.internal.C1017e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class ib implements People {

    /* renamed from: com.google.android.gms.internal.ib$a */
    private static abstract class C1116a extends C1073a<LoadPeopleResult> {
        private C1116a() {
        }

        public LoadPeopleResult ab(final Status status) {
            return new LoadPeopleResult(this) {
                final /* synthetic */ C1116a UH;

                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
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
            return ab(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.ib$3 */
    class C12253 extends C1116a {
        final /* synthetic */ ib UE;

        C12253(ib ibVar) {
            this.UE = ibVar;
            super();
        }

        /* renamed from: a */
        protected void m3839a(C1017e c1017e) {
            c1017e.m3187m(this);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m1293a(googleApiClient, Plus.wx).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.mo1086a(new C1116a(this) {
            final /* synthetic */ ib UE;

            /* renamed from: a */
            protected void m3841a(C1017e c1017e) {
                c1017e.m3183a((C0128d) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.mo1086a(new C1116a(this) {
            final /* synthetic */ ib UE;

            /* renamed from: a */
            protected void m3843a(C1017e c1017e) {
                c1017e.m3185d(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.mo1086a(new C12253(this));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.mo1086a(new C1116a(this) {
            final /* synthetic */ ib UE;

            /* renamed from: a */
            protected void m3835a(C1017e c1017e) {
                m1655a(c1017e.m3179a((C0128d) this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.mo1086a(new C1116a(this) {
            final /* synthetic */ ib UE;

            /* renamed from: a */
            protected void m3837a(C1017e c1017e) {
                m1655a(c1017e.m3189o(this, pageToken));
            }
        });
    }
}
