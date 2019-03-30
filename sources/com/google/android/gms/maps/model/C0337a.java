package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0337a {
    /* renamed from: a */
    static void m1270a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, cameraPosition.getVersionCode());
        C0146b.m220a(parcel, 2, cameraPosition.target, i, false);
        C0146b.m215a(parcel, 3, cameraPosition.zoom);
        C0146b.m215a(parcel, 4, cameraPosition.tilt);
        C0146b.m215a(parcel, 5, cameraPosition.bearing);
        C0146b.m212F(parcel, p);
    }
}
