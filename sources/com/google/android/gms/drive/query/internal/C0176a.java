package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0176a implements Creator<ComparisonFilter> {
    /* renamed from: a */
    static void m336a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, comparisonFilter.xH);
        C0146b.m220a(parcel, 1, comparisonFilter.GG, i, false);
        C0146b.m220a(parcel, 2, comparisonFilter.GH, i, false);
        C0146b.m212F(parcel, p);
    }

    public ComparisonFilter[] aI(int i) {
        return new ComparisonFilter[i];
    }

    public ComparisonFilter ae(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < o) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0145a.m177a(parcel, n, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case 2:
                    metadataBundle2 = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0145a.m188g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ae(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aI(x0);
    }
}
