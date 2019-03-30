package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class dv {
    public static final Handler rp = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static int m809a(Context context, int i) {
        return m810a(context.getResources().getDisplayMetrics(), i);
    }

    /* renamed from: a */
    public static int m810a(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, displayMetrics);
    }

    /* renamed from: a */
    public static void m811a(ViewGroup viewGroup, ak akVar, String str) {
        m812a(viewGroup, akVar, str, -16777216, -1);
    }

    /* renamed from: a */
    private static void m812a(ViewGroup viewGroup, ak akVar, String str, int i, int i2) {
        if (viewGroup.getChildCount() == 0) {
            Context context = viewGroup.getContext();
            View textView = new TextView(context);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(i2);
            View frameLayout = new FrameLayout(context);
            frameLayout.setBackgroundColor(i);
            int a = m809a(context, 3);
            frameLayout.addView(textView, new LayoutParams(akVar.widthPixels - a, akVar.heightPixels - a, 17));
            viewGroup.addView(frameLayout, akVar.widthPixels, akVar.heightPixels);
        }
    }

    /* renamed from: a */
    public static void m813a(ViewGroup viewGroup, ak akVar, String str, String str2) {
        dw.m824z(str2);
        m812a(viewGroup, akVar, str, -65536, -16777216);
    }

    public static boolean bC() {
        return Build.DEVICE.startsWith("generic");
    }

    public static boolean bD() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: l */
    public static String m814l(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || bC()) {
            string = "emulator";
        }
        return m815u(string);
    }

    /* renamed from: u */
    public static String m815u(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest.getInstance("MD5").update(str.getBytes());
                return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, r1.digest())});
            } catch (NoSuchAlgorithmException e) {
                i++;
            }
        }
        return null;
    }
}
