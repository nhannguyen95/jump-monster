package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0565a;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public class C0922e extends C0565a<Long> {
    public C0922e(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m2676a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return m2680g(dataHolder, i, i2);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m2681i(bundle);
    }

    /* renamed from: g */
    protected Long m2680g(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.getLong(getName(), i, i2));
    }

    /* renamed from: i */
    protected Long m2681i(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
