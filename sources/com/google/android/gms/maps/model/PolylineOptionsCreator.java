package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1262a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, polylineOptions.getVersionCode());
        C0146b.m234b(parcel, 2, polylineOptions.getPoints(), false);
        C0146b.m215a(parcel, 3, polylineOptions.getWidth());
        C0146b.m235c(parcel, 4, polylineOptions.getColor());
        C0146b.m215a(parcel, 5, polylineOptions.getZIndex());
        C0146b.m226a(parcel, 6, polylineOptions.isVisible());
        C0146b.m226a(parcel, 7, polylineOptions.isGeodesic());
        C0146b.m212F(parcel, p);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0145a.m197o(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    list = C0145a.m183c(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0145a.m192k(parcel, n);
                    break;
                case 4:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 6:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 7:
                    z = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
