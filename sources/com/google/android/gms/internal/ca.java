package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ca implements Creator<cb> {
    /* renamed from: a */
    static void m680a(cb cbVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, cbVar.versionCode);
        C0146b.m223a(parcel, 2, cbVar.nN, false);
        C0146b.m223a(parcel, 3, cbVar.nO, false);
        C0146b.m223a(parcel, 4, cbVar.mimeType, false);
        C0146b.m223a(parcel, 5, cbVar.packageName, false);
        C0146b.m223a(parcel, 6, cbVar.nP, false);
        C0146b.m223a(parcel, 7, cbVar.nQ, false);
        C0146b.m223a(parcel, 8, cbVar.nR, false);
        C0146b.m212F(parcel, p);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m681d(x0);
    }

    /* renamed from: d */
    public cb m681d(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str7 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str6 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new cb(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: h */
    public cb[] m682h(int i) {
        return new cb[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m682h(x0);
    }
}
