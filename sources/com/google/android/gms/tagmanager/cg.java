package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg extends aj {
    private static final String ID = C0205a.REGEX_GROUP.toString();
    private static final String YZ = C0209b.ARG0.toString();
    private static final String Za = C0209b.ARG1.toString();
    private static final String Zb = C0209b.IGNORE_CASE.toString();
    private static final String Zc = C0209b.GROUP.toString();

    public cg() {
        super(ID, YZ, Za);
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(YZ);
        C0969a c0969a2 = (C0969a) map.get(Za);
        if (c0969a == null || c0969a == dh.lT() || c0969a2 == null || c0969a2 == dh.lT()) {
            return dh.lT();
        }
        int intValue;
        int i = 64;
        if (dh.m1467n((C0969a) map.get(Zb)).booleanValue()) {
            i = 66;
        }
        C0969a c0969a3 = (C0969a) map.get(Zc);
        if (c0969a3 != null) {
            Long l = dh.m1463l(c0969a3);
            if (l == dh.lO()) {
                return dh.lT();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return dh.lT();
            }
        }
        intValue = 1;
        try {
            CharSequence j = dh.m1461j(c0969a);
            Object obj = null;
            Matcher matcher = Pattern.compile(dh.m1461j(c0969a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? dh.lT() : dh.m1472r(obj);
        } catch (PatternSyntaxException e) {
            return dh.lT();
        }
    }
}
