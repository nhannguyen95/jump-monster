package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.b */
public class C0175b implements Creator<SortOrder> {
    /* renamed from: a */
    static void m335a(SortOrder sortOrder, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, sortOrder.xH);
        C0146b.m234b(parcel, 1, sortOrder.GF, false);
        C0146b.m212F(parcel, p);
    }

    public SortOrder[] aH(int i) {
        return new SortOrder[i];
    }

    public SortOrder ad(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    list = C0145a.m183c(parcel, n, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, list);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
