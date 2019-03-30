package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

public class StreetViewPanoramaLink implements SafeParcelable {
    public static final StreetViewPanoramaLinkCreator CREATOR = new StreetViewPanoramaLinkCreator();
    public final float bearing;
    public final String panoId;
    private final int xH;

    StreetViewPanoramaLink(int versionCode, String panoId, float bearing) {
        this.xH = versionCode;
        this.panoId = panoId;
        if (((double) bearing) <= 0.0d) {
            bearing = (bearing % 360.0f) + 360.0f;
        }
        this.bearing = bearing % 360.0f;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) o;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return fo.m977e(this).m976a("panoId", this.panoId).m976a("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        StreetViewPanoramaLinkCreator.m1264a(this, out, flags);
    }
}
