package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.h */
public class C0439h implements Creator<InstrumentInfo> {
    /* renamed from: a */
    static void m1516a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, instrumentInfo.getVersionCode());
        C0146b.m223a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0146b.m223a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0146b.m212F(parcel, p);
    }

    public InstrumentInfo bd(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public InstrumentInfo[] cp(int i) {
        return new InstrumentInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cp(x0);
    }
}
