package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.x */
public class C0170x implements Creator<ListParentsRequest> {
    /* renamed from: a */
    static void m323a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, listParentsRequest.xH);
        C0146b.m220a(parcel, 2, listParentsRequest.FB, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: M */
    public ListParentsRequest m324M(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    driveId = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ListParentsRequest(i, driveId);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ListParentsRequest[] aq(int i) {
        return new ListParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m324M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }
}
