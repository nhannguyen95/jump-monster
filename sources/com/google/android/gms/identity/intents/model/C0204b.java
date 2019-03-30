package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0204b implements Creator<UserAddress> {
    /* renamed from: a */
    static void m589a(UserAddress userAddress, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, userAddress.getVersionCode());
        C0146b.m223a(parcel, 2, userAddress.name, false);
        C0146b.m223a(parcel, 3, userAddress.NB, false);
        C0146b.m223a(parcel, 4, userAddress.NC, false);
        C0146b.m223a(parcel, 5, userAddress.ND, false);
        C0146b.m223a(parcel, 6, userAddress.NE, false);
        C0146b.m223a(parcel, 7, userAddress.NF, false);
        C0146b.m223a(parcel, 8, userAddress.NG, false);
        C0146b.m223a(parcel, 9, userAddress.NH, false);
        C0146b.m223a(parcel, 10, userAddress.qd, false);
        C0146b.m223a(parcel, 11, userAddress.NI, false);
        C0146b.m223a(parcel, 12, userAddress.NJ, false);
        C0146b.m223a(parcel, 13, userAddress.NK, false);
        C0146b.m226a(parcel, 14, userAddress.NL);
        C0146b.m223a(parcel, 15, userAddress.NM, false);
        C0146b.m223a(parcel, 16, userAddress.NN, false);
        C0146b.m212F(parcel, p);
    }

    public UserAddress aA(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    str6 = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    str7 = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    str8 = C0145a.m196n(parcel, n);
                    break;
                case 10:
                    str9 = C0145a.m196n(parcel, n);
                    break;
                case 11:
                    str10 = C0145a.m196n(parcel, n);
                    break;
                case 12:
                    str11 = C0145a.m196n(parcel, n);
                    break;
                case 13:
                    str12 = C0145a.m196n(parcel, n);
                    break;
                case 14:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 15:
                    str13 = C0145a.m196n(parcel, n);
                    break;
                case 16:
                    str14 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public UserAddress[] bu(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bu(x0);
    }
}
