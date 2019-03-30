package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class aa extends aj {
    private static final String ID = C0205a.DEVICE_NAME.toString();

    public aa() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals("unknown"))) {
            obj = str + " " + obj;
        }
        return dh.m1472r(obj);
    }
}
