package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bt implements MediationAdRequest {
    /* renamed from: d */
    private final Date f174d;
    /* renamed from: f */
    private final Set<String> f175f;
    /* renamed from: g */
    private final boolean f176g;
    private final int lZ;
    private final int nD;

    public bt(Date date, int i, Set<String> set, boolean z, int i2) {
        this.f174d = date;
        this.lZ = i;
        this.f175f = set;
        this.f176g = z;
        this.nD = i2;
    }

    public Date getBirthday() {
        return this.f174d;
    }

    public int getGender() {
        return this.lZ;
    }

    public Set<String> getKeywords() {
        return this.f175f;
    }

    public boolean isTesting() {
        return this.f176g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nD;
    }
}
