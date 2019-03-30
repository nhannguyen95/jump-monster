package com.google.android.gms.analytics;

public class aa {
    private static GoogleAnalytics vs;

    public static boolean cT() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (vs == null) {
            vs = GoogleAnalytics.cM();
        }
        return vs != null ? vs.getLogger() : null;
    }

    /* renamed from: w */
    public static void m33w(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    /* renamed from: x */
    public static void m34x(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    /* renamed from: y */
    public static void m35y(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    /* renamed from: z */
    public static void m36z(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }
}
