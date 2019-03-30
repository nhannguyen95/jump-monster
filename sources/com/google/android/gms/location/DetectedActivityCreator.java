package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1220a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m235c(parcel, 1, detectedActivity.NS);
        C0146b.m235c(parcel, 1000, detectedActivity.getVersionCode());
        C0146b.m235c(parcel, 2, detectedActivity.NT);
        C0146b.m212F(parcel, p);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0145a.m197o(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    i2 = C0145a.m188g(parcel, n);
                    break;
                case 2:
                    i = C0145a.m188g(parcel, n);
                    break;
                case 1000:
                    i3 = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
