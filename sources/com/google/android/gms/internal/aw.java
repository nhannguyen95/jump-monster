package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class aw implements Creator<av> {
    /* renamed from: a */
    static void m655a(av avVar, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, avVar.versionCode);
        C0146b.m235c(parcel, 2, avVar.mq);
        C0146b.m235c(parcel, 3, avVar.backgroundColor);
        C0146b.m235c(parcel, 4, avVar.mr);
        C0146b.m235c(parcel, 5, avVar.ms);
        C0146b.m235c(parcel, 6, avVar.mt);
        C0146b.m235c(parcel, 7, avVar.mu);
        C0146b.m235c(parcel, 8, avVar.mv);
        C0146b.m235c(parcel, 9, avVar.mw);
        C0146b.m223a(parcel, 10, avVar.mx, false);
        C0146b.m235c(parcel, 11, avVar.my);
        C0146b.m223a(parcel, 12, avVar.mz, false);
        C0146b.m235c(parcel, 13, avVar.mA);
        C0146b.m235c(parcel, 14, avVar.mB);
        C0146b.m223a(parcel, 15, avVar.mC, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: c */
    public av m656c(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 3:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    i4 = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    i5 = C0145a.m188g(parcel, n);
                    break;
                case 6:
                    i6 = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    i7 = C0145a.m188g(parcel, n);
                    break;
                case 8:
                    i8 = C0145a.m188g(parcel, n);
                    break;
                case 9:
                    i9 = C0145a.m188g(parcel, n);
                    break;
                case 10:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 11:
                    i10 = C0145a.m188g(parcel, n);
                    break;
                case 12:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 13:
                    i11 = C0145a.m188g(parcel, n);
                    break;
                case 14:
                    i12 = C0145a.m188g(parcel, n);
                    break;
                case 15:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new av(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m656c(x0);
    }

    /* renamed from: e */
    public av[] m657e(int i) {
        return new av[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m657e(x0);
    }
}
