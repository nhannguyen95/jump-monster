package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.badlogic.gdx.net.HttpRequestHeader;
import com.google.android.gms.ads.AdActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dq {
    private static final Object px = new Object();
    private static boolean re = true;
    private static String rf;
    private static boolean rg = false;

    /* renamed from: com.google.android.gms.internal.dq$a */
    private static final class C0247a extends BroadcastReceiver {
        private C0247a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                dq.re = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                dq.re = false;
            }
        }
    }

    /* renamed from: a */
    public static String m775a(Readable readable) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return stringBuilder.toString();
            }
            allocate.flip();
            stringBuilder.append(allocate, 0, read);
        }
    }

    /* renamed from: a */
    private static JSONArray m776a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m783a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONArray m777a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m783a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONObject m778a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m784a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m779a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m787b(context, str));
    }

    /* renamed from: a */
    public static void m780a(Context context, String str, List<String> list) {
        for (String duVar : list) {
            new du(context, str, duVar).start();
        }
    }

    /* renamed from: a */
    public static void m781a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty(HttpRequestHeader.UserAgent, m787b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static void m782a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            ds.m804a(webView);
        }
    }

    /* renamed from: a */
    private static void m783a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m778a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m795p((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m776a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m777a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private static void m784a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m778a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m795p((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m776a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m776a(Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    public static boolean m785a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    /* renamed from: a */
    public static boolean m786a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            z = cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
        }
        return z;
    }

    /* renamed from: b */
    private static String m787b(final Context context, String str) {
        String str2;
        synchronized (px) {
            if (rf != null) {
                str2 = rf;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    rf = dt.getDefaultUserAgent(context);
                } else if (dv.bD()) {
                    rf = m792j(context);
                } else {
                    dv.rp.post(new Runnable() {
                        public void run() {
                            synchronized (dq.px) {
                                dq.rf = dq.m792j(context);
                                dq.px.notifyAll();
                            }
                        }
                    });
                    while (rf == null) {
                        try {
                            px.wait();
                        } catch (InterruptedException e) {
                            str2 = rf;
                        }
                    }
                }
                rf += " (Mobile; " + str + ")";
                str2 = rf;
            }
        }
        return str2;
    }

    /* renamed from: b */
    public static Map<String, String> m788b(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.parseUrl(uri.toString());
        for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
            hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
        }
        return hashMap;
    }

    /* renamed from: b */
    public static void m789b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            ds.m805b(webView);
        }
    }

    public static int bA() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    public static boolean by() {
        return re;
    }

    public static int bz() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    /* renamed from: h */
    public static boolean m790h(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            dw.m824z("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        boolean z;
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            dw.m824z(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            dw.m824z(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            dw.m824z(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            dw.m824z(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            dw.m824z(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            dw.m824z(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        dw.m824z(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    /* renamed from: i */
    public static void m791i(Context context) {
        if (!rg) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0247a(), intentFilter);
            rg = true;
        }
    }

    /* renamed from: j */
    private static String m792j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    /* renamed from: p */
    public static JSONObject m795p(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m784a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    /* renamed from: r */
    public static String m796r(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }
}
