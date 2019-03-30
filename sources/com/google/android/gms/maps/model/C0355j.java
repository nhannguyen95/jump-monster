package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0355j {
    /* renamed from: a */
    static void m1291a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0146b.m218a(parcel, 2, tileOverlayOptions.iG(), false);
        C0146b.m226a(parcel, 3, tileOverlayOptions.isVisible());
        C0146b.m215a(parcel, 4, tileOverlayOptions.getZIndex());
        C0146b.m212F(parcel, p);
    }
}
