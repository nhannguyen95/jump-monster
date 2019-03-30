package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class aa implements Creator<OnDownloadProgressResponse> {
    /* renamed from: a */
    static void m251a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onDownloadProgressResponse.xH);
        C0146b.m216a(parcel, 2, onDownloadProgressResponse.FF);
        C0146b.m216a(parcel, 3, onDownloadProgressResponse.FG);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: O */
    public OnDownloadProgressResponse m252O(Parcel parcel) {
        long j = 0;
        int o = C0145a.m197o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnDownloadProgressResponse[] as(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m252O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return as(x0);
    }
}
