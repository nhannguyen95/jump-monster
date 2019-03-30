package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.if */
public class C0288if implements Creator<ie> {
    /* renamed from: a */
    static void m1079a(ie ieVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = ieVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, ieVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m223a(parcel, 2, ieVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m220a(parcel, 4, ieVar.jr(), i, true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, ieVar.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m220a(parcel, 6, ieVar.js(), i, true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C0146b.m223a(parcel, 7, ieVar.getType(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public ie aM(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ic icVar = null;
        String str2 = null;
        ic icVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            ic icVar3;
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    icVar3 = (ic) C0145a.m177a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    icVar2 = icVar3;
                    break;
                case 5:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    icVar3 = (ic) C0145a.m177a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    icVar = icVar3;
                    break;
                case 7:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ie(hashSet, i, str3, icVar2, str2, icVar, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ie[] bP(int i) {
        return new ie[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bP(x0);
    }
}
