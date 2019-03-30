package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.g */
public class C0182g implements Creator<LogicalFilter> {
    /* renamed from: a */
    static void m342a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, logicalFilter.xH);
        C0146b.m220a(parcel, 1, logicalFilter.GG, i, false);
        C0146b.m234b(parcel, 2, logicalFilter.GS, false);
        C0146b.m212F(parcel, p);
    }

    public LogicalFilter[] aN(int i) {
        return new LogicalFilter[i];
    }

    public LogicalFilter aj(Parcel parcel) {
        List list = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            Operator operator2;
            ArrayList c;
            int n = C0145a.m195n(parcel);
            List list2;
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0145a.m177a(parcel, n, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    c = C0145a.m183c(parcel, n, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0145a.m188g(parcel, n);
                    list2 = list3;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == o) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aN(x0);
    }
}
