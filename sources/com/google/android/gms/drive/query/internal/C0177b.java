package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.b */
public class C0177b implements Creator<FieldOnlyFilter> {
    /* renamed from: a */
    static void m337a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, fieldOnlyFilter.xH);
        C0146b.m220a(parcel, 1, fieldOnlyFilter.GH, i, false);
        C0146b.m212F(parcel, p);
    }

    public FieldOnlyFilter[] aJ(int i) {
        return new FieldOnlyFilter[i];
    }

    public FieldOnlyFilter af(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    metadataBundle = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aJ(x0);
    }
}
