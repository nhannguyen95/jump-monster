package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    /* renamed from: d */
    private final Date f95d;
    /* renamed from: e */
    private final Gender f96e;
    /* renamed from: f */
    private final Set<String> f97f;
    /* renamed from: g */
    private final boolean f98g;
    /* renamed from: h */
    private final Location f99h;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.f95d = birthday;
        this.f96e = gender;
        this.f97f = keywords;
        this.f98g = isTesting;
        this.f99h = location;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f95d;
    }

    public Gender getGender() {
        return this.f96e;
    }

    public Set<String> getKeywords() {
        return this.f97f;
    }

    public Location getLocation() {
        return this.f99h;
    }

    public boolean isTesting() {
        return this.f98g;
    }
}
