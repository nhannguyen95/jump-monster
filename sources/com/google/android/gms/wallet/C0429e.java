package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.e */
public class C0429e implements Creator<C0851d> {
    /* renamed from: a */
    static void m1492a(C0851d c0851d, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, c0851d.getVersionCode());
        C0146b.m220a(parcel, 2, c0851d.abg, i, false);
        C0146b.m212F(parcel, p);
    }

    public C0851d ba(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    loyaltyWalletObject = (LoyaltyWalletObject) C0145a.m177a(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0851d(i, loyaltyWalletObject);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0851d[] cm(int i) {
        return new C0851d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cm(x0);
    }
}
