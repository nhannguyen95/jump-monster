package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1261a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, polygonOptions.getVersionCode());
        C0146b.m234b(parcel, 2, polygonOptions.getPoints(), false);
        C0146b.m236c(parcel, 3, polygonOptions.iF(), false);
        C0146b.m215a(parcel, 4, polygonOptions.getStrokeWidth());
        C0146b.m235c(parcel, 5, polygonOptions.getStrokeColor());
        C0146b.m235c(parcel, 6, polygonOptions.getFillColor());
        C0146b.m215a(parcel, 7, polygonOptions.getZIndex());
        C0146b.m226a(parcel, 8, polygonOptions.isVisible());
        C0146b.m226a(parcel, 9, polygonOptions.isGeodesic());
        C0146b.m212F(parcel, p);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0145a.m197o(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = C0145a.m183c(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    C0145a.m180a(parcel, n, arrayList, getClass().getClassLoader());
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
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 9:
                    z = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
