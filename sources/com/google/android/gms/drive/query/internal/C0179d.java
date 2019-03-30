package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.query.internal.d */
public class C0179d implements Creator<FilterHolder> {
    /* renamed from: a */
    static void m339a(FilterHolder filterHolder, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m220a(parcel, 1, filterHolder.GK, i, false);
        C0146b.m235c(parcel, 1000, filterHolder.xH);
        C0146b.m220a(parcel, 2, filterHolder.GL, i, false);
        C0146b.m220a(parcel, 3, filterHolder.GM, i, false);
        C0146b.m220a(parcel, 4, filterHolder.GN, i, false);
        C0146b.m220a(parcel, 5, filterHolder.GO, i, false);
        C0146b.m220a(parcel, 6, filterHolder.GP, i, false);
        C0146b.m212F(parcel, p);
    }

    public FilterHolder[] aL(int i) {
        return new FilterHolder[i];
    }

    public FilterHolder ah(Parcel parcel) {
        MatchAllFilter matchAllFilter = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) C0145a.m177a(parcel, n, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) C0145a.m177a(parcel, n, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) C0145a.m177a(parcel, n, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) C0145a.m177a(parcel, n, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) C0145a.m177a(parcel, n, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) C0145a.m177a(parcel, n, MatchAllFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
