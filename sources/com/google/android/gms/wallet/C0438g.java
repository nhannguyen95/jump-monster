package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.g */
public class C0438g implements Creator<FullWalletRequest> {
    /* renamed from: a */
    static void m1515a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, fullWalletRequest.getVersionCode());
        C0146b.m223a(parcel, 2, fullWalletRequest.abh, false);
        C0146b.m223a(parcel, 3, fullWalletRequest.abi, false);
        C0146b.m220a(parcel, 4, fullWalletRequest.abr, i, false);
        C0146b.m212F(parcel, p);
    }

    public FullWalletRequest bc(Parcel parcel) {
        Cart cart = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
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
                case 4:
                    cart = (Cart) C0145a.m177a(parcel, n, Cart.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public FullWalletRequest[] co(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
