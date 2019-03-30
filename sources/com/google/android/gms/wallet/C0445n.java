package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.n */
public class C0445n implements Creator<OfferWalletObject> {
    /* renamed from: a */
    static void m1522a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, offerWalletObject.getVersionCode());
        C0146b.m223a(parcel, 2, offerWalletObject.eC, false);
        C0146b.m223a(parcel, 3, offerWalletObject.acj, false);
        C0146b.m212F(parcel, p);
    }

    public OfferWalletObject bj(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OfferWalletObject(i, str2, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public OfferWalletObject[] cv(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cv(x0);
    }
}
