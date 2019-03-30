package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0178c implements Creator<FieldWithSortOrder> {
    /* renamed from: a */
    static void m338a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, fieldWithSortOrder.xH);
        C0146b.m223a(parcel, 1, fieldWithSortOrder.FM, false);
        C0146b.m226a(parcel, 2, fieldWithSortOrder.GJ);
        C0146b.m212F(parcel, p);
    }

    public FieldWithSortOrder[] aK(int i) {
        return new FieldWithSortOrder[i];
    }

    public FieldWithSortOrder ag(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aK(x0);
    }
}
