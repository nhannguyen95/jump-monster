package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class af implements Creator<OnMetadataResponse> {
    /* renamed from: a */
    static void m261a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, onMetadataResponse.xH);
        C0146b.m220a(parcel, 2, onMetadataResponse.EZ, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: T */
    public OnMetadataResponse m262T(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OnMetadataResponse[] ax(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m262T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
