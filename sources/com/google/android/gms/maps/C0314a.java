package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.a */
public class C0314a {
    /* renamed from: a */
    static void m1227a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, googleMapOptions.getVersionCode());
        C0146b.m213a(parcel, 2, googleMapOptions.ig());
        C0146b.m213a(parcel, 3, googleMapOptions.ih());
        C0146b.m235c(parcel, 4, googleMapOptions.getMapType());
        C0146b.m220a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0146b.m213a(parcel, 6, googleMapOptions.ii());
        C0146b.m213a(parcel, 7, googleMapOptions.ij());
        C0146b.m213a(parcel, 8, googleMapOptions.ik());
        C0146b.m213a(parcel, 9, googleMapOptions.il());
        C0146b.m213a(parcel, 10, googleMapOptions.im());
        C0146b.m213a(parcel, 11, googleMapOptions.in());
        C0146b.m212F(parcel, p);
    }
}
