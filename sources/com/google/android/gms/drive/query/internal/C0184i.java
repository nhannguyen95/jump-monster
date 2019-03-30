package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.query.internal.i */
public class C0184i implements Creator<NotFilter> {
    /* renamed from: a */
    static void m344a(NotFilter notFilter, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, notFilter.xH);
        C0146b.m220a(parcel, 1, notFilter.GT, i, false);
        C0146b.m212F(parcel, p);
    }

    public NotFilter[] aP(int i) {
        return new NotFilter[i];
    }

    public NotFilter al(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    filterHolder = (FilterHolder) C0145a.m177a(parcel, n, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return al(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
