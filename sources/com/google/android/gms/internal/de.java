package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Map;

public final class de {
    private dz lC;
    private final Object li = new Object();
    private int oS = -2;
    private String pI;
    private String pJ;
    public final bb pK = new C06171(this);
    public final bb pL = new C06182(this);

    /* renamed from: com.google.android.gms.internal.de$1 */
    class C06171 implements bb {
        final /* synthetic */ de pM;

        C06171(de deVar) {
            this.pM = deVar;
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            synchronized (this.pM.li) {
                String str = (String) map.get("errors");
                dw.m824z("Invalid " + ((String) map.get("type")) + " request error: " + str);
                this.pM.oS = 1;
                this.pM.li.notify();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.de$2 */
    class C06182 implements bb {
        final /* synthetic */ de pM;

        C06182(de deVar) {
            this.pM = deVar;
        }

        /* renamed from: b */
        public void mo1589b(dz dzVar, Map<String, String> map) {
            synchronized (this.pM.li) {
                String str = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str == null) {
                    dw.m824z("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (str.contains("%40mediation_adapters%40")) {
                    str = str.replaceAll("%40mediation_adapters%40", dn.m772b(dzVar.getContext(), (String) map.get("check_adapters"), this.pM.pI));
                    dw.m823y("Ad request URL modified to " + str);
                }
                this.pM.pJ = str;
                this.pM.li.notify();
            }
        }
    }

    public de(String str) {
        this.pI = str;
    }

    /* renamed from: b */
    public void m737b(dz dzVar) {
        synchronized (this.li) {
            this.lC = dzVar;
        }
    }

    public String bj() {
        String str;
        synchronized (this.li) {
            while (this.pJ == null && this.oS == -2) {
                try {
                    this.li.wait();
                } catch (InterruptedException e) {
                    dw.m824z("Ad request service was interrupted.");
                    str = null;
                }
            }
            str = this.pJ;
        }
        return str;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.li) {
            i = this.oS;
        }
        return i;
    }
}
