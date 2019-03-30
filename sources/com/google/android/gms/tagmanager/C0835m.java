package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.m */
class C0835m extends aj {
    private static final String ID = C0205a.CONSTANT.toString();
    private static final String VALUE = C0209b.VALUE.toString();

    public C0835m() {
        super(ID, VALUE);
    }

    public static String ka() {
        return ID;
    }

    public static String kb() {
        return VALUE;
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        return (C0969a) map.get(VALUE);
    }
}
