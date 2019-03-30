package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.ju;
import com.google.android.gms.internal.jw;
import com.google.android.gms.internal.jy;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C0441j implements Creator<LoyaltyWalletObject> {
    /* renamed from: a */
    static void m1518a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0146b.m223a(parcel, 2, loyaltyWalletObject.eC, false);
        C0146b.m223a(parcel, 3, loyaltyWalletObject.abz, false);
        C0146b.m223a(parcel, 4, loyaltyWalletObject.abA, false);
        C0146b.m223a(parcel, 5, loyaltyWalletObject.abB, false);
        C0146b.m223a(parcel, 6, loyaltyWalletObject.abC, false);
        C0146b.m223a(parcel, 7, loyaltyWalletObject.abD, false);
        C0146b.m223a(parcel, 8, loyaltyWalletObject.abE, false);
        C0146b.m223a(parcel, 9, loyaltyWalletObject.abF, false);
        C0146b.m223a(parcel, 10, loyaltyWalletObject.abG, false);
        C0146b.m223a(parcel, 11, loyaltyWalletObject.abH, false);
        C0146b.m235c(parcel, 12, loyaltyWalletObject.state);
        C0146b.m234b(parcel, 13, loyaltyWalletObject.abI, false);
        C0146b.m220a(parcel, 14, loyaltyWalletObject.abJ, i, false);
        C0146b.m234b(parcel, 15, loyaltyWalletObject.abK, false);
        C0146b.m223a(parcel, 17, loyaltyWalletObject.abM, false);
        C0146b.m223a(parcel, 16, loyaltyWalletObject.abL, false);
        C0146b.m226a(parcel, 19, loyaltyWalletObject.abO);
        C0146b.m234b(parcel, 18, loyaltyWalletObject.abN, false);
        C0146b.m234b(parcel, 21, loyaltyWalletObject.abQ, false);
        C0146b.m234b(parcel, 20, loyaltyWalletObject.abP, false);
        C0146b.m220a(parcel, 23, loyaltyWalletObject.abS, i, false);
        C0146b.m234b(parcel, 22, loyaltyWalletObject.abR, false);
        C0146b.m212F(parcel, p);
    }

    public LoyaltyWalletObject bf(Parcel parcel) {
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
        String str10 = null;
        int i2 = 0;
        ArrayList fs = gi.fs();
        ju juVar = null;
        ArrayList fs2 = gi.fs();
        String str11 = null;
        String str12 = null;
        ArrayList fs3 = gi.fs();
        boolean z = false;
        ArrayList fs4 = gi.fs();
        ArrayList fs5 = gi.fs();
        ArrayList fs6 = gi.fs();
        jo joVar = null;
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
                    str10 = C0145a.m196n(parcel, n);
                    break;
                case 12:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 13:
                    fs = C0145a.m183c(parcel, n, jy.CREATOR);
                    break;
                case 14:
                    juVar = (ju) C0145a.m177a(parcel, n, ju.CREATOR);
                    break;
                case 15:
                    fs2 = C0145a.m183c(parcel, n, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = C0145a.m196n(parcel, n);
                    break;
                case 17:
                    str12 = C0145a.m196n(parcel, n);
                    break;
                case 18:
                    fs3 = C0145a.m183c(parcel, n, jm.CREATOR);
                    break;
                case 19:
                    z = C0145a.m184c(parcel, n);
                    break;
                case 20:
                    fs4 = C0145a.m183c(parcel, n, jw.CREATOR);
                    break;
                case 21:
                    fs5 = C0145a.m183c(parcel, n, js.CREATOR);
                    break;
                case 22:
                    fs6 = C0145a.m183c(parcel, n, jw.CREATOR);
                    break;
                case 23:
                    joVar = (jo) C0145a.m177a(parcel, n, jo.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, fs, juVar, fs2, str11, str12, fs3, z, fs4, fs5, fs6, joVar);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public LoyaltyWalletObject[] cr(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cr(x0);
    }
}
