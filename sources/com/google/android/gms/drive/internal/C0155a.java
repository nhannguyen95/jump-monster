package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.a */
public class C0155a implements Creator<AddEventListenerRequest> {
    /* renamed from: a */
    static void m249a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, addEventListenerRequest.xH);
        C0146b.m220a(parcel, 2, addEventListenerRequest.Ew, i, false);
        C0146b.m235c(parcel, 3, addEventListenerRequest.ES);
        C0146b.m220a(parcel, 4, addEventListenerRequest.ET, i, false);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: C */
    public AddEventListenerRequest m250C(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int i3;
            DriveId driveId2;
            int g;
            PendingIntent pendingIntent2;
            int n = C0145a.m195n(parcel);
            PendingIntent pendingIntent3;
            switch (C0145a.m175R(n)) {
                case 1:
                    pendingIntent3 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = C0145a.m188g(parcel, n);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    g = i2;
                    int i4 = i;
                    driveId2 = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    pendingIntent2 = pendingIntent;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i2;
                    pendingIntent3 = pendingIntent;
                    i3 = C0145a.m188g(parcel, n);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 4:
                    pendingIntent2 = (PendingIntent) C0145a.m177a(parcel, n, PendingIntent.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = i3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == o) {
            return new AddEventListenerRequest(i2, driveId, i, pendingIntent);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public AddEventListenerRequest[] ag(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m250C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ag(x0);
    }
}
