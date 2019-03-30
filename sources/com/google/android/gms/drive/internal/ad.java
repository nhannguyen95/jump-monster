package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ad implements Creator<OnListEntriesResponse> {
    /* renamed from: a */
    static void m257a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onListEntriesResponse.xH);
        C0146b.m220a(parcel, 2, onListEntriesResponse.FJ, i, false);
        C0146b.m226a(parcel, 3, onListEntriesResponse.Fg);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: R */
    public OnListEntriesResponse m258R(Parcel parcel) {
        boolean z = false;
        int o = C0145a.m197o(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = C0145a.m188g(parcel, n);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) C0145a.m177a(parcel, n, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = C0145a.m184c(parcel, n);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == o) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnListEntriesResponse[] av(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m258R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return av(x0);
    }
}
