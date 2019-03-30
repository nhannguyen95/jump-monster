package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;

public class ai implements Creator<OpenFileIntentSenderRequest> {
    /* renamed from: a */
    static void m267a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, openFileIntentSenderRequest.xH);
        C0146b.m223a(parcel, 2, openFileIntentSenderRequest.EB, false);
        C0146b.m230a(parcel, 3, openFileIntentSenderRequest.EQ, false);
        C0146b.m220a(parcel, 4, openFileIntentSenderRequest.EC, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: W */
    public OpenFileIntentSenderRequest m268W(Parcel parcel) {
        DriveId driveId = null;
        int o = C0145a.m197o(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0145a.m209z(parcel, n);
                    break;
                case 4:
                    driveId = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public OpenFileIntentSenderRequest[] aA(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m268W(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
