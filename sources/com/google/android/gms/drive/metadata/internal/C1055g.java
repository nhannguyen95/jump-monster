package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0918b;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.g */
public class C1055g<T extends Parcelable> extends C0918b<T> {
    public C1055g(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    protected void m3269a(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), new ArrayList(collection));
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m3271j(bundle);
    }

    /* renamed from: j */
    protected Collection<T> m3271j(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
