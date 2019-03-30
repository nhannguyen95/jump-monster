package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new C0203a();
    String qd;
    private final int xH;

    CountrySpecification(int versionCode, String countryCode) {
        this.xH = versionCode;
        this.qd = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.xH = 1;
        this.qd = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.qd;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0203a.m588a(this, dest, flags);
    }
}
