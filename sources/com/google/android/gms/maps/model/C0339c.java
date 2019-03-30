package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0339c {
    /* renamed from: a */
    static void m1272a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0146b.m218a(parcel, 2, groundOverlayOptions.iD(), false);
        C0146b.m220a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0146b.m215a(parcel, 4, groundOverlayOptions.getWidth());
        C0146b.m215a(parcel, 5, groundOverlayOptions.getHeight());
        C0146b.m220a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0146b.m215a(parcel, 7, groundOverlayOptions.getBearing());
        C0146b.m215a(parcel, 8, groundOverlayOptions.getZIndex());
        C0146b.m226a(parcel, 9, groundOverlayOptions.isVisible());
        C0146b.m215a(parcel, 10, groundOverlayOptions.getTransparency());
        C0146b.m215a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0146b.m215a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0146b.m212F(parcel, p);
    }
}
