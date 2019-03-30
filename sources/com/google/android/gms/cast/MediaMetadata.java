package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.ew;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] yp = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
    private static final C0119a yq = new C0119a().m91a(KEY_CREATION_DATE, "creationDateTime", 4).m91a(KEY_RELEASE_DATE, "releaseDate", 4).m91a(KEY_BROADCAST_DATE, "originalAirdate", 4).m91a(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 1).m91a(KEY_SUBTITLE, "subtitle", 1).m91a(KEY_ARTIST, "artist", 1).m91a(KEY_ALBUM_ARTIST, "albumArtist", 1).m91a(KEY_ALBUM_TITLE, "albumName", 1).m91a(KEY_COMPOSER, "composer", 1).m91a(KEY_DISC_NUMBER, "discNumber", 2).m91a(KEY_TRACK_NUMBER, "trackNumber", 2).m91a(KEY_SEASON_NUMBER, "season", 2).m91a(KEY_EPISODE_NUMBER, "episode", 2).m91a(KEY_SERIES_TITLE, "seriesTitle", 1).m91a(KEY_STUDIO, "studio", 1).m91a(KEY_WIDTH, "width", 2).m91a(KEY_HEIGHT, "height", 2).m91a(KEY_LOCATION_NAME, "location", 1).m91a(KEY_LOCATION_LATITUDE, "latitude", 3).m91a(KEY_LOCATION_LONGITUDE, "longitude", 3);
    private final List<WebImage> xJ;
    private final Bundle yr;
    private int ys;

    /* renamed from: com.google.android.gms.cast.MediaMetadata$a */
    private static class C0119a {
        private final Map<String, String> yt = new HashMap();
        private final Map<String, String> yu = new HashMap();
        private final Map<String, Integer> yv = new HashMap();

        /* renamed from: R */
        public String m88R(String str) {
            return (String) this.yt.get(str);
        }

        /* renamed from: S */
        public String m89S(String str) {
            return (String) this.yu.get(str);
        }

        /* renamed from: T */
        public int m90T(String str) {
            Integer num = (Integer) this.yv.get(str);
            return num != null ? num.intValue() : 0;
        }

        /* renamed from: a */
        public C0119a m91a(String str, String str2, int i) {
            this.yt.put(str, str2);
            this.yu.put(str2, str);
            this.yv.put(str, Integer.valueOf(i));
            return this;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.xJ = new ArrayList();
        this.yr = new Bundle();
        this.ys = mediaType;
    }

    /* renamed from: a */
    private void m92a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.yr.containsKey(str)) {
                    switch (yq.m90T(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(yq.m88R(str), this.yr.getString(str));
                            break;
                        case 2:
                            jSONObject.put(yq.m88R(str), this.yr.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(yq.m88R(str), this.yr.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.yr.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.yr.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    private boolean m93a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m93a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m94b(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String S = yq.m89S(str);
                    if (S == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.yr.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.yr.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.yr.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(S)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (yq.m90T(S)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.yr.putString(S, (String) obj2);
                                        break;
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.yr.putInt(S, ((Integer) obj2).intValue());
                                        break;
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.yr.putDouble(S, ((Double) obj2).doubleValue());
                                        break;
                                    case 4:
                                        if ((obj2 instanceof String) && ew.ac((String) obj2) != null) {
                                            this.yr.putString(S, (String) obj2);
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: d */
    private void m95d(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int T = yq.m90T(str);
        if (T != i && T != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + yp[i]);
        }
    }

    public void addImage(WebImage image) {
        this.xJ.add(image);
    }

    /* renamed from: c */
    public void m96c(JSONObject jSONObject) {
        clear();
        this.ys = 0;
        try {
            this.ys = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        ew.m911a(this.xJ, jSONObject);
        switch (this.ys) {
            case 0:
                m94b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                m94b(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                m94b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                m94b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                m94b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                m94b(jSONObject, new String[0]);
                return;
        }
    }

    public void clear() {
        this.yr.clear();
        this.xJ.clear();
    }

    public void clearImages() {
        this.xJ.clear();
    }

    public boolean containsKey(String key) {
        return this.yr.containsKey(key);
    }

    public JSONObject dB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.ys);
        } catch (JSONException e) {
        }
        ew.m912a(jSONObject, this.xJ);
        switch (this.ys) {
            case 0:
                m92a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                m92a(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                m92a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                m92a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                m92a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                m92a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return m93a(this.yr, mediaMetadata.yr) && this.xJ.equals(mediaMetadata.xJ);
    }

    public Calendar getDate(String key) {
        m95d(key, 4);
        String string = this.yr.getString(key);
        return string != null ? ew.ac(string) : null;
    }

    public String getDateAsString(String key) {
        m95d(key, 4);
        return this.yr.getString(key);
    }

    public double getDouble(String key) {
        m95d(key, 3);
        return this.yr.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.xJ;
    }

    public int getInt(String key) {
        m95d(key, 2);
        return this.yr.getInt(key);
    }

    public int getMediaType() {
        return this.ys;
    }

    public String getString(String key) {
        m95d(key, 1);
        return this.yr.getString(key);
    }

    public boolean hasImages() {
        return (this.xJ == null || this.xJ.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.yr.keySet()) {
            i *= 31;
            i = this.yr.get(str).hashCode() + i;
        }
        return (i * 31) + this.xJ.hashCode();
    }

    public Set<String> keySet() {
        return this.yr.keySet();
    }

    public void putDate(String key, Calendar value) {
        m95d(key, 4);
        this.yr.putString(key, ew.m910a(value));
    }

    public void putDouble(String key, double value) {
        m95d(key, 3);
        this.yr.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        m95d(key, 2);
        this.yr.putInt(key, value);
    }

    public void putString(String key, String value) {
        m95d(key, 1);
        this.yr.putString(key, value);
    }
}
