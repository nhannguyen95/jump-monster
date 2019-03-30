package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C0551d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kc;

/* renamed from: com.google.android.gms.wearable.b */
public class C1025b extends C0551d<C0856a> implements Result {
    private final Status wJ;

    public C1025b(DataHolder dataHolder) {
        super(dataHolder);
        this.wJ = new Status(dataHolder.getStatusCode());
    }

    /* renamed from: c */
    protected /* synthetic */ Object mo2762c(int i, int i2) {
        return m3241g(i, i2);
    }

    /* renamed from: g */
    protected C0856a m3241g(int i, int i2) {
        return new kc(this.BB, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "path";
    }

    public Status getStatus() {
        return this.wJ;
    }
}
