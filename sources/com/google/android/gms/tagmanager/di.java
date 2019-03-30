package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di extends df {
    private static final String ID = C0205a.UNIVERSAL_ANALYTICS.toString();
    private static final String aaO = C0209b.ACCOUNT.toString();
    private static final String aaP = C0209b.ANALYTICS_PASS_THROUGH.toString();
    private static final String aaQ = C0209b.ANALYTICS_FIELDS.toString();
    private static final String aaR = C0209b.TRACK_TRANSACTION.toString();
    private static final String aaS = C0209b.TRANSACTION_DATALAYER_MAP.toString();
    private static final String aaT = C0209b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static Map<String, String> aaU;
    private static Map<String, String> aaV;
    private final DataLayer WK;
    private final Set<String> aaW;
    private final de aaX;

    public di(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new de(context));
    }

    di(Context context, DataLayer dataLayer, de deVar) {
        super(ID, new String[0]);
        this.WK = dataLayer;
        this.aaX = deVar;
        this.aaW = new HashSet();
        this.aaW.add("");
        this.aaW.add("0");
        this.aaW.add("false");
    }

    /* renamed from: H */
    private Map<String, String> m3204H(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(aaS);
        if (c0969a != null) {
            return m3208c(c0969a);
        }
        if (aaU == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aaU = hashMap;
        }
        return aaU;
    }

    /* renamed from: I */
    private Map<String, String> m3205I(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(aaT);
        if (c0969a != null) {
            return m3208c(c0969a);
        }
        if (aaV == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            aaV = hashMap;
        }
        return aaV;
    }

    /* renamed from: a */
    private void m3206a(Tracker tracker, Map<String, C0969a> map) {
        String cc = cc("transactionId");
        if (cc == null) {
            bh.m1385w("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m3210p((C0969a) map.get(aaQ));
            p.put("&t", "transaction");
            for (Entry entry : m3204H(map).entrySet()) {
                m3207b(p, (String) entry.getValue(), cc((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> lU = lU();
            if (lU != null) {
                for (Map map2 : lU) {
                    if (map2.get("name") == null) {
                        bh.m1385w("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m3210p((C0969a) map.get(aaQ));
                    p2.put("&t", "item");
                    p2.put("&ti", cc);
                    for (Entry entry2 : m3205I(map).entrySet()) {
                        m3207b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.m1382b("Unable to send transaction", e);
        }
    }

    /* renamed from: b */
    private void m3207b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    /* renamed from: c */
    private Map<String, String> m3208c(C0969a c0969a) {
        Object o = dh.m1469o(c0969a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String cc(String str) {
        Object obj = this.WK.get(str);
        return obj == null ? null : obj.toString();
    }

    /* renamed from: e */
    private boolean m3209e(Map<String, C0969a> map, String str) {
        C0969a c0969a = (C0969a) map.get(str);
        return c0969a == null ? false : dh.m1467n(c0969a).booleanValue();
    }

    private List<Map<String, String>> lU() {
        Object obj = this.WK.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    /* renamed from: p */
    private Map<String, String> m3210p(C0969a c0969a) {
        if (c0969a == null) {
            return new HashMap();
        }
        Map<String, String> c = m3208c(c0969a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.aaW.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    /* renamed from: z */
    public void mo3175z(Map<String, C0969a> map) {
        Tracker bU = this.aaX.bU("_GTM_DEFAULT_TRACKER_");
        if (m3209e(map, aaP)) {
            bU.send(m3210p((C0969a) map.get(aaQ)));
        } else if (m3209e(map, aaR)) {
            m3206a(bU, map);
        } else {
            bh.m1388z("Ignoring unknown tag.");
        }
    }
}
