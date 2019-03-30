package com.google.android.gms.internal;

import java.util.Map;

public final class ay implements bb {
    private final az mF;

    public ay(az azVar) {
        this.mF = azVar;
    }

    /* renamed from: b */
    public void mo1589b(dz dzVar, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            dw.m824z("App event with no name parameter.");
        } else {
            this.mF.onAppEvent(str, (String) map.get("info"));
        }
    }
}
