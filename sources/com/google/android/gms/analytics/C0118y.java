package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.y */
class C0118y {
    /* renamed from: a */
    static String m73a(C0117x c0117x, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0117x.cO());
        if (c0117x.cQ() > 0) {
            long cQ = j - c0117x.cQ();
            if (cQ >= 0) {
                stringBuilder.append("&qt").append("=").append(cQ);
            }
        }
        stringBuilder.append("&z").append("=").append(c0117x.cP());
        return stringBuilder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    /* renamed from: v */
    static Map<String, String> m74v(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
