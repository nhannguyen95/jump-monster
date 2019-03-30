package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.query.Query;

public class aj implements Creator<QueryRequest> {
    /* renamed from: a */
    static void m269a(QueryRequest queryRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, queryRequest.xH);
        C0146b.m220a(parcel, 2, queryRequest.FL, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: X */
    public QueryRequest m270X(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    query = (Query) C0145a.m177a(parcel, n, Query.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new QueryRequest(i, query);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public QueryRequest[] aB(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m270X(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aB(x0);
    }
}
