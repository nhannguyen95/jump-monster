package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.fragment.c */
public class C0437c implements Creator<WalletFragmentStyle> {
    /* renamed from: a */
    static void m1514a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, walletFragmentStyle.xH);
        C0146b.m217a(parcel, 2, walletFragmentStyle.acT, false);
        C0146b.m235c(parcel, 3, walletFragmentStyle.acU);
        C0146b.m212F(parcel, p);
    }

    public WalletFragmentStyle bp(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    bundle = C0145a.m199p(parcel, n);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentStyle[] cC(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cC(x0);
    }
}
