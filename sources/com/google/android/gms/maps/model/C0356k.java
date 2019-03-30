package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C0356k {
    /* renamed from: a */
    static void m1292a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, visibleRegion.getVersionCode());
        C0146b.m220a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0146b.m220a(parcel, 3, visibleRegion.nearRight, i, false);
        C0146b.m220a(parcel, 4, visibleRegion.farLeft, i, false);
        C0146b.m220a(parcel, 5, visibleRegion.farRight, i, false);
        C0146b.m220a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0146b.m212F(parcel, p);
    }
}
