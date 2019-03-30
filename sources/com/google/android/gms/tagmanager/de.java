package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

class de {
    private GoogleAnalytics aaB;
    private Context mContext;
    private Tracker sB;

    /* renamed from: com.google.android.gms.tagmanager.de$a */
    static class C0828a implements Logger {
        C0828a() {
        }

        private static int ci(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m1382b("", exception);
        }

        public void error(String message) {
            bh.m1385w(message);
        }

        public int getLogLevel() {
            return C0828a.ci(bh.getLogLevel());
        }

        public void info(String message) {
            bh.m1386x(message);
        }

        public void setLogLevel(int logLevel) {
            bh.m1388z("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.m1387y(message);
        }

        public void warn(String message) {
            bh.m1388z(message);
        }
    }

    de(Context context) {
        this.mContext = context;
    }

    private synchronized void bV(String str) {
        if (this.aaB == null) {
            this.aaB = GoogleAnalytics.getInstance(this.mContext);
            this.aaB.setLogger(new C0828a());
            this.sB = this.aaB.newTracker(str);
        }
    }

    public Tracker bU(String str) {
        bV(str);
        return this.sB;
    }
}
