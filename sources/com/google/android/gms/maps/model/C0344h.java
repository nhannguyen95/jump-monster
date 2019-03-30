package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0344h {
    /* renamed from: a */
    static void m1277a(PolylineOptions polylineOptions, Parcel parcel, int i) {
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
}
