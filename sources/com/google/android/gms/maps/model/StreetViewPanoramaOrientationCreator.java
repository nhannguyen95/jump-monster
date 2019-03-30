package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class StreetViewPanoramaOrientationCreator implements Creator<StreetViewPanoramaOrientation> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1266a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, streetViewPanoramaOrientation.getVersionCode());
        C0146b.m215a(parcel, 2, streetViewPanoramaOrientation.tilt);
        C0146b.m215a(parcel, 3, streetViewPanoramaOrientation.bearing);
        C0146b.m212F(parcel, p);
    }

    public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int o = C0145a.m197o(parcel);
        int i = 0;
        float f2 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    f2 = C0145a.m192k(parcel, n);
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
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public StreetViewPanoramaOrientation[] newArray(int size) {
        return new StreetViewPanoramaOrientation[size];
    }
}
