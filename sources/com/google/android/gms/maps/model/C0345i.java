package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0345i {
    /* renamed from: a */
    static void m1278a(Tile tile, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, tile.getVersionCode());
        C0146b.m235c(parcel, 2, tile.width);
        C0146b.m235c(parcel, 3, tile.height);
        C0146b.m227a(parcel, 4, tile.data, false);
        C0146b.m212F(parcel, p);
    }
}
