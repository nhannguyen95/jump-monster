package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.internal.k */
public class C0163k implements Creator<DisconnectRequest> {
    /* renamed from: a */
    static void m290a(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, disconnectRequest.xH);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: K */
    public DisconnectRequest m291K(Parcel parcel) {
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
            return new DisconnectRequest(i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public DisconnectRequest[] ao(int i) {
        return new DisconnectRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m291K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ao(x0);
    }
}
