package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C0443l implements Creator<MaskedWalletRequest> {
    /* renamed from: a */
    static void m1520a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0146b.m223a(parcel, 2, maskedWalletRequest.abi, false);
        C0146b.m226a(parcel, 3, maskedWalletRequest.abV);
        C0146b.m226a(parcel, 4, maskedWalletRequest.abW);
        C0146b.m226a(parcel, 5, maskedWalletRequest.abX);
        C0146b.m223a(parcel, 6, maskedWalletRequest.abY, false);
        C0146b.m223a(parcel, 7, maskedWalletRequest.abd, false);
        C0146b.m223a(parcel, 8, maskedWalletRequest.abZ, false);
        C0146b.m220a(parcel, 9, maskedWalletRequest.abr, i, false);
        C0146b.m226a(parcel, 10, maskedWalletRequest.aca);
        C0146b.m226a(parcel, 11, maskedWalletRequest.acb);
        C0146b.m229a(parcel, 12, maskedWalletRequest.acc, i, false);
        C0146b.m226a(parcel, 13, maskedWalletRequest.acd);
        C0146b.m226a(parcel, 14, maskedWalletRequest.ace);
        C0146b.m234b(parcel, 15, maskedWalletRequest.acf, false);
        C0146b.m212F(parcel, p);
    }

    public MaskedWalletRequest bh(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0145a.m184c(parcel, n);
                    break;
                case 4:
                    z2 = C0145a.m184c(parcel, n);
                    break;
                case 5:
                    z3 = C0145a.m184c(parcel, n);
                    break;
                case 6:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    cart = (Cart) C0145a.m177a(parcel, n, Cart.CREATOR);
                    break;
                case 10:
                    z4 = C0145a.m184c(parcel, n);
                    break;
                case 11:
                    z5 = C0145a.m184c(parcel, n);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) C0145a.m182b(parcel, n, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = C0145a.m184c(parcel, n);
                    break;
                case 14:
                    z7 = C0145a.m184c(parcel, n);
                    break;
                case 15:
                    arrayList = C0145a.m183c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public MaskedWalletRequest[] ct(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ct(x0);
    }
}
