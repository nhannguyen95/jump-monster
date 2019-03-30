package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID = C0205a.JOINER.toString();
    private static final String XQ = C0209b.ARG0.toString();
    private static final String Ym = C0209b.ITEM_SEPARATOR.toString();
    private static final String Yn = C0209b.KEY_VALUE_SEPARATOR.toString();
    private static final String Yo = C0209b.ESCAPE.toString();

    /* renamed from: com.google.android.gms.tagmanager.az$a */
    private enum C0381a {
        NONE,
        URL,
        BACKSLASH
    }

    public az() {
        super(ID, XQ);
    }

    /* renamed from: a */
    private String m2456a(String str, C0381a c0381a, Set<Character> set) {
        switch (c0381a) {
            case URL:
                try {
                    return dk.cd(str);
                } catch (Throwable e) {
                    bh.m1382b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    /* renamed from: a */
    private void m2457a(StringBuilder stringBuilder, String str, C0381a c0381a, Set<Character> set) {
        stringBuilder.append(m2456a(str, c0381a, set));
    }

    /* renamed from: a */
    private void m2458a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(XQ);
        if (c0969a == null) {
            return dh.lT();
        }
        C0381a c0381a;
        Set set;
        C0969a c0969a2 = (C0969a) map.get(Ym);
        String j = c0969a2 != null ? dh.m1461j(c0969a2) : "";
        c0969a2 = (C0969a) map.get(Yn);
        String j2 = c0969a2 != null ? dh.m1461j(c0969a2) : "=";
        C0381a c0381a2 = C0381a.NONE;
        c0969a2 = (C0969a) map.get(Yo);
        if (c0969a2 != null) {
            String j3 = dh.m1461j(c0969a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0381a = C0381a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0381a = C0381a.BACKSLASH;
                set = new HashSet();
                m2458a(set, j);
                m2458a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m1385w("Joiner: unsupported escape type: " + j3);
                return dh.lT();
            }
        }
        set = null;
        c0381a = c0381a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c0969a.type) {
            case 2:
                Object obj = 1;
                C0969a[] c0969aArr = c0969a.fO;
                int length = c0969aArr.length;
                int i = 0;
                while (i < length) {
                    C0969a c0969a3 = c0969aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m2457a(stringBuilder, dh.m1461j(c0969a3), c0381a, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < c0969a.fP.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = dh.m1461j(c0969a.fP[i2]);
                    String j5 = dh.m1461j(c0969a.fQ[i2]);
                    m2457a(stringBuilder, j4, c0381a, set);
                    stringBuilder.append(j2);
                    m2457a(stringBuilder, j5, c0381a, set);
                }
                break;
            default:
                m2457a(stringBuilder, dh.m1461j(c0969a), c0381a, set);
                break;
        }
        return dh.m1472r(stringBuilder.toString());
    }
}
