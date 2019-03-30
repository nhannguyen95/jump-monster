package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.f */
public class C0430f implements Creator<FullWallet> {
    /* renamed from: a */
    static void m1493a(FullWallet fullWallet, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, fullWallet.getVersionCode());
        C0146b.m223a(parcel, 2, fullWallet.abh, false);
        C0146b.m223a(parcel, 3, fullWallet.abi, false);
        C0146b.m220a(parcel, 4, fullWallet.abj, i, false);
        C0146b.m223a(parcel, 5, fullWallet.abk, false);
        C0146b.m220a(parcel, 6, fullWallet.abl, i, false);
        C0146b.m220a(parcel, 7, fullWallet.abm, i, false);
        C0146b.m230a(parcel, 8, fullWallet.abn, false);
        C0146b.m220a(parcel, 9, fullWallet.abo, i, false);
        C0146b.m220a(parcel, 10, fullWallet.abp, i, false);
        C0146b.m229a(parcel, 11, fullWallet.abq, i, false);
        C0146b.m212F(parcel, p);
    }

    public FullWallet bb(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    proxyCard = (ProxyCard) C0145a.m177a(parcel, n, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    address2 = (Address) C0145a.m177a(parcel, n, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0145a.m177a(parcel, n, Address.CREATOR);
                    break;
                case 8:
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 9:
                    userAddress2 = (UserAddress) C0145a.m177a(parcel, n, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0145a.m177a(parcel, n, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) C0145a.m182b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public FullWallet[] cn(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cn(x0);
    }
}
