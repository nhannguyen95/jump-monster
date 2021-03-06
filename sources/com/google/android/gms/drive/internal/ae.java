package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class ae implements Creator<OnListParentsResponse> {
    /* renamed from: a */
    static void m259a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onListParentsResponse.xH);
        C0146b.m220a(parcel, 2, onListParentsResponse.FK, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: S */
    public OnListParentsResponse m260S(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    dataHolder = (DataHolder) C0145a.m177a(parcel, n, DataHolder.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnListParentsResponse[] aw(int i) {
        return new OnListParentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m260S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
