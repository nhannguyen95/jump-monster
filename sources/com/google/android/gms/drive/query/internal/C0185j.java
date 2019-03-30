package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.query.internal.j */
public class C0185j implements Creator<Operator> {
    /* renamed from: a */
    static void m345a(Operator operator, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1000, operator.xH);
        C0146b.m223a(parcel, 1, operator.mTag, false);
        C0146b.m212F(parcel, p);
    }

    public Operator[] aQ(int i) {
        return new Operator[i];
    }

    public Operator am(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str = C0145a.m196n(parcel, n);
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
            return new Operator(i, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
