package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.C0129a.C0901b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class hw implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.hw$a */
    private static abstract class C1069a extends C0901b<PanoramaResult, hx> {
        public C1069a() {
            super(Panorama.wx);
        }

        /* renamed from: X */
        public PanoramaResult m3410X(final Status status) {
            return new PanoramaResult(this) {
                final /* synthetic */ C1069a TB;

                public Status getStatus() {
                    return status;
                }

                public Intent getViewerIntent() {
                    return null;
                }
            };
        }

        /* renamed from: d */
        public /* synthetic */ Result mo2670d(Status status) {
            return m3410X(status);
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.mo1086a(new C1069a(this) {
            final /* synthetic */ hw TA;

            /* renamed from: a */
            protected void m3559a(hx hxVar) {
                hxVar.m3072a(this, uri, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.mo1086a(new C1069a(this) {
            final /* synthetic */ hw TA;

            /* renamed from: a */
            protected void m3561a(hx hxVar) {
                hxVar.m3072a(this, uri, true);
            }
        });
    }
}
