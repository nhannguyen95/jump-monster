package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0223c.C0965i;
import com.google.android.gms.internal.C0239d.C0969a;
import com.google.android.gms.tagmanager.C0409l.C0408a;
import com.google.android.gms.tagmanager.C0844s.C0414a;
import com.google.android.gms.tagmanager.cq.C0391a;
import com.google.android.gms.tagmanager.cq.C0393c;
import com.google.android.gms.tagmanager.cq.C0395e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by<C0969a> ZE = new by(dh.lT(), true);
    private final DataLayer WK;
    private final C0393c ZF;
    private final ag ZG;
    private final Map<String, aj> ZH;
    private final Map<String, aj> ZI;
    private final Map<String, aj> ZJ;
    private final C0407k<C0391a, by<C0969a>> ZK;
    private final C0407k<String, C0399b> ZL;
    private final Set<C0395e> ZM;
    private final Map<String, C0400c> ZN;
    private volatile String ZO;
    private int ZP;

    /* renamed from: com.google.android.gms.tagmanager.cs$a */
    interface C0398a {
        /* renamed from: a */
        void mo2284a(C0395e c0395e, Set<C0391a> set, Set<C0391a> set2, cm cmVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.cs$b */
    private static class C0399b {
        private by<C0969a> ZV;
        private C0969a Zq;

        public C0399b(by<C0969a> byVar, C0969a c0969a) {
            this.ZV = byVar;
            this.Zq = c0969a;
        }

        public int getSize() {
            return (this.Zq == null ? 0 : this.Zq.mF()) + ((C0969a) this.ZV.getObject()).mF();
        }

        public C0969a lf() {
            return this.Zq;
        }

        public by<C0969a> lz() {
            return this.ZV;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs$c */
    private static class C0400c {
        private final Set<C0395e> ZM = new HashSet();
        private final Map<C0395e, List<C0391a>> ZW = new HashMap();
        private final Map<C0395e, List<C0391a>> ZX = new HashMap();
        private final Map<C0395e, List<String>> ZY = new HashMap();
        private final Map<C0395e, List<String>> ZZ = new HashMap();
        private C0391a aaa;

        /* renamed from: a */
        public void m1429a(C0395e c0395e, C0391a c0391a) {
            List list = (List) this.ZW.get(c0395e);
            if (list == null) {
                list = new ArrayList();
                this.ZW.put(c0395e, list);
            }
            list.add(c0391a);
        }

        /* renamed from: a */
        public void m1430a(C0395e c0395e, String str) {
            List list = (List) this.ZY.get(c0395e);
            if (list == null) {
                list = new ArrayList();
                this.ZY.put(c0395e, list);
            }
            list.add(str);
        }

        /* renamed from: b */
        public void m1431b(C0395e c0395e) {
            this.ZM.add(c0395e);
        }

        /* renamed from: b */
        public void m1432b(C0395e c0395e, C0391a c0391a) {
            List list = (List) this.ZX.get(c0395e);
            if (list == null) {
                list = new ArrayList();
                this.ZX.put(c0395e, list);
            }
            list.add(c0391a);
        }

        /* renamed from: b */
        public void m1433b(C0395e c0395e, String str) {
            List list = (List) this.ZZ.get(c0395e);
            if (list == null) {
                list = new ArrayList();
                this.ZZ.put(c0395e, list);
            }
            list.add(str);
        }

        /* renamed from: i */
        public void m1434i(C0391a c0391a) {
            this.aaa = c0391a;
        }

        public Set<C0395e> lA() {
            return this.ZM;
        }

        public Map<C0395e, List<C0391a>> lB() {
            return this.ZW;
        }

        public Map<C0395e, List<String>> lC() {
            return this.ZY;
        }

        public Map<C0395e, List<String>> lD() {
            return this.ZZ;
        }

        public Map<C0395e, List<C0391a>> lE() {
            return this.ZX;
        }

        public C0391a lF() {
            return this.aaa;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs$1 */
    class C08221 implements C0408a<C0391a, by<C0969a>> {
        final /* synthetic */ cs ZQ;

        C08221(cs csVar) {
            this.ZQ = csVar;
        }

        /* renamed from: a */
        public int m2495a(C0391a c0391a, by<C0969a> byVar) {
            return ((C0969a) byVar.getObject()).mF();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2495a((C0391a) x0, (by) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs$2 */
    class C08232 implements C0408a<String, C0399b> {
        final /* synthetic */ cs ZQ;

        C08232(cs csVar) {
            this.ZQ = csVar;
        }

        /* renamed from: a */
        public int m2496a(String str, C0399b c0399b) {
            return str.length() + c0399b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2496a((String) x0, (C0399b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs$4 */
    class C08254 implements C0398a {
        final /* synthetic */ cs ZQ;

        C08254(cs csVar) {
            this.ZQ = csVar;
        }

        /* renamed from: a */
        public void mo2284a(C0395e c0395e, Set<C0391a> set, Set<C0391a> set2, cm cmVar) {
            set.addAll(c0395e.lo());
            set2.addAll(c0395e.lp());
            cmVar.kM().mo2261b(c0395e.lo(), c0395e.lt());
            cmVar.kN().mo2261b(c0395e.lp(), c0395e.lu());
        }
    }

    public cs(Context context, C0393c c0393c, DataLayer dataLayer, C0414a c0414a, C0414a c0414a2, ag agVar) {
        if (c0393c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.ZF = c0393c;
        this.ZM = new HashSet(c0393c.li());
        this.WK = dataLayer;
        this.ZG = agVar;
        this.ZK = new C0409l().m1482a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C08221(this));
        this.ZL = new C0409l().m1482a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C08232(this));
        this.ZH = new HashMap();
        m1449b(new C1018i(context));
        m1449b(new C0844s(c0414a2));
        m1449b(new C1021w(dataLayer));
        m1449b(new di(context, dataLayer));
        this.ZI = new HashMap();
        m1450c(new C1078q());
        m1450c(new ad());
        m1450c(new ae());
        m1450c(new al());
        m1450c(new am());
        m1450c(new bd());
        m1450c(new be());
        m1450c(new ch());
        m1450c(new db());
        this.ZJ = new HashMap();
        m1448a(new C0816b(context));
        m1448a(new C0818c(context));
        m1448a(new C0829e(context));
        m1448a(new C0830f(context));
        m1448a(new C0831g(context));
        m1448a(new C0832h(context));
        m1448a(new C0835m());
        m1448a(new C0843p(this.ZF.getVersion()));
        m1448a(new C0844s(c0414a));
        m1448a(new C0845u(dataLayer));
        m1448a(new C0849z(context));
        m1448a(new aa());
        m1448a(new ac());
        m1448a(new ah(this));
        m1448a(new an());
        m1448a(new ao());
        m1448a(new ax(context));
        m1448a(new az());
        m1448a(new bc());
        m1448a(new bk(context));
        m1448a(new bz());
        m1448a(new cb());
        m1448a(new ce());
        m1448a(new cg());
        m1448a(new ci(context));
        m1448a(new ct());
        m1448a(new cu());
        m1448a(new dd());
        this.ZN = new HashMap();
        for (C0395e c0395e : this.ZM) {
            if (agVar.kA()) {
                m1440a(c0395e.lq(), c0395e.lr(), "add macro");
                m1440a(c0395e.lv(), c0395e.ls(), "remove macro");
                m1440a(c0395e.lo(), c0395e.lt(), "add tag");
                m1440a(c0395e.lp(), c0395e.lu(), "remove tag");
            }
            int i = 0;
            while (i < c0395e.lq().size()) {
                C0391a c0391a = (C0391a) c0395e.lq().get(i);
                String str = "Unknown";
                if (agVar.kA() && i < c0395e.lr().size()) {
                    str = (String) c0395e.lr().get(i);
                }
                C0400c d = m1442d(this.ZN, m1443h(c0391a));
                d.m1431b(c0395e);
                d.m1429a(c0395e, c0391a);
                d.m1430a(c0395e, str);
                i++;
            }
            i = 0;
            while (i < c0395e.lv().size()) {
                c0391a = (C0391a) c0395e.lv().get(i);
                str = "Unknown";
                if (agVar.kA() && i < c0395e.ls().size()) {
                    str = (String) c0395e.ls().get(i);
                }
                d = m1442d(this.ZN, m1443h(c0391a));
                d.m1431b(c0395e);
                d.m1432b(c0395e, c0391a);
                d.m1433b(c0395e, str);
                i++;
            }
        }
        for (Entry entry : this.ZF.lj().entrySet()) {
            for (C0391a c0391a2 : (List) entry.getValue()) {
                if (!dh.m1467n((C0969a) c0391a2.le().get(C0209b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1442d(this.ZN, (String) entry.getKey()).m1434i(c0391a2);
                }
            }
        }
    }

    /* renamed from: a */
    private by<C0969a> m1435a(C0969a c0969a, Set<String> set, dj djVar) {
        if (!c0969a.fX) {
            return new by(c0969a, true);
        }
        C0969a g;
        int i;
        by a;
        switch (c0969a.type) {
            case 2:
                g = cq.m1425g(c0969a);
                g.fO = new C0969a[c0969a.fO.length];
                for (i = 0; i < c0969a.fO.length; i++) {
                    a = m1435a(c0969a.fO[i], (Set) set, djVar.cd(i));
                    if (a == ZE) {
                        return ZE;
                    }
                    g.fO[i] = (C0969a) a.getObject();
                }
                return new by(g, false);
            case 3:
                g = cq.m1425g(c0969a);
                if (c0969a.fP.length != c0969a.fQ.length) {
                    bh.m1385w("Invalid serving value: " + c0969a.toString());
                    return ZE;
                }
                g.fP = new C0969a[c0969a.fP.length];
                g.fQ = new C0969a[c0969a.fP.length];
                for (i = 0; i < c0969a.fP.length; i++) {
                    a = m1435a(c0969a.fP[i], (Set) set, djVar.ce(i));
                    by a2 = m1435a(c0969a.fQ[i], (Set) set, djVar.cf(i));
                    if (a == ZE || a2 == ZE) {
                        return ZE;
                    }
                    g.fP[i] = (C0969a) a.getObject();
                    g.fQ[i] = (C0969a) a2.getObject();
                }
                return new by(g, false);
            case 4:
                if (set.contains(c0969a.fR)) {
                    bh.m1385w("Macro cycle detected.  Current macro reference: " + c0969a.fR + "." + "  Previous macro references: " + set.toString() + ".");
                    return ZE;
                }
                set.add(c0969a.fR);
                by<C0969a> a3 = dk.m1478a(m1436a(c0969a.fR, (Set) set, djVar.kP()), c0969a.fW);
                set.remove(c0969a.fR);
                return a3;
            case 7:
                g = cq.m1425g(c0969a);
                g.fV = new C0969a[c0969a.fV.length];
                for (i = 0; i < c0969a.fV.length; i++) {
                    a = m1435a(c0969a.fV[i], (Set) set, djVar.cg(i));
                    if (a == ZE) {
                        return ZE;
                    }
                    g.fV[i] = (C0969a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m1385w("Unknown type: " + c0969a.type);
                return ZE;
        }
    }

    /* renamed from: a */
    private by<C0969a> m1436a(String str, Set<String> set, bj bjVar) {
        this.ZP++;
        C0399b c0399b = (C0399b) this.ZL.get(str);
        if (c0399b == null || this.ZG.kA()) {
            C0400c c0400c = (C0400c) this.ZN.get(str);
            if (c0400c == null) {
                bh.m1385w(ly() + "Invalid macro: " + str);
                this.ZP--;
                return ZE;
            }
            C0391a lF;
            by a = m1446a(str, c0400c.lA(), c0400c.lB(), c0400c.lC(), c0400c.lE(), c0400c.lD(), set, bjVar.kr());
            if (((Set) a.getObject()).isEmpty()) {
                lF = c0400c.lF();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m1388z(ly() + "Multiple macros active for macroName " + str);
                }
                lF = (C0391a) ((Set) a.getObject()).iterator().next();
            }
            if (lF == null) {
                this.ZP--;
                return ZE;
            }
            by a2 = m1437a(this.ZJ, lF, (Set) set, bjVar.kG());
            boolean z = a.kQ() && a2.kQ();
            by<C0969a> byVar = a2 == ZE ? ZE : new by(a2.getObject(), z);
            C0969a lf = lF.lf();
            if (byVar.kQ()) {
                this.ZL.mo2245e(str, new C0399b(byVar, lf));
            }
            m1439a(lf, (Set) set);
            this.ZP--;
            return byVar;
        }
        m1439a(c0399b.lf(), (Set) set);
        this.ZP--;
        return c0399b.lz();
    }

    /* renamed from: a */
    private by<C0969a> m1437a(Map<String, aj> map, C0391a c0391a, Set<String> set, cj cjVar) {
        boolean z = true;
        C0969a c0969a = (C0969a) c0391a.le().get(C0209b.FUNCTION.toString());
        if (c0969a == null) {
            bh.m1385w("No function id in properties");
            return ZE;
        }
        String str = c0969a.fS;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m1385w(str + " has no backing implementation.");
            return ZE;
        }
        by<C0969a> byVar = (by) this.ZK.get(c0391a);
        if (byVar != null && !this.ZG.kA()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0391a.le().entrySet()) {
            by a = m1435a((C0969a) entry.getValue(), (Set) set, cjVar.bH((String) entry.getKey()).mo2260e((C0969a) entry.getValue()));
            if (a == ZE) {
                return ZE;
            }
            boolean z3;
            if (a.kQ()) {
                c0391a.m1408a((String) entry.getKey(), (C0969a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m1366a(hashMap.keySet())) {
            if (!(z2 && ajVar.jX())) {
                z = false;
            }
            byVar = new by(ajVar.mo2240x(hashMap), z);
            if (z) {
                this.ZK.mo2245e(c0391a, byVar);
            }
            cjVar.mo2259d((C0969a) byVar.getObject());
            return byVar;
        }
        bh.m1385w("Incorrect keys for function " + str + " required " + ajVar.kC() + " had " + hashMap.keySet());
        return ZE;
    }

    /* renamed from: a */
    private by<Set<C0391a>> m1438a(Set<C0395e> set, Set<String> set2, C0398a c0398a, cr crVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0395e c0395e : set) {
            cm kO = crVar.kO();
            by a = m1445a(c0395e, (Set) set2, kO);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0398a.mo2284a(c0395e, hashSet, hashSet2, kO);
            }
            boolean z2 = z && a.kQ();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        crVar.mo2269b(hashSet);
        return new by(hashSet, z);
    }

    /* renamed from: a */
    private void m1439a(C0969a c0969a, Set<String> set) {
        if (c0969a != null) {
            by a = m1435a(c0969a, (Set) set, new bw());
            if (a != ZE) {
                Object o = dh.m1469o((C0969a) a.getObject());
                if (o instanceof Map) {
                    this.WK.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.WK.push((Map) o2);
                        } else {
                            bh.m1388z("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m1388z("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m1440a(List<C0391a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m1386x("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    /* renamed from: a */
    private static void m1441a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.kB())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.kB());
        }
        map.put(ajVar.kB(), ajVar);
    }

    /* renamed from: d */
    private static C0400c m1442d(Map<String, C0400c> map, String str) {
        C0400c c0400c = (C0400c) map.get(str);
        if (c0400c != null) {
            return c0400c;
        }
        c0400c = new C0400c();
        map.put(str, c0400c);
        return c0400c;
    }

    /* renamed from: h */
    private static String m1443h(C0391a c0391a) {
        return dh.m1461j((C0969a) c0391a.le().get(C0209b.INSTANCE_NAME.toString()));
    }

    private String ly() {
        if (this.ZP <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.ZP));
        for (int i = 2; i < this.ZP; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    by<Boolean> m1444a(C0391a c0391a, Set<String> set, cj cjVar) {
        by a = m1437a(this.ZI, c0391a, (Set) set, cjVar);
        Boolean n = dh.m1467n((C0969a) a.getObject());
        cjVar.mo2259d(dh.m1472r(n));
        return new by(n, a.kQ());
    }

    /* renamed from: a */
    by<Boolean> m1445a(C0395e c0395e, Set<String> set, cm cmVar) {
        boolean z = true;
        for (C0391a a : c0395e.ln()) {
            by a2 = m1444a(a, (Set) set, cmVar.kI());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cmVar.mo2262f(dh.m1472r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.kQ());
            }
            boolean z2 = z && a2.kQ();
            z = z2;
        }
        for (C0391a a3 : c0395e.lm()) {
            a2 = m1444a(a3, (Set) set, cmVar.kJ());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.kQ();
            } else {
                cmVar.mo2262f(dh.m1472r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.kQ());
            }
        }
        cmVar.mo2262f(dh.m1472r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    /* renamed from: a */
    by<Set<C0391a>> m1446a(String str, Set<C0395e> set, Map<C0395e, List<C0391a>> map, Map<C0395e, List<String>> map2, Map<C0395e, List<C0391a>> map3, Map<C0395e, List<String>> map4, Set<String> set2, cr crVar) {
        final Map<C0395e, List<C0391a>> map5 = map;
        final Map<C0395e, List<String>> map6 = map2;
        final Map<C0395e, List<C0391a>> map7 = map3;
        final Map<C0395e, List<String>> map8 = map4;
        return m1438a((Set) set, (Set) set2, new C0398a(this) {
            final /* synthetic */ cs ZQ;

            /* renamed from: a */
            public void mo2284a(C0395e c0395e, Set<C0391a> set, Set<C0391a> set2, cm cmVar) {
                List list = (List) map5.get(c0395e);
                List list2 = (List) map6.get(c0395e);
                if (list != null) {
                    set.addAll(list);
                    cmVar.kK().mo2261b(list, list2);
                }
                list = (List) map7.get(c0395e);
                list2 = (List) map8.get(c0395e);
                if (list != null) {
                    set2.addAll(list);
                    cmVar.kL().mo2261b(list, list2);
                }
            }
        }, crVar);
    }

    /* renamed from: a */
    by<Set<C0391a>> m1447a(Set<C0395e> set, cr crVar) {
        return m1438a((Set) set, new HashSet(), new C08254(this), crVar);
    }

    /* renamed from: a */
    void m1448a(aj ajVar) {
        m1441a(this.ZJ, ajVar);
    }

    /* renamed from: b */
    void m1449b(aj ajVar) {
        m1441a(this.ZH, ajVar);
    }

    public by<C0969a> bR(String str) {
        this.ZP = 0;
        af bA = this.ZG.bA(str);
        by<C0969a> a = m1436a(str, new HashSet(), bA.kx());
        bA.kz();
        return a;
    }

    synchronized void bS(String str) {
        this.ZO = str;
    }

    public synchronized void bp(String str) {
        bS(str);
        af bB = this.ZG.bB(str);
        C0415t ky = bB.ky();
        for (C0391a a : (Set) m1447a(this.ZM, ky.kr()).getObject()) {
            m1437a(this.ZH, a, new HashSet(), ky.kq());
        }
        bB.kz();
        bS(null);
    }

    /* renamed from: c */
    void m1450c(aj ajVar) {
        m1441a(this.ZI, ajVar);
    }

    /* renamed from: e */
    public synchronized void m1451e(List<C0965i> list) {
        for (C0965i c0965i : list) {
            if (c0965i.name == null || !c0965i.name.startsWith("gaExperiment:")) {
                bh.m1387y("Ignored supplemental: " + c0965i);
            } else {
                ai.m1362a(this.WK, c0965i);
            }
        }
    }

    synchronized String lx() {
        return this.ZO;
    }
}
