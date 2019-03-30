package com.google.android.gms.internal;

import android.text.TextUtils;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ew {
    private static final String[] Ac = new String[]{"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String Ad = ("yyyyMMdd'T'HHmmss" + Ac[0]);
    private static final er zb = new er("MetadataUtils");

    /* renamed from: a */
    public static String m910a(Calendar calendar) {
        if (calendar == null) {
            zb.m899b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = Ad;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        str = simpleDateFormat.format(calendar.getTime());
        return str.endsWith("+0000") ? str.replace("+0000", Ac[0]) : str;
    }

    /* renamed from: a */
    public static void m911a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: a */
    public static void m912a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage dB : list) {
                jSONArray.put(dB.dB());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    public static Calendar ac(String str) {
        if (TextUtils.isEmpty(str)) {
            zb.m899b("Input string is empty or null", new Object[0]);
            return null;
        }
        String ad = ad(str);
        if (TextUtils.isEmpty(ad)) {
            zb.m899b("Invalid date format", new Object[0]);
            return null;
        }
        String ae = ae(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(ae)) {
            ad = ad + "T" + ae;
            str2 = ae.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : Ad;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(ad));
            return instance;
        } catch (ParseException e) {
            zb.m899b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String ad(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            zb.m899b("Input string is empty or null", new Object[0]);
        } else {
            try {
                str2 = str.substring(0, "yyyyMMdd".length());
            } catch (IndexOutOfBoundsException e) {
                zb.m900c("Error extracting the date: %s", e.getMessage());
            }
        }
        return str2;
    }

    private static String ae(String str) {
        if (TextUtils.isEmpty(str)) {
            zb.m899b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            zb.m899b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case Keys.f19O /*43*/:
                case Keys.f21Q /*45*/:
                    return af(substring) ? substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2") : null;
                case 'Z':
                    return substring.length() == "HHmmss".length() + Ac[0].length() ? substring.substring(0, substring.length() - 1) + "+0000" : null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zb.m899b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean af(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == Ac[1].length() + length2 || length == Ac[2].length() + length2 || length == length2 + Ac[3].length();
    }
}
