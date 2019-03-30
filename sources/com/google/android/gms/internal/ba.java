package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class ba {
    public static final bb mG = new C05911();
    public static final bb mH = new C05922();
    public static final bb mI = new C05933();
    public static final bb mJ = new C05944();
    public static final bb mK = new C05955();
    public static final bb mL = new C05966();
    public static final bb mM = new C05977();
    public static final bb mN = new C05988();
    public static final bb mO = new be();

    /* renamed from: com.google.android.gms.internal.ba$1 */
    static class C05911 implements bb {
        C05911() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$2 */
    static class C05922 implements bb {
        C05922() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                dw.m824z("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = dzVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            dzVar.m833a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$3 */
    static class C05933 implements bb {
        C05933() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                dw.m824z("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0294l bJ = dzVar.bJ();
                if (bJ != null && bJ.m1183a(parse)) {
                    a = bJ.m1181a(parse, dzVar.getContext());
                    new du(dzVar.getContext(), dzVar.bK().rq, a.toString()).start();
                }
            } catch (C0295m e) {
                dw.m824z("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new du(dzVar.getContext(), dzVar.bK().rq, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$4 */
    static class C05944 implements bb {
        C05944() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            cc bH = dzVar.bH();
            if (bH == null) {
                dw.m824z("A GMSG tried to close something that wasn't an overlay.");
            } else {
                bH.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$5 */
    static class C05955 implements bb {
        C05955() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            cc bH = dzVar.bH();
            if (bH == null) {
                dw.m824z("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                bH.m2975i("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$6 */
    static class C05966 implements bb {
        C05966() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                dw.m824z("URL missing from httpTrack GMSG.");
            } else {
                new du(dzVar.getContext(), dzVar.bK().rq, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$7 */
    static class C05977 implements bb {
        C05977() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            dw.m822x("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.ba$8 */
    static class C05988 implements bb {
        C05988() {
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0294l bJ = dzVar.bJ();
                if (bJ != null) {
                    bJ.m1184y().mo1819a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                dw.m824z("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
