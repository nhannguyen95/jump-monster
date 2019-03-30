package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class al implements Creator<ak> {
    /* renamed from: a */
    static void m615a(ak akVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, akVar.versionCode);
        C0146b.m223a(parcel, 2, akVar.lS, false);
        C0146b.m235c(parcel, 3, akVar.height);
        C0146b.m235c(parcel, 4, akVar.heightPixels);
        C0146b.m226a(parcel, 5, akVar.lT);
        C0146b.m235c(parcel, 6, akVar.width);
        C0146b.m235c(parcel, 7, akVar.widthPixels);
        C0146b.m229a(parcel, 8, akVar.lU, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: b */
    public ak m616b(Parcel parcel) {
        ak[] akVarArr = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i5 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    akVarArr = (ak[]) C0145a.m182b(parcel, n, ak.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ak(i5, str, i4, i3, z, i2, i, akVarArr);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: c */
    public ak[] m617c(int i) {
        return new ak[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m616b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m617c(x0);
    }
}
