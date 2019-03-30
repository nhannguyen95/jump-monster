package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.i */
public class C0162i implements Creator<CreateFolderRequest> {
    /* renamed from: a */
    static void m288a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, createFolderRequest.xH);
        C0146b.m220a(parcel, 2, createFolderRequest.Fa, i, false);
        C0146b.m220a(parcel, 3, createFolderRequest.EZ, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: J */
    public CreateFolderRequest m289J(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0145a.m188g(parcel, n);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CreateFolderRequest[] an(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m289J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return an(x0);
    }
}
