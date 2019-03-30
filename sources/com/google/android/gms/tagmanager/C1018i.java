package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1018i extends df {
    private static final String ID = C0205a.ARBITRARY_PIXEL.toString();
    private static final String URL = C0209b.URL.toString();
    private static final String WC = C0209b.ADDITIONAL_PARAMS.toString();
    private static final String WD = C0209b.UNREPEATABLE.toString();
    static final String WE = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> WF = new HashSet();
    private final C0405a WG;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i$a */
    public interface C0405a {
        aq jY();
    }

    /* renamed from: com.google.android.gms.tagmanager.i$1 */
    class C08331 implements C0405a {
        final /* synthetic */ Context pB;

        C08331(Context context) {
            this.pB = context;
        }

        public aq jY() {
            return C0848y.m2562F(this.pB);
        }
    }

    public C1018i(Context context) {
        this(context, new C08331(context));
    }

    C1018i(Context context, C0405a c0405a) {
        super(ID, URL);
        this.WG = c0405a;
        this.mContext = context;
    }

    private synchronized boolean bj(String str) {
        boolean z = true;
        synchronized (this) {
            if (!bl(str)) {
                if (bk(str)) {
                    WF.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean bk(String str) {
        return this.mContext.getSharedPreferences(WE, 0).contains(str);
    }

    boolean bl(String str) {
        return WF.contains(str);
    }

    /* renamed from: z */
    public void mo3175z(Map<String, C0969a> map) {
        String j = map.get(WD) != null ? dh.m1461j((C0969a) map.get(WD)) : null;
        if (j == null || !bj(j)) {
            Builder buildUpon = Uri.parse(dh.m1461j((C0969a) map.get(URL))).buildUpon();
            C0969a c0969a = (C0969a) map.get(WC);
            if (c0969a != null) {
                Object o = dh.m1469o(c0969a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m1385w("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m1385w("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.WG.jY().bz(uri);
            bh.m1387y("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1018i.class) {
                    WF.add(j);
                    cy.m1453a(this.mContext, WE, j, "true");
                }
            }
        }
    }
}
