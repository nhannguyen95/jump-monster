package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0340d {
    /* renamed from: a */
    static void m1273a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, latLngBounds.getVersionCode());
        C0146b.m220a(parcel, 2, latLngBounds.southwest, i, false);
        C0146b.m220a(parcel, 3, latLngBounds.northeast, i, false);
        C0146b.m212F(parcel, p);
    }
}
