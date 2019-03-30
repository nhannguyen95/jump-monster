package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0343g {
    /* renamed from: a */
    static void m1276a(PolygonOptions polygonOptions, Parcel parcel, int i) {
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
}
