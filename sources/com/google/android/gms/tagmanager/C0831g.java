package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.g */
class C0831g extends aj {
    private static final String ID = C0205a.APP_NAME.toString();
    private final Context mContext;

    public C0831g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return dh.m1472r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m1382b("App name is not found.", e);
            return dh.lT();
        }
    }
}
