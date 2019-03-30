package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m129a(Status status, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, status.getStatusCode());
        C0146b.m235c(parcel, 1000, status.getVersionCode());
        C0146b.m223a(parcel, 2, status.ep(), false);
        C0146b.m220a(parcel, 3, status.eo(), i, false);
        C0146b.m212F(parcel, p);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int o = C0145a.m197o(parcel);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) C0145a.m177a(parcel, n, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
