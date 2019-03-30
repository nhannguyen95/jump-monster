package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0342f {
    /* renamed from: a */
    static void m1275a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, markerOptions.getVersionCode());
        C0146b.m220a(parcel, 2, markerOptions.getPosition(), i, false);
        C0146b.m223a(parcel, 3, markerOptions.getTitle(), false);
        C0146b.m223a(parcel, 4, markerOptions.getSnippet(), false);
        C0146b.m218a(parcel, 5, markerOptions.iE(), false);
        C0146b.m215a(parcel, 6, markerOptions.getAnchorU());
        C0146b.m215a(parcel, 7, markerOptions.getAnchorV());
        C0146b.m226a(parcel, 8, markerOptions.isDraggable());
        C0146b.m226a(parcel, 9, markerOptions.isVisible());
        C0146b.m212F(parcel, p);
    }
}
