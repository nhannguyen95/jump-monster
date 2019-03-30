package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends dc {
    private static final String ID = C0205a.REGEX.toString();
    private static final String Zb = C0209b.IGNORE_CASE.toString();

    public ch() {
        super(ID);
    }

    /* renamed from: a */
    protected boolean mo3246a(String str, String str2, Map<String, C0969a> map) {
        try {
            return Pattern.compile(str2, dh.m1467n((C0969a) map.get(Zb)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
