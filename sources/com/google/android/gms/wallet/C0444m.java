package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.wallet.m */
public class C0444m implements Creator<NotifyTransactionStatusRequest> {
    /* renamed from: a */
    static void m1521a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, notifyTransactionStatusRequest.xH);
        C0146b.m223a(parcel, 2, notifyTransactionStatusRequest.abh, false);
        C0146b.m235c(parcel, 3, notifyTransactionStatusRequest.status);
        C0146b.m223a(parcel, 4, notifyTransactionStatusRequest.ach, false);
        C0146b.m212F(parcel, p);
    }

    public NotifyTransactionStatusRequest bi(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str2 = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public NotifyTransactionStatusRequest[] cu(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
