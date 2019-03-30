package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0565a;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0921d extends C0565a<Integer> {
    public C0921d(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m2670a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return m2674f(dataHolder, i, i2);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m2675h(bundle);
    }

    /* renamed from: f */
    protected Integer m2674f(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }

    /* renamed from: h */
    protected Integer m2675h(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
