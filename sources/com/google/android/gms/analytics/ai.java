package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0097k.C0096a;

class ai extends C0097k<aj> {

    /* renamed from: com.google.android.gms.analytics.ai$a */
    private static class C0523a implements C0096a<aj> {
        private final aj wg = new aj();

        /* renamed from: a */
        public void mo1005a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.wg.wj = i;
            } else {
                aa.m36z("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: a */
        public void mo1006a(String str, String str2) {
            this.wg.wn.put(str, str2);
        }

        /* renamed from: b */
        public void mo1007b(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.wg.wh = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.wg.wi = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    aa.m33w("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                aa.m36z("string configuration name not recognized:  " + str);
            }
        }

        /* renamed from: c */
        public void mo1008c(String str, boolean z) {
            int i = 1;
            aj ajVar;
            if ("ga_autoActivityTracking".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wk = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wl = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wm = i;
            } else {
                aa.m36z("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C0095j cg() {
            return di();
        }

        public aj di() {
            return this.wg;
        }
    }

    public ai(Context context) {
        super(context, new C0523a());
    }
}
