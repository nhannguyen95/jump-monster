package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.internal.ih.C0986a;
import com.google.android.gms.internal.ih.C0989b;
import com.google.android.gms.internal.ih.C0990c;
import com.google.android.gms.internal.ih.C0991d;
import com.google.android.gms.internal.ih.C0992f;
import com.google.android.gms.internal.ih.C0993g;
import com.google.android.gms.internal.ih.C0994h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ii implements Creator<ih> {
    /* renamed from: a */
    static void m1080a(ih ihVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        Set ja = ihVar.ja();
        if (ja.contains(Integer.valueOf(1))) {
            C0146b.m235c(parcel, 1, ihVar.getVersionCode());
        }
        if (ja.contains(Integer.valueOf(2))) {
            C0146b.m223a(parcel, 2, ihVar.getAboutMe(), true);
        }
        if (ja.contains(Integer.valueOf(3))) {
            C0146b.m220a(parcel, 3, ihVar.jv(), i, true);
        }
        if (ja.contains(Integer.valueOf(4))) {
            C0146b.m223a(parcel, 4, ihVar.getBirthday(), true);
        }
        if (ja.contains(Integer.valueOf(5))) {
            C0146b.m223a(parcel, 5, ihVar.getBraggingRights(), true);
        }
        if (ja.contains(Integer.valueOf(6))) {
            C0146b.m235c(parcel, 6, ihVar.getCircledByCount());
        }
        if (ja.contains(Integer.valueOf(7))) {
            C0146b.m220a(parcel, 7, ihVar.jw(), i, true);
        }
        if (ja.contains(Integer.valueOf(8))) {
            C0146b.m223a(parcel, 8, ihVar.getCurrentLocation(), true);
        }
        if (ja.contains(Integer.valueOf(9))) {
            C0146b.m223a(parcel, 9, ihVar.getDisplayName(), true);
        }
        if (ja.contains(Integer.valueOf(12))) {
            C0146b.m235c(parcel, 12, ihVar.getGender());
        }
        if (ja.contains(Integer.valueOf(14))) {
            C0146b.m223a(parcel, 14, ihVar.getId(), true);
        }
        if (ja.contains(Integer.valueOf(15))) {
            C0146b.m220a(parcel, 15, ihVar.jx(), i, true);
        }
        if (ja.contains(Integer.valueOf(16))) {
            C0146b.m226a(parcel, 16, ihVar.isPlusUser());
        }
        if (ja.contains(Integer.valueOf(19))) {
            C0146b.m220a(parcel, 19, ihVar.jy(), i, true);
        }
        if (ja.contains(Integer.valueOf(18))) {
            C0146b.m223a(parcel, 18, ihVar.getLanguage(), true);
        }
        if (ja.contains(Integer.valueOf(21))) {
            C0146b.m235c(parcel, 21, ihVar.getObjectType());
        }
        if (ja.contains(Integer.valueOf(20))) {
            C0146b.m223a(parcel, 20, ihVar.getNickname(), true);
        }
        if (ja.contains(Integer.valueOf(23))) {
            C0146b.m234b(parcel, 23, ihVar.jA(), true);
        }
        if (ja.contains(Integer.valueOf(22))) {
            C0146b.m234b(parcel, 22, ihVar.jz(), true);
        }
        if (ja.contains(Integer.valueOf(25))) {
            C0146b.m235c(parcel, 25, ihVar.getRelationshipStatus());
        }
        if (ja.contains(Integer.valueOf(24))) {
            C0146b.m235c(parcel, 24, ihVar.getPlusOneCount());
        }
        if (ja.contains(Integer.valueOf(27))) {
            C0146b.m223a(parcel, 27, ihVar.getUrl(), true);
        }
        if (ja.contains(Integer.valueOf(26))) {
            C0146b.m223a(parcel, 26, ihVar.getTagline(), true);
        }
        if (ja.contains(Integer.valueOf(29))) {
            C0146b.m226a(parcel, 29, ihVar.isVerified());
        }
        if (ja.contains(Integer.valueOf(28))) {
            C0146b.m234b(parcel, 28, ihVar.jB(), true);
        }
        C0146b.m212F(parcel, p);
    }

    public ih aN(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C0986a c0986a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C0989b c0989b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C0990c c0990c = null;
        boolean z = false;
        String str7 = null;
        C0991d c0991d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    C0986a c0986a2 = (C0986a) C0145a.m177a(parcel, n, C0986a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0986a = c0986a2;
                    break;
                case 4:
                    str2 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    C0989b c0989b2 = (C0989b) C0145a.m177a(parcel, n, C0989b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c0989b = c0989b2;
                    break;
                case 8:
                    str4 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C0990c c0990c2 = (C0990c) C0145a.m177a(parcel, n, C0990c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c0990c = c0990c2;
                    break;
                case 16:
                    z = C0145a.m184c(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case 19:
                    C0991d c0991d2 = (C0991d) C0145a.m177a(parcel, n, (Creator) C0991d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c0991d = c0991d2;
                    break;
                case 20:
                    str8 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0145a.m183c(parcel, n, C0992f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0145a.m183c(parcel, n, C0993g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case Keys.VOLUME_DOWN /*25*/:
                    i6 = C0145a.m188g(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case Keys.POWER /*26*/:
                    str9 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case Keys.CAMERA /*27*/:
                    str10 = C0145a.m196n(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case Keys.CLEAR /*28*/:
                    list3 = C0145a.m183c(parcel, n, C0994h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case Keys.f5A /*29*/:
                    z2 = C0145a.m184c(parcel, n);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ih(hashSet, i, str, c0986a, str2, str3, i2, c0989b, str4, str5, i3, str6, c0990c, z, str7, c0991d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ih[] bQ(int i) {
        return new ih[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bQ(x0);
    }
}
