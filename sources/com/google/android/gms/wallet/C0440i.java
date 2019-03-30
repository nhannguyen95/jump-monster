package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.i */
public class C0440i implements Creator<LineItem> {
    /* renamed from: a */
    static void m1517a(LineItem lineItem, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, lineItem.getVersionCode());
        C0146b.m223a(parcel, 2, lineItem.description, false);
        C0146b.m223a(parcel, 3, lineItem.abv, false);
        C0146b.m223a(parcel, 4, lineItem.abw, false);
        C0146b.m223a(parcel, 5, lineItem.abc, false);
        C0146b.m235c(parcel, 6, lineItem.abx);
        C0146b.m223a(parcel, 7, lineItem.abd, false);
        C0146b.m212F(parcel, p);
    }

    public LineItem be(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0145a.m197o(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 4:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 5:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 7:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public LineItem[] cq(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return be(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cq(x0);
    }
}
