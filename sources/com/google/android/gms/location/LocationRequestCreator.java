package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1221a(LocationRequest locationRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, locationRequest.mPriority);
        C0146b.m235c(parcel, 1000, locationRequest.getVersionCode());
        C0146b.m216a(parcel, 2, locationRequest.Oc);
        C0146b.m216a(parcel, 3, locationRequest.Od);
        C0146b.m226a(parcel, 4, locationRequest.Oe);
        C0146b.m216a(parcel, 5, locationRequest.NV);
        C0146b.m235c(parcel, 6, locationRequest.Of);
        C0146b.m215a(parcel, 7, locationRequest.Og);
        C0146b.m212F(parcel, p);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 4:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 5:
                    j3 = C0145a.m190i(parcel, n);
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    f = C0145a.m192k(parcel, n);
                    break;
                case 1000:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
