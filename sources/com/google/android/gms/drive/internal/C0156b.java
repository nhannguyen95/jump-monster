package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0156b implements Creator<AuthorizeAccessRequest> {
    /* renamed from: a */
    static void m276a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, authorizeAccessRequest.xH);
        C0146b.m216a(parcel, 2, authorizeAccessRequest.EU);
        C0146b.m220a(parcel, 3, authorizeAccessRequest.Ew, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: D */
    public AuthorizeAccessRequest m277D(Parcel parcel) {
        int o = C0145a.m197o(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    driveId = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public AuthorizeAccessRequest[] ah(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m277D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ah(x0);
    }
}
