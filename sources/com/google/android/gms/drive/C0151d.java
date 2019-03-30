package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.d */
public class C0151d implements Creator<DriveId> {
    /* renamed from: a */
    static void m241a(DriveId driveId, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, driveId.xH);
        C0146b.m223a(parcel, 2, driveId.EH, false);
        C0146b.m216a(parcel, 3, driveId.EI);
        C0146b.m216a(parcel, 4, driveId.EJ);
        C0146b.m212F(parcel, p);
    }

    public DriveId[] ad(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m242z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ad(x0);
    }

    /* renamed from: z */
    public DriveId m242z(Parcel parcel) {
        long j = 0;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    str = C0145a.m196n(parcel, n);
                    break;
                case 3:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 4:
                    j = C0145a.m190i(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
