package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.internal.f */
public class C0159f implements Creator<CreateContentsRequest> {
    /* renamed from: a */
    static void m282a(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, createContentsRequest.xH);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: G */
    public CreateContentsRequest m283G(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CreateContentsRequest(i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CreateContentsRequest[] ak(int i) {
        return new CreateContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m283G(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }
}
