package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.fq;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.metadata.a */
public abstract class C0565a<T> implements MetadataField<T> {
    private final String FM;
    private final Set<String> FN;
    private final int FO;

    protected C0565a(String str, int i) {
        this.FM = (String) fq.m983b((Object) str, (Object) "fieldName");
        this.FN = Collections.singleton(str);
        this.FO = i;
    }

    protected C0565a(String str, Collection<String> collection, int i) {
        this.FM = (String) fq.m983b((Object) str, (Object) "fieldName");
        this.FN = Collections.unmodifiableSet(new HashSet(collection));
        this.FO = i;
    }

    /* renamed from: a */
    public final T mo1156a(DataHolder dataHolder, int i, int i2) {
        for (String hasNull : this.FN) {
            if (dataHolder.hasNull(hasNull, i, i2)) {
                return null;
            }
        }
        return mo2701b(dataHolder, i, i2);
    }

    /* renamed from: a */
    protected abstract void mo2702a(Bundle bundle, T t);

    /* renamed from: a */
    public final void mo1157a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        fq.m983b((Object) dataHolder, (Object) "dataHolder");
        fq.m983b((Object) metadataBundle, (Object) "bundle");
        metadataBundle.m1739b(this, mo1156a(dataHolder, i, i2));
    }

    /* renamed from: a */
    public final void mo1158a(T t, Bundle bundle) {
        fq.m983b((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            mo2702a(bundle, (Object) t);
        }
    }

    /* renamed from: b */
    protected abstract T mo2701b(DataHolder dataHolder, int i, int i2);

    /* renamed from: d */
    public final T mo1159d(Bundle bundle) {
        fq.m983b((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? mo2703e(bundle) : null;
    }

    /* renamed from: e */
    protected abstract T mo2703e(Bundle bundle);

    public final Collection<String> fR() {
        return this.FN;
    }

    public final String getName() {
        return this.FM;
    }

    public String toString() {
        return this.FM;
    }
}
