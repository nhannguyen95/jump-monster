package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

class ae implements C0098m {
    private static Object sf = new Object();
    private static ae vH;
    private final Context mContext;

    protected ae(Context context) {
        this.mContext = context;
    }

    public static ae cZ() {
        ae aeVar;
        synchronized (sf) {
            aeVar = vH;
        }
        return aeVar;
    }

    /* renamed from: n */
    public static void m1557n(Context context) {
        synchronized (sf) {
            if (vH == null) {
                vH = new ae(context);
            }
        }
    }

    /* renamed from: C */
    public boolean m1558C(String str) {
        return "&sr".equals(str);
    }

    protected String da() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        return (field != null && field.equals("&sr")) ? da() : null;
    }
}
