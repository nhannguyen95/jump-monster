package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID = C0205a.LANGUAGE.toString();

    public bc() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return dh.lT();
        }
        String language = locale.getLanguage();
        return language == null ? dh.lT() : dh.m1472r(language.toLowerCase());
    }
}
