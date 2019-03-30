package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0174a implements Creator<Query> {
    /* renamed from: a */
    static void m334a(Query query, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, query.xH);
        C0146b.m220a(parcel, 1, query.GA, i, false);
        C0146b.m223a(parcel, 3, query.GB, false);
        C0146b.m220a(parcel, 4, query.GC, i, false);
        C0146b.m212F(parcel, p);
    }

    public Query[] aG(int i) {
        return new Query[i];
    }

    public Query ac(Parcel parcel) {
        SortOrder sortOrder = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < o) {
            int i2;
            LogicalFilter logicalFilter2;
            SortOrder sortOrder2;
            String str2;
            int n = C0145a.m195n(parcel);
            SortOrder sortOrder3;
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = i;
                    String str3 = str;
                    logicalFilter2 = (LogicalFilter) C0145a.m177a(parcel, n, LogicalFilter.CREATOR);
                    sortOrder2 = sortOrder;
                    str2 = str3;
                    break;
                case 3:
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    sortOrder3 = sortOrder;
                    str2 = C0145a.m196n(parcel, n);
                    sortOrder2 = sortOrder3;
                    break;
                case 4:
                    sortOrder2 = (SortOrder) C0145a.m177a(parcel, n, SortOrder.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case 1000:
                    sortOrder3 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C0145a.m188g(parcel, n);
                    sortOrder2 = sortOrder3;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    sortOrder2 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() == o) {
            return new Query(i, logicalFilter, str, sortOrder);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ac(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
