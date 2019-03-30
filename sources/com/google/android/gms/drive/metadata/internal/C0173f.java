package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0173f implements Creator<MetadataBundle> {
    /* renamed from: a */
    static void m332a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, metadataBundle.xH);
        C0146b.m217a(parcel, 2, metadataBundle.FQ, false);
        C0146b.m212F(parcel, p);
    }

    public MetadataBundle[] aF(int i) {
        return new MetadataBundle[i];
    }

    public MetadataBundle ab(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ab(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aF(x0);
    }
}
