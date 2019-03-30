package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.a */
public class C0426a implements Creator<Address> {
    /* renamed from: a */
    static void m1489a(Address address, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, address.getVersionCode());
        C0146b.m223a(parcel, 2, address.name, false);
        C0146b.m223a(parcel, 3, address.NB, false);
        C0146b.m223a(parcel, 4, address.NC, false);
        C0146b.m223a(parcel, 5, address.ND, false);
        C0146b.m223a(parcel, 6, address.qd, false);
        C0146b.m223a(parcel, 7, address.aba, false);
        C0146b.m223a(parcel, 8, address.abb, false);
        C0146b.m223a(parcel, 9, address.NI, false);
        C0146b.m223a(parcel, 10, address.NK, false);
        C0146b.m226a(parcel, 11, address.NL);
        C0146b.m223a(parcel, 12, address.NM, false);
        C0146b.m212F(parcel, p);
    }

    public Address aX(Parcel parcel) {
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
        boolean z = false;
        String str10 = null;
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
                    z = C0145a.m184c(parcel, n);
                    break;
                case 12:
                    str10 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public Address[] cj(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cj(x0);
    }
}
