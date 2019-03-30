package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.a */
public class C0152a implements Creator<ChangeEvent> {
    /* renamed from: a */
    static void m244a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, changeEvent.xH);
        C0146b.m220a(parcel, 2, changeEvent.Ew, i, false);
        C0146b.m235c(parcel, 3, changeEvent.ER);
        C0146b.m212F(parcel, p);
    }

    /* renamed from: A */
    public ChangeEvent m245A(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            DriveId driveId2;
            int g;
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0145a.m188g(parcel, n);
                    n = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0145a.m177a(parcel, n, DriveId.CREATOR);
                    n = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    n = C0145a.m188g(parcel, n);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    n = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = n;
        }
        if (parcel.dataPosition() == o) {
            return new ChangeEvent(i2, driveId, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ChangeEvent[] ae(int i) {
        return new ChangeEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m245A(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ae(x0);
    }
}
