package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C0918b<T> extends C0565a<Collection<T>> {
    protected C0918b(String str, int i) {
        super(str, i);
    }

    /* renamed from: b */
    protected /* synthetic */ Object mo2701b(DataHolder dataHolder, int i, int i2) {
        return mo3242c(dataHolder, i, i2);
    }

    /* renamed from: c */
    protected Collection<T> mo3242c(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
