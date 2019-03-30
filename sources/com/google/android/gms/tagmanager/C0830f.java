package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.f */
class C0830f extends aj {
    private static final String ID = C0205a.APP_ID.toString();
    private final Context mContext;

    public C0830f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        return dh.m1472r(this.mContext.getPackageName());
    }
}
