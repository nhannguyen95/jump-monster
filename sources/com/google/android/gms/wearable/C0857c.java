package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.wearable.c */
public interface C0857c extends Freezable<C0857c> {
    byte[] getData();

    Uri getUri();

    Map<String, C0858d> ma();

    @Deprecated
    Set<String> mb();
}
