package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new C0161h();
    final Contents EX;
    final MetadataBundle EZ;
    final DriveId Fa;
    final int xH;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this.xH = versionCode;
        this.Fa = (DriveId) fq.m986f(parentDriveId);
        this.EZ = (MetadataBundle) fq.m986f(metadata);
        this.EX = (Contents) fq.m986f(contentsReference);
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this(1, parentDriveId, metadata, contentsReference);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0161h.m286a(this, dest, flags);
    }
}
