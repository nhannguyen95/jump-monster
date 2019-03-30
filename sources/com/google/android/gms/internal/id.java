package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class id implements Creator<ic> {
    /* renamed from: a */
    static void m1078a(ic icVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = icVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, icVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m220a(parcel, 2, icVar.jb(), i, true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m224a(parcel, 3, icVar.getAdditionalName(), true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m220a(parcel, 4, icVar.jc(), i, true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, icVar.getAddressCountry(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m223a(parcel, 6, icVar.getAddressLocality(), true);
        }
        if (ja.contains(Integer.valueOf(7))) {
            C0146b.m223a(parcel, 7, icVar.getAddressRegion(), true);
        }
        if (ja.contains(Integer.valueOf(8))) {
            C0146b.m234b(parcel, 8, icVar.jd(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C0146b.m235c(parcel, 9, icVar.getAttendeeCount());
        }
        if (ja.contains(Integer.valueOf(10))) {
            C0146b.m234b(parcel, 10, icVar.je(), true);
        }
        if (ja.contains(Integer.valueOf(11))) {
            C0146b.m220a(parcel, 11, icVar.jf(), i, true);
        }
        if (ja.contains(Integer.valueOf(12))) {
            C0146b.m234b(parcel, 12, icVar.jg(), true);
        }
        if (ja.contains(Integer.valueOf(13))) {
            C0146b.m223a(parcel, 13, icVar.getBestRating(), true);
        }
        if (ja.contains(Integer.valueOf(14))) {
            C0146b.m223a(parcel, 14, icVar.getBirthDate(), true);
        }
        if (ja.contains(Integer.valueOf(15))) {
            C0146b.m220a(parcel, 15, icVar.jh(), i, true);
        }
        if (ja.contains(Integer.valueOf(17))) {
            C0146b.m223a(parcel, 17, icVar.getContentSize(), true);
        }
        if (ja.contains(Integer.valueOf(16))) {
            C0146b.m223a(parcel, 16, icVar.getCaption(), true);
        }
        if (ja.contains(Integer.valueOf(19))) {
            C0146b.m234b(parcel, 19, icVar.ji(), true);
        }
        if (ja.contains(Integer.valueOf(18))) {
            C0146b.m223a(parcel, 18, icVar.getContentUrl(), true);
        }
        if (ja.contains(Integer.valueOf(21))) {
            C0146b.m223a(parcel, 21, icVar.getDateModified(), true);
        }
        if (ja.contains(Integer.valueOf(20))) {
            C0146b.m223a(parcel, 20, icVar.getDateCreated(), true);
        }
        if (ja.contains(Integer.valueOf(23))) {
            C0146b.m223a(parcel, 23, icVar.getDescription(), true);
        }
        if (ja.contains(Integer.valueOf(22))) {
            C0146b.m223a(parcel, 22, icVar.getDatePublished(), true);
        }
        if (ja.contains(Integer.valueOf(25))) {
            C0146b.m223a(parcel, 25, icVar.getEmbedUrl(), true);
        }
        if (ja.contains(Integer.valueOf(24))) {
            C0146b.m223a(parcel, 24, icVar.getDuration(), true);
        }
        if (ja.contains(Integer.valueOf(27))) {
            C0146b.m223a(parcel, 27, icVar.getFamilyName(), true);
        }
        if (ja.contains(Integer.valueOf(26))) {
            C0146b.m223a(parcel, 26, icVar.getEndDate(), true);
        }
        if (ja.contains(Integer.valueOf(29))) {
            C0146b.m220a(parcel, 29, icVar.jj(), i, true);
        }
        if (ja.contains(Integer.valueOf(28))) {
            C0146b.m223a(parcel, 28, icVar.getGender(), true);
        }
        if (ja.contains(Integer.valueOf(31))) {
            C0146b.m223a(parcel, 31, icVar.getHeight(), true);
        }
        if (ja.contains(Integer.valueOf(30))) {
            C0146b.m223a(parcel, 30, icVar.getGivenName(), true);
        }
        if (ja.contains(Integer.valueOf(34))) {
            C0146b.m220a(parcel, 34, icVar.jk(), i, true);
        }
        if (ja.contains(Integer.valueOf(32))) {
            C0146b.m223a(parcel, 32, icVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(33))) {
            C0146b.m223a(parcel, 33, icVar.getImage(), true);
        }
        if (ja.contains(Integer.valueOf(38))) {
            C0146b.m214a(parcel, 38, icVar.getLongitude());
        }
        if (ja.contains(Integer.valueOf(39))) {
            C0146b.m223a(parcel, 39, icVar.getName(), true);
        }
        if (ja.contains(Integer.valueOf(36))) {
            C0146b.m214a(parcel, 36, icVar.getLatitude());
        }
        if (ja.contains(Integer.valueOf(37))) {
            C0146b.m220a(parcel, 37, icVar.jl(), i, true);
        }
        if (ja.contains(Integer.valueOf(42))) {
            C0146b.m223a(parcel, 42, icVar.getPlayerType(), true);
        }
        if (ja.contains(Integer.valueOf(43))) {
            C0146b.m223a(parcel, 43, icVar.getPostOfficeBoxNumber(), true);
        }
        if (ja.contains(Integer.valueOf(40))) {
            C0146b.m220a(parcel, 40, icVar.jm(), i, true);
        }
        if (ja.contains(Integer.valueOf(41))) {
            C0146b.m234b(parcel, 41, icVar.jn(), true);
        }
        if (ja.contains(Integer.valueOf(46))) {
            C0146b.m220a(parcel, 46, icVar.jo(), i, true);
        }
        if (ja.contains(Integer.valueOf(47))) {
            C0146b.m223a(parcel, 47, icVar.getStartDate(), true);
        }
        if (ja.contains(Integer.valueOf(44))) {
            C0146b.m223a(parcel, 44, icVar.getPostalCode(), true);
        }
        if (ja.contains(Integer.valueOf(45))) {
            C0146b.m223a(parcel, 45, icVar.getRatingValue(), true);
        }
        if (ja.contains(Integer.valueOf(51))) {
            C0146b.m223a(parcel, 51, icVar.getThumbnailUrl(), true);
        }
        if (ja.contains(Integer.valueOf(50))) {
            C0146b.m220a(parcel, 50, icVar.jp(), i, true);
        }
        if (ja.contains(Integer.valueOf(49))) {
            C0146b.m223a(parcel, 49, icVar.getText(), true);
        }
        if (ja.contains(Integer.valueOf(48))) {
            C0146b.m223a(parcel, 48, icVar.getStreetAddress(), true);
        }
        if (ja.contains(Integer.valueOf(55))) {
            C0146b.m223a(parcel, 55, icVar.getWidth(), true);
        }
        if (ja.contains(Integer.valueOf(54))) {
            C0146b.m223a(parcel, 54, icVar.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(53))) {
            C0146b.m223a(parcel, 53, icVar.getType(), true);
        }
        if (ja.contains(Integer.valueOf(52))) {
            C0146b.m223a(parcel, 52, icVar.getTickerSymbol(), true);
        }
        if (ja.contains(Integer.valueOf(56))) {
            C0146b.m223a(parcel, 56, icVar.getWorstRating(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public ic aL(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ic icVar = null;
        List list = null;
        ic icVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        ic icVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        ic icVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        ic icVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        ic icVar6 = null;
        double d = 0.0d;
        ic icVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        ic icVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        ic icVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        ic icVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            ic icVar11;
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    icVar11 = (ic) C0145a.m177a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    icVar = icVar11;
                    break;
                case 3:
                    list = C0145a.m172A(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    icVar11 = (ic) C0145a.m177a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    icVar2 = icVar11;
                    break;
                case 5:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list2 = C0145a.m183c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list3 = C0145a.m183c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    icVar11 = (ic) C0145a.m177a(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    icVar3 = icVar11;
                    break;
                case 12:
                    list4 = C0145a.m183c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    icVar4 = icVar11;
                    break;
                case 16:
                    str6 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    list5 = C0145a.m183c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case 20:
                    str9 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case Keys.VOLUME_DOWN /*25*/:
                    str14 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case Keys.POWER /*26*/:
                    str15 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case Keys.CAMERA /*27*/:
                    str16 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case Keys.CLEAR /*28*/:
                    str17 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case Keys.f5A /*29*/:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    icVar5 = icVar11;
                    break;
                case Keys.f6B /*30*/:
                    str18 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case Keys.f7C /*31*/:
                    str19 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case Keys.f9E /*33*/:
                    str21 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case Keys.f10F /*34*/:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    icVar6 = icVar11;
                    break;
                case Keys.f12H /*36*/:
                    d = C0145a.m193l(parcel, n);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case Keys.f13I /*37*/:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    icVar7 = icVar11;
                    break;
                case Keys.f14J /*38*/:
                    d2 = C0145a.m193l(parcel, n);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case Keys.f15K /*39*/:
                    str22 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case Keys.f16L /*40*/:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    icVar8 = icVar11;
                    break;
                case Keys.f17M /*41*/:
                    list6 = C0145a.m183c(parcel, n, ic.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case Keys.f18N /*42*/:
                    str23 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case Keys.f19O /*43*/:
                    str24 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case Keys.f20P /*44*/:
                    str25 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case Keys.f21Q /*45*/:
                    str26 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case Keys.f22R /*46*/:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    icVar9 = icVar11;
                    break;
                case Keys.f23S /*47*/:
                    str27 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case Keys.f24T /*48*/:
                    str28 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case Keys.f25U /*49*/:
                    str29 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    icVar11 = (ic) C0145a.m177a(parcel, n, (Creator) ic.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    icVar10 = icVar11;
                    break;
                case Keys.f27W /*51*/:
                    str30 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case Keys.f28X /*52*/:
                    str31 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case Keys.f29Y /*53*/:
                    str32 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case Keys.f30Z /*54*/:
                    str33 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case Keys.COMMA /*55*/:
                    str34 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case Keys.PERIOD /*56*/:
                    str35 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ic(hashSet, i, icVar, list, icVar2, str, str2, str3, list2, i2, list3, icVar3, list4, str4, str5, icVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, icVar5, str18, str19, str20, str21, icVar6, d, icVar7, d2, str22, icVar8, list6, str23, str24, str25, str26, icVar9, str27, str28, str29, icVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ic[] bO(int i) {
        return new ic[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
