package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class StreetViewPanoramaLinkCreator implements Creator<StreetViewPanoramaLink> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1264a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0146b.m223a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0146b.m215a(parcel, 3, streetViewPanoramaLink.bearing);
        C0146b.m212F(parcel, p);
    }

    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    f = C0145a.m192k(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaLink[] newArray(int size) {
        return new StreetViewPanoramaLink[size];
    }
}
