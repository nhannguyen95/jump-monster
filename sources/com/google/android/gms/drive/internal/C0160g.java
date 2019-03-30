package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0160g implements Creator<CreateFileIntentSenderRequest> {
    /* renamed from: a */
    static void m284a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, createFileIntentSenderRequest.xH);
        C0146b.m220a(parcel, 2, createFileIntentSenderRequest.EZ, i, false);
        C0146b.m235c(parcel, 3, createFileIntentSenderRequest.Eu);
        C0146b.m223a(parcel, 4, createFileIntentSenderRequest.EB, false);
        C0146b.m220a(parcel, 5, createFileIntentSenderRequest.EC, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: H */
    public CreateFileIntentSenderRequest m285H(Parcel parcel) {
        int i = 0;
        DriveId driveId = null;
        int o = C0145a.m197o(parcel);
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 4:
                    str = C0145a.m196n(parcel, n);
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
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CreateFileIntentSenderRequest[] al(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m285H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return al(x0);
    }
}
