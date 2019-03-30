package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0565a;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public abstract class C0923h<T extends Parcelable> extends C0565a<T> {
    public C0923h(String str, int i) {
        super(str, i);
    }

    public C0923h(String str, Collection<String> collection, int i) {
        super(str, collection, i);
    }

    /* renamed from: a */
    protected void m2682a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo2703e(Bundle bundle) {
        return m2685k(bundle);
    }

    /* renamed from: k */
    protected T m2685k(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
