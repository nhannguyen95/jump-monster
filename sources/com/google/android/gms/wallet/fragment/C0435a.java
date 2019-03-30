package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

/* renamed from: com.google.android.gms.wallet.fragment.a */
public class C0435a implements Creator<WalletFragmentInitParams> {
    /* renamed from: a */
    static void m1512a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, walletFragmentInitParams.xH);
        C0146b.m223a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0146b.m220a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0146b.m235c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0146b.m220a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C0146b.m212F(parcel, p);
    }

    public WalletFragmentInitParams bn(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
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
                    maskedWalletRequest = (MaskedWalletRequest) C0145a.m177a(parcel, n, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) C0145a.m177a(parcel, n, MaskedWallet.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public WalletFragmentInitParams[] cA(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cA(x0);
    }
}
