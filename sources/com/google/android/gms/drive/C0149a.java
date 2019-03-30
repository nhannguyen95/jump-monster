package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

/* renamed from: com.google.android.gms.drive.a */
public class C0149a implements Creator<Contents> {
    /* renamed from: a */
    static void m239a(Contents contents, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, contents.xH);
        C0146b.m220a(parcel, 2, contents.Cj, i, false);
        C0146b.m235c(parcel, 3, contents.Eu);
        C0146b.m235c(parcel, 4, contents.Ev);
        C0146b.m220a(parcel, 5, contents.Ew, i, false);
        C0146b.m212F(parcel, p);
    }

    public Contents[] ac(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m240y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ac(x0);
    }

    /* renamed from: y */
    public Contents m240y(Parcel parcel) {
        DriveId driveId = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0145a.m177a(parcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 5:
                    driveId = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }
}
