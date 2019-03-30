package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class fe implements SafeParcelable {
    private static final Object CW = new Object();
    private static ClassLoader CX = null;
    private static Integer CY = null;
    private boolean CZ = false;

    /* renamed from: a */
    private static boolean m2153a(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean al(String str) {
        ClassLoader eI = eI();
        if (eI == null) {
            return true;
        }
        try {
            return m2153a(eI.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader eI() {
        ClassLoader classLoader;
        synchronized (CW) {
            classLoader = CX;
        }
        return classLoader;
    }

    protected static Integer eJ() {
        Integer num;
        synchronized (CW) {
            num = CY;
        }
        return num;
    }

    protected boolean eK() {
        return this.CZ;
    }
}
