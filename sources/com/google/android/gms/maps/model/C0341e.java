package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0341e {
    /* renamed from: a */
    static void m1274a(LatLng latLng, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, latLng.getVersionCode());
        C0146b.m214a(parcel, 2, latLng.latitude);
        C0146b.m214a(parcel, 3, latLng.longitude);
        C0146b.m212F(parcel, p);
    }
}
