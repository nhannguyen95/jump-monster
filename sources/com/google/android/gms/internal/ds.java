package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

public final class ds {
    /* renamed from: a */
    public static void m802a(Context context, WebSettings webSettings) {
        webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        webSettings.setAppCacheMaxSize(0);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
    }

    /* renamed from: a */
    public static void m803a(Window window) {
        window.setFlags(16777216, 16777216);
    }

    /* renamed from: a */
    public static void m804a(WebView webView) {
        webView.onPause();
    }

    /* renamed from: b */
    public static void m805b(WebView webView) {
        webView.onResume();
    }

    /* renamed from: d */
    public static void m806d(View view) {
        view.setLayerType(1, null);
    }

    /* renamed from: e */
    public static void m807e(View view) {
        view.setLayerType(0, null);
    }
}
