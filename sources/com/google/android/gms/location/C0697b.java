package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

/* renamed from: com.google.android.gms.location.b */
public class C0697b implements SafeParcelable {
    public static final C0313c CREATOR = new C0313c();
    int Oh;
    int Oi;
    long Oj;
    private final int xH;

    C0697b(int i, int i2, int i3, long j) {
        this.xH = i;
        this.Oh = i2;
        this.Oi = i3;
        this.Oj = j;
    }

    private String by(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C0697b)) {
            return false;
        }
        C0697b c0697b = (C0697b) other;
        return this.Oh == c0697b.Oh && this.Oi == c0697b.Oi && this.Oj == c0697b.Oj;
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.Oh), Integer.valueOf(this.Oi), Long.valueOf(this.Oj));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LocationStatus[cell status: ").append(by(this.Oh));
        stringBuilder.append(", wifi status: ").append(by(this.Oi));
        stringBuilder.append(", elapsed realtime ns: ").append(this.Oj);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0313c.m1222a(this, parcel, flags);
    }
}
