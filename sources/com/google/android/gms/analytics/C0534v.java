package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0097k.C0096a;

/* renamed from: com.google.android.gms.analytics.v */
class C0534v extends C0097k<C0535w> {

    /* renamed from: com.google.android.gms.analytics.v$a */
    private static class C0533a implements C0096a<C0535w> {
        private final C0535w uU = new C0535w();

        /* renamed from: a */
        public void mo1005a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.uU.uW = i;
            } else {
                aa.m36z("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: a */
        public void mo1006a(String str, String str2) {
        }

        /* renamed from: b */
        public void mo1007b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.uU.so = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.uU.sp = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.uU.uV = str2;
            } else {
                aa.m36z("string configuration name not recognized:  " + str);
            }
        }

        /* renamed from: c */
        public void mo1008c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.uU.uX = z ? 1 : 0;
                return;
            }
            aa.m36z("bool configuration name not recognized:  " + str);
        }

        public C0535w cB() {
            return this.uU;
        }

        public /* synthetic */ C0095j cg() {
            return cB();
        }
    }

    public C0534v(Context context) {
        super(context, new C0533a());
    }
}
