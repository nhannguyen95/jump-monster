package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;

public interface MetadataField<T> {
    /* renamed from: a */
    T mo1156a(DataHolder dataHolder, int i, int i2);

    /* renamed from: a */
    void mo1157a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2);

    /* renamed from: a */
    void mo1158a(T t, Bundle bundle);

    /* renamed from: d */
    T mo1159d(Bundle bundle);

    Collection<String> fR();

    String getName();
}
