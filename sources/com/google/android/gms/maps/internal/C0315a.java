package com.google.android.gms.maps.internal;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C0315a {
    /* renamed from: a */
    public static Boolean m1228a(byte b) {
        switch (b) {
            case (byte) 0:
                return Boolean.FALSE;
            case (byte) 1:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    /* renamed from: c */
    public static byte m1229c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
