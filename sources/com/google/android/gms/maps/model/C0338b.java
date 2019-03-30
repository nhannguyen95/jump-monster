package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0338b {
    /* renamed from: a */
    static void m1271a(CircleOptions circleOptions, Parcel parcel, int i) {
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
}
