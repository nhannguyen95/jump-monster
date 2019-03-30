package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ag implements Creator<OnSyncMoreResponse> {
    /* renamed from: a */
    static void m263a(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onSyncMoreResponse.xH);
        C0146b.m226a(parcel, 2, onSyncMoreResponse.Fg);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: U */
    public OnSyncMoreResponse m264U(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    z = C0145a.m184c(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnSyncMoreResponse[] ay(int i) {
        return new OnSyncMoreResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m264U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
