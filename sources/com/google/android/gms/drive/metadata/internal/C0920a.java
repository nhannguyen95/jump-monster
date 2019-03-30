package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0565a;

/* renamed from: com.google.android.gms.drive.metadata.internal.a */
public class C0920a extends C0565a<Boolean> {
    public C0920a(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m2664a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return mo3245d(dataHolder, i, i2);
    }

    /* renamed from: d */
    protected Boolean mo3245d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.getBoolean(getName(), i, i2));
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m2669f(bundle);
    }

    /* renamed from: f */
    protected Boolean m2669f(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
