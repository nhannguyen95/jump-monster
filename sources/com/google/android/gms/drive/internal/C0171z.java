package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C0171z implements Creator<OnContentsResponse> {
    /* renamed from: a */
    static void m325a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onContentsResponse.xH);
        C0146b.m220a(parcel, 2, onContentsResponse.EA, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: N */
    public OnContentsResponse m326N(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    contents = (Contents) C0145a.m177a(parcel, n, Contents.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnContentsResponse[] ar(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m326N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
