package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

class bz extends aj {
    private static final String ID = C0205a.OS_VERSION.toString();

    public bz() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        return dh.m1472r(VERSION.RELEASE);
    }
}
