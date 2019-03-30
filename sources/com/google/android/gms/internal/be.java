package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

public final class be implements bb {
    /* renamed from: a */
    private static int m2032a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = dv.m810a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                dw.m824z("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    /* renamed from: b */
    public void mo1589b(dz dzVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            dw.m824z("Action missing from video GMSG.");
            return;
        }
        cc bH = dzVar.bH();
        if (bH == null) {
            dw.m824z("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = dzVar.getContext().getResources().getDisplayMetrics();
            a = m2032a(displayMetrics, map, "x", 0);
            int a2 = m2032a(displayMetrics, map, "y", 0);
            int a3 = m2032a(displayMetrics, map, "w", -1);
            int a4 = m2032a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && bH.aK() == null) {
                bH.m2973c(a, a2, a3, a4);
                return;
            } else {
                bH.m2972b(a, a2, a3, a4);
                return;
            }
        }
        cg aK = bH.aK();
        if (aK == null) {
            cg.m690a(dzVar, "no_video_view", null);
        } else if ("click".equalsIgnoreCase(str)) {
            displayMetrics = dzVar.getContext().getResources().getDisplayMetrics();
            int a5 = m2032a(displayMetrics, map, "x", 0);
            a = m2032a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            aK.m693b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                dw.m824z("Enabled parameter missing from controls video GMSG.");
            } else {
                aK.m694k(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get("time");
            if (str == null) {
                dw.m824z("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                aK.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                dw.m824z("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            aK.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            aK.aU();
        } else if ("pause".equalsIgnoreCase(str)) {
            aK.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            aK.play();
        } else if ("show".equalsIgnoreCase(str)) {
            aK.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            aK.m695o((String) map.get("src"));
        } else {
            dw.m824z("Unknown video action: " + str);
        }
    }
}
