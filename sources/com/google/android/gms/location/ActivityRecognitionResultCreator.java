package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1219a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int p = C0146b.m237p(parcel);
        C0146b.m234b(parcel, 1, activityRecognitionResult.NP, false);
        C0146b.m235c(parcel, 1000, activityRecognitionResult.getVersionCode());
        C0146b.m216a(parcel, 2, activityRecognitionResult.NQ);
        C0146b.m216a(parcel, 3, activityRecognitionResult.NR);
        C0146b.m212F(parcel, p);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0145a.m197o(parcel);
        int i = 0;
        List list = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            switch (C0145a.m175R(n)) {
                case 1:
                    list = C0145a.m183c(parcel, n, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0145a.m190i(parcel, n);
                    break;
                case 3:
                    j = C0145a.m190i(parcel, n);
                    break;
                case 1000:
                    i = C0145a.m188g(parcel, n);
                    break;
                default:
                    C0145a.m181b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ActivityRecognitionResult(i, list, j2, j);
        }
        throw new C0144a("Overread allowed size end=" + o, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
