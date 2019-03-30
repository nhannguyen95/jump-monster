package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class kj implements Creator<ki> {
    /* renamed from: a */
    static void m1121a(ki kiVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, kiVar.xH);
        C0146b.m235c(parcel, 2, kiVar.fA());
        C0146b.m223a(parcel, 3, kiVar.getPath(), false);
        C0146b.m227a(parcel, 4, kiVar.getData(), false);
        C0146b.m223a(parcel, 5, kiVar.getSource(), false);
        C0146b.m212F(parcel, p);
    }

    public ki by(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0145a.m197o(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    bArr = C0145a.m200q(parcel, n);
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ki(i2, i, str2, bArr, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ki[] cN(int i) {
        return new ki[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return by(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cN(x0);
    }
}
