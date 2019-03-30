package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1255a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, circleOptions.getVersionCode());
        C0146b.m220a(parcel, 2, circleOptions.getCenter(), i, false);
        C0146b.m214a(parcel, 3, circleOptions.getRadius());
        C0146b.m215a(parcel, 4, circleOptions.getStrokeWidth());
        C0146b.m235c(parcel, 5, circleOptions.getStrokeColor());
        C0146b.m235c(parcel, 6, circleOptions.getFillColor());
        C0146b.m215a(parcel, 7, circleOptions.getZIndex());
        C0146b.m226a(parcel, 8, circleOptions.isVisible());
        C0146b.m212F(parcel, p);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0145a.m197o(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    latLng = (LatLng) C0145a.m177a(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0145a.m193l(parcel, n);
                    break;
                case 4:
                    f2 = C0145a.m192k(parcel, n);
                    break;
                case 5:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 6:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 8:
                    z = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
