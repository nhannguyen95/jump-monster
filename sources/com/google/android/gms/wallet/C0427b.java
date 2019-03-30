package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C0427b implements Creator<Cart> {
    /* renamed from: a */
    static void m1490a(Cart cart, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, cart.getVersionCode());
        C0146b.m223a(parcel, 2, cart.abc, false);
        C0146b.m223a(parcel, 3, cart.abd, false);
        C0146b.m234b(parcel, 4, cart.abe, false);
        C0146b.m212F(parcel, p);
    }

    public Cart aY(Parcel parcel) {
        String str = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = C0145a.m183c(parcel, n, LineItem.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public Cart[] ck(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ck(x0);
    }
}
