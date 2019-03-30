package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.k */
public class C0442k implements Creator<MaskedWallet> {
    /* renamed from: a */
    static void m1519a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, maskedWallet.getVersionCode());
        C0146b.m223a(parcel, 2, maskedWallet.abh, false);
        C0146b.m223a(parcel, 3, maskedWallet.abi, false);
        C0146b.m230a(parcel, 4, maskedWallet.abn, false);
        C0146b.m223a(parcel, 5, maskedWallet.abk, false);
        C0146b.m220a(parcel, 6, maskedWallet.abl, i, false);
        C0146b.m220a(parcel, 7, maskedWallet.abm, i, false);
        C0146b.m229a(parcel, 8, maskedWallet.abT, i, false);
        C0146b.m229a(parcel, 9, maskedWallet.abU, i, false);
        C0146b.m220a(parcel, 10, maskedWallet.abo, i, false);
        C0146b.m220a(parcel, 11, maskedWallet.abp, i, false);
        C0146b.m229a(parcel, 12, maskedWallet.abq, i, false);
        C0146b.m212F(parcel, p);
    }

    public MaskedWallet bg(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 5:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    address = (Address) C0145a.m177a(parcel, n, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) C0145a.m177a(parcel, n, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0145a.m182b(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0145a.m182b(parcel, n, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0145a.m177a(parcel, n, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C0145a.m177a(parcel, n, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) C0145a.m182b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public MaskedWallet[] cs(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
