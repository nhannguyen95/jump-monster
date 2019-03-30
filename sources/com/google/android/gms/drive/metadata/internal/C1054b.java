package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0919c;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C1054b extends C0919c<Date> {
    public C1054b(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m3263a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return m3266e(dataHolder, i, i2);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m3267g(bundle);
    }

    /* renamed from: e */
    protected Date m3266e(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.getLong(getName(), i, i2));
    }

    /* renamed from: g */
    protected Date m3267g(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
