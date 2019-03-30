package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class df {
    private int mOrientation = -1;
    private String pN;
    private String pO;
    private String pP;
    private List<String> pQ;
    private String pR;
    private String pS;
    private List<String> pT;
    private long pU = -1;
    private boolean pV = false;
    private final long pW = -1;
    private List<String> pX;
    private long pY = -1;

    /* renamed from: a */
    private static String m738a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    /* renamed from: b */
    private static long m739b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                dw.m824z("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    /* renamed from: c */
    private static List<String> m740c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    /* renamed from: f */
    private void m741f(Map<String, List<String>> map) {
        this.pN = m738a(map, "X-Afma-Ad-Size");
    }

    /* renamed from: g */
    private void m742g(Map<String, List<String>> map) {
        List c = m740c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.pQ = c;
        }
    }

    /* renamed from: h */
    private void m743h(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.pR = (String) list.get(0);
        }
    }

    /* renamed from: i */
    private void m744i(Map<String, List<String>> map) {
        List c = m740c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.pT = c;
        }
    }

    /* renamed from: j */
    private void m745j(Map<String, List<String>> map) {
        long b = m739b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.pU = b;
        }
    }

    /* renamed from: k */
    private void m746k(Map<String, List<String>> map) {
        this.pS = m738a(map, "X-Afma-ActiveView");
    }

    /* renamed from: l */
    private void m747l(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.pV = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: m */
    private void m748m(Map<String, List<String>> map) {
        List c = m740c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.pX = c;
        }
    }

    /* renamed from: n */
    private void m749n(Map<String, List<String>> map) {
        long b = m739b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.pY = b;
        }
    }

    /* renamed from: o */
    private void m750o(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = dq.bA();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = dq.bz();
            }
        }
    }

    /* renamed from: a */
    public void m751a(String str, Map<String, List<String>> map, String str2) {
        this.pO = str;
        this.pP = str2;
        m752e(map);
    }

    /* renamed from: e */
    public void m752e(Map<String, List<String>> map) {
        m741f(map);
        m742g((Map) map);
        m743h(map);
        m744i(map);
        m745j(map);
        m747l(map);
        m748m(map);
        m749n(map);
        m750o(map);
        m746k(map);
    }

    /* renamed from: g */
    public cz m753g(long j) {
        return new cz(this.pO, this.pP, this.pQ, this.pT, this.pU, this.pV, -1, this.pX, this.pY, this.mOrientation, this.pN, j, this.pR, this.pS);
    }
}
