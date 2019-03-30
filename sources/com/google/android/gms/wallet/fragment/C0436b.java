package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.fragment.b */
public class C0436b implements Creator<WalletFragmentOptions> {
    /* renamed from: a */
    static void m1513a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, walletFragmentOptions.xH);
        C0146b.m235c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0146b.m235c(parcel, 3, walletFragmentOptions.getTheme());
        C0146b.m220a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C0146b.m235c(parcel, 5, walletFragmentOptions.getMode());
        C0146b.m212F(parcel, p);
    }

    public WalletFragmentOptions bo(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int o = C0145a.m197o(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) C0145a.m177a(parcel, n, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentOptions[] cB(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cB(x0);
    }
}
