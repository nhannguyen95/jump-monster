package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.z */
class C0849z extends aj {
    private static final String ID = C0205a.DEVICE_ID.toString();
    private final Context mContext;

    public C0849z(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    /* renamed from: G */
    protected String m2563G(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        String G = m2563G(this.mContext);
        return G == null ? dh.lT() : dh.m1472r(G);
    }
}
