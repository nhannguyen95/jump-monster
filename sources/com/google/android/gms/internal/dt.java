package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

public final class dt {
    /* renamed from: a */
    public static void m808a(Context context, WebSettings webSettings) {
        ds.m802a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
