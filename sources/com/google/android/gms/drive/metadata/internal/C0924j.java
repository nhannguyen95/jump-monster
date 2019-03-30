package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0565a;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public class C0924j extends C0565a<String> {
    public C0924j(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m2687a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return m2690h(dataHolder, i, i2);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m2691l(bundle);
    }

    /* renamed from: h */
    protected String m2690h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.getString(getName(), i, i2);
    }

    /* renamed from: l */
    protected String m2691l(Bundle bundle) {
        return bundle.getString(getName());
    }
}
