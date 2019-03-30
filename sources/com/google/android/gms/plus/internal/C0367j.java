package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C0367j implements Creator<C0808h> {
    /* renamed from: a */
    static void m1327a(C0808h c0808h, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m223a(parcel, 1, c0808h.getAccountName(), false);
        C0146b.m235c(parcel, 1000, c0808h.getVersionCode());
        C0146b.m230a(parcel, 2, c0808h.iP(), false);
        C0146b.m230a(parcel, 3, c0808h.iQ(), false);
        C0146b.m230a(parcel, 4, c0808h.iR(), false);
        C0146b.m223a(parcel, 5, c0808h.iS(), false);
        C0146b.m223a(parcel, 6, c0808h.iT(), false);
        C0146b.m223a(parcel, 7, c0808h.iU(), false);
        C0146b.m223a(parcel, 8, c0808h.iV(), false);
        C0146b.m220a(parcel, 9, c0808h.iW(), i, false);
        C0146b.m212F(parcel, p);
    }

    public C0808h aK(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    str5 = C0145a.m196n(parcel, n);
                    break;
                case 2:
                    strArr3 = C0145a.m209z(parcel, n);
                    break;
                case 3:
                    strArr2 = C0145a.m209z(parcel, n);
                    break;
                case 4:
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 5:
                    str4 = C0145a.m196n(parcel, n);
                    break;
                case 6:
                    str3 = C0145a.m196n(parcel, n);
                    break;
                case 7:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 8:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) C0145a.m177a(parcel, n, PlusCommonExtras.CREATOR);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0808h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public C0808h[] bN(int i) {
        return new C0808h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bN(x0);
    }
}
