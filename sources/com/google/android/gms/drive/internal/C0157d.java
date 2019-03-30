package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.d */
public class C0157d implements Creator<CloseContentsAndUpdateMetadataRequest> {
    /* renamed from: a */
    static void m278a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, closeContentsAndUpdateMetadataRequest.xH);
        C0146b.m220a(parcel, 2, closeContentsAndUpdateMetadataRequest.EV, i, false);
        C0146b.m220a(parcel, 3, closeContentsAndUpdateMetadataRequest.EW, i, false);
        C0146b.m220a(parcel, 4, closeContentsAndUpdateMetadataRequest.EX, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: E */
    public CloseContentsAndUpdateMetadataRequest m279E(Parcel parcel) {
        Contents contents = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            MetadataBundle metadataBundle2;
            DriveId driveId2;
            int g;
            Contents contents2;
            int n = C0145a.m195n(parcel);
            Contents contents3;
            switch (C0145a.m175R(n)) {
                case 1:
                    contents3 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = C0145a.m188g(parcel, n);
                    contents2 = contents3;
                    break;
                case 2:
                    g = i;
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle3;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i;
                    contents3 = contents;
                    metadataBundle2 = (MetadataBundle) C0145a.m177a(parcel, n, MetadataBundle.CREATOR);
                    contents2 = contents3;
                    break;
                case 4:
                    contents2 = (Contents) C0145a.m177a(parcel, n, Contents.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    contents2 = contents;
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
            contents = contents2;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] ai(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m279E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ai(x0);
    }
}
