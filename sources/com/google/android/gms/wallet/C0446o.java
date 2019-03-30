package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.o */
public class C0446o implements Creator<ProxyCard> {
    /* renamed from: a */
    static void m1523a(ProxyCard proxyCard, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, proxyCard.getVersionCode());
        C0146b.m223a(parcel, 2, proxyCard.ack, false);
        C0146b.m223a(parcel, 3, proxyCard.acl, false);
        C0146b.m235c(parcel, 4, proxyCard.acm);
        C0146b.m235c(parcel, 5, proxyCard.acn);
        C0146b.m212F(parcel, p);
    }

    public ProxyCard bk(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    i2 = C0145a.m188g(parcel, n);
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
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bk(x0);
    }

    public ProxyCard[] cw(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cw(x0);
    }
}
