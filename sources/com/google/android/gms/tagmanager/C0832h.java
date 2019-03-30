package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.h */
class C0832h extends aj {
    private static final String ID = C0205a.APP_VERSION.toString();
    private final Context mContext;

    public C0832h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        try {
            return dh.m1472r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m1385w("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return dh.lT();
        }
    }
}
