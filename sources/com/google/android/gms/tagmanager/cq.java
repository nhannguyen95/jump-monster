package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0223c.C0958b;
import com.google.android.gms.internal.C0223c.C0961e;
import com.google.android.gms.internal.C0223c.C0962f;
import com.google.android.gms.internal.C0223c.C0963g;
import com.google.android.gms.internal.C0223c.C0964h;
import com.google.android.gms.internal.C0239d.C0969a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq {

    /* renamed from: com.google.android.gms.tagmanager.cq$a */
    public static class C0391a {
        private final Map<String, C0969a> Zp;
        private final C0969a Zq;

        private C0391a(Map<String, C0969a> map, C0969a c0969a) {
            this.Zp = map;
            this.Zq = c0969a;
        }

        public static C0392b ld() {
            return new C0392b();
        }

        /* renamed from: a */
        public void m1408a(String str, C0969a c0969a) {
            this.Zp.put(str, c0969a);
        }

        public Map<String, C0969a> le() {
            return Collections.unmodifiableMap(this.Zp);
        }

        public C0969a lf() {
            return this.Zq;
        }

        public String toString() {
            return "Properties: " + le() + " pushAfterEvaluate: " + this.Zq;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$b */
    public static class C0392b {
        private final Map<String, C0969a> Zp;
        private C0969a Zq;

        private C0392b() {
            this.Zp = new HashMap();
        }

        /* renamed from: b */
        public C0392b m1409b(String str, C0969a c0969a) {
            this.Zp.put(str, c0969a);
            return this;
        }

        /* renamed from: i */
        public C0392b m1410i(C0969a c0969a) {
            this.Zq = c0969a;
            return this;
        }

        public C0391a lg() {
            return new C0391a(this.Zp, this.Zq);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$c */
    public static class C0393c {
        private final String Xl;
        private final List<C0395e> Zr;
        private final Map<String, List<C0391a>> Zs;
        private final int Zt;

        private C0393c(List<C0395e> list, Map<String, List<C0391a>> map, String str, int i) {
            this.Zr = Collections.unmodifiableList(list);
            this.Zs = Collections.unmodifiableMap(map);
            this.Xl = str;
            this.Zt = i;
        }

        public static C0394d lh() {
            return new C0394d();
        }

        public String getVersion() {
            return this.Xl;
        }

        public List<C0395e> li() {
            return this.Zr;
        }

        public Map<String, List<C0391a>> lj() {
            return this.Zs;
        }

        public String toString() {
            return "Rules: " + li() + "  Macros: " + this.Zs;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$d */
    public static class C0394d {
        private String Xl;
        private final List<C0395e> Zr;
        private final Map<String, List<C0391a>> Zs;
        private int Zt;

        private C0394d() {
            this.Zr = new ArrayList();
            this.Zs = new HashMap();
            this.Xl = "";
            this.Zt = 0;
        }

        /* renamed from: a */
        public C0394d m1411a(C0391a c0391a) {
            String j = dh.m1461j((C0969a) c0391a.le().get(C0209b.INSTANCE_NAME.toString()));
            List list = (List) this.Zs.get(j);
            if (list == null) {
                list = new ArrayList();
                this.Zs.put(j, list);
            }
            list.add(c0391a);
            return this;
        }

        /* renamed from: a */
        public C0394d m1412a(C0395e c0395e) {
            this.Zr.add(c0395e);
            return this;
        }

        public C0394d bM(String str) {
            this.Xl = str;
            return this;
        }

        public C0394d ch(int i) {
            this.Zt = i;
            return this;
        }

        public C0393c lk() {
            return new C0393c(this.Zr, this.Zs, this.Xl, this.Zt);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$e */
    public static class C0395e {
        private final List<String> ZA;
        private final List<String> ZB;
        private final List<String> ZC;
        private final List<String> ZD;
        private final List<C0391a> Zu;
        private final List<C0391a> Zv;
        private final List<C0391a> Zw;
        private final List<C0391a> Zx;
        private final List<C0391a> Zy;
        private final List<C0391a> Zz;

        private C0395e(List<C0391a> list, List<C0391a> list2, List<C0391a> list3, List<C0391a> list4, List<C0391a> list5, List<C0391a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.Zu = Collections.unmodifiableList(list);
            this.Zv = Collections.unmodifiableList(list2);
            this.Zw = Collections.unmodifiableList(list3);
            this.Zx = Collections.unmodifiableList(list4);
            this.Zy = Collections.unmodifiableList(list5);
            this.Zz = Collections.unmodifiableList(list6);
            this.ZA = Collections.unmodifiableList(list7);
            this.ZB = Collections.unmodifiableList(list8);
            this.ZC = Collections.unmodifiableList(list9);
            this.ZD = Collections.unmodifiableList(list10);
        }

        public static C0396f ll() {
            return new C0396f();
        }

        public List<C0391a> lm() {
            return this.Zu;
        }

        public List<C0391a> ln() {
            return this.Zv;
        }

        public List<C0391a> lo() {
            return this.Zw;
        }

        public List<C0391a> lp() {
            return this.Zx;
        }

        public List<C0391a> lq() {
            return this.Zy;
        }

        public List<String> lr() {
            return this.ZA;
        }

        public List<String> ls() {
            return this.ZB;
        }

        public List<String> lt() {
            return this.ZC;
        }

        public List<String> lu() {
            return this.ZD;
        }

        public List<C0391a> lv() {
            return this.Zz;
        }

        public String toString() {
            return "Positive predicates: " + lm() + "  Negative predicates: " + ln() + "  Add tags: " + lo() + "  Remove tags: " + lp() + "  Add macros: " + lq() + "  Remove macros: " + lv();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$f */
    public static class C0396f {
        private final List<String> ZA;
        private final List<String> ZB;
        private final List<String> ZC;
        private final List<String> ZD;
        private final List<C0391a> Zu;
        private final List<C0391a> Zv;
        private final List<C0391a> Zw;
        private final List<C0391a> Zx;
        private final List<C0391a> Zy;
        private final List<C0391a> Zz;

        private C0396f() {
            this.Zu = new ArrayList();
            this.Zv = new ArrayList();
            this.Zw = new ArrayList();
            this.Zx = new ArrayList();
            this.Zy = new ArrayList();
            this.Zz = new ArrayList();
            this.ZA = new ArrayList();
            this.ZB = new ArrayList();
            this.ZC = new ArrayList();
            this.ZD = new ArrayList();
        }

        /* renamed from: b */
        public C0396f m1413b(C0391a c0391a) {
            this.Zu.add(c0391a);
            return this;
        }

        public C0396f bN(String str) {
            this.ZC.add(str);
            return this;
        }

        public C0396f bO(String str) {
            this.ZD.add(str);
            return this;
        }

        public C0396f bP(String str) {
            this.ZA.add(str);
            return this;
        }

        public C0396f bQ(String str) {
            this.ZB.add(str);
            return this;
        }

        /* renamed from: c */
        public C0396f m1414c(C0391a c0391a) {
            this.Zv.add(c0391a);
            return this;
        }

        /* renamed from: d */
        public C0396f m1415d(C0391a c0391a) {
            this.Zw.add(c0391a);
            return this;
        }

        /* renamed from: e */
        public C0396f m1416e(C0391a c0391a) {
            this.Zx.add(c0391a);
            return this;
        }

        /* renamed from: f */
        public C0396f m1417f(C0391a c0391a) {
            this.Zy.add(c0391a);
            return this;
        }

        /* renamed from: g */
        public C0396f m1418g(C0391a c0391a) {
            this.Zz.add(c0391a);
            return this;
        }

        public C0395e lw() {
            return new C0395e(this.Zu, this.Zv, this.Zw, this.Zx, this.Zy, this.Zz, this.ZA, this.ZB, this.ZC, this.ZD);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq$g */
    public static class C0397g extends Exception {
        public C0397g(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static C0969a m1419a(int i, C0962f c0962f, C0969a[] c0969aArr, Set<Integer> set) throws C0397g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            bL("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C0969a c0969a = (C0969a) m1422a(c0962f.eX, i, "values");
        if (c0969aArr[i] != null) {
            return c0969aArr[i];
        }
        C0969a c0969a2 = null;
        set.add(Integer.valueOf(i));
        C0964h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c0969a.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                c0969a2 = c0969a;
                break;
            case 2:
                h = m1426h(c0969a);
                c0969a2 = m1425g(c0969a);
                c0969a2.fO = new C0969a[h.fz.length];
                iArr = h.fz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0969a2.fO[i3] = m1419a(iArr[i2], c0962f, c0969aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                c0969a2 = m1425g(c0969a);
                C0964h h2 = m1426h(c0969a);
                if (h2.fA.length != h2.fB.length) {
                    bL("Uneven map keys (" + h2.fA.length + ") and map values (" + h2.fB.length + ")");
                }
                c0969a2.fP = new C0969a[h2.fA.length];
                c0969a2.fQ = new C0969a[h2.fA.length];
                int[] iArr2 = h2.fA;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c0969a2.fP[i4] = m1419a(iArr2[i3], c0962f, c0969aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fB;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0969a2.fQ[i3] = m1419a(iArr[i2], c0962f, c0969aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                c0969a2 = m1425g(c0969a);
                c0969a2.fR = dh.m1461j(m1419a(m1426h(c0969a).fE, c0962f, c0969aArr, (Set) set));
                break;
            case 7:
                c0969a2 = m1425g(c0969a);
                h = m1426h(c0969a);
                c0969a2.fV = new C0969a[h.fD.length];
                iArr = h.fD;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c0969a2.fV[i3] = m1419a(iArr[i2], c0962f, c0969aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c0969a2 == null) {
            bL("Invalid value: " + c0969a);
        }
        c0969aArr[i] = c0969a2;
        set.remove(Integer.valueOf(i));
        return c0969a2;
    }

    /* renamed from: a */
    private static C0391a m1420a(C0958b c0958b, C0962f c0962f, C0969a[] c0969aArr, int i) throws C0397g {
        C0392b ld = C0391a.ld();
        for (int valueOf : c0958b.eH) {
            C0961e c0961e = (C0961e) m1422a(c0962f.eY, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m1422a(c0962f.eW, c0961e.key, "keys");
            C0969a c0969a = (C0969a) m1422a(c0969aArr, c0961e.value, "values");
            if (C0209b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                ld.m1410i(c0969a);
            } else {
                ld.m1409b(str, c0969a);
            }
        }
        return ld.lg();
    }

    /* renamed from: a */
    private static C0395e m1421a(C0963g c0963g, List<C0391a> list, List<C0391a> list2, List<C0391a> list3, C0962f c0962f) {
        C0396f ll = C0395e.ll();
        for (int valueOf : c0963g.fn) {
            ll.m1413b((C0391a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c0963g.fo) {
            ll.m1414c((C0391a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c0963g.fp) {
            ll.m1415d((C0391a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c0963g.fr) {
            ll.bN(c0962f.eX[Integer.valueOf(valueOf3).intValue()].fN);
        }
        for (int valueOf222 : c0963g.fq) {
            ll.m1416e((C0391a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c0963g.fs) {
            ll.bO(c0962f.eX[Integer.valueOf(valueOf32).intValue()].fN);
        }
        for (int valueOf2222 : c0963g.ft) {
            ll.m1417f((C0391a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c0963g.fv) {
            ll.bP(c0962f.eX[Integer.valueOf(valueOf322).intValue()].fN);
        }
        for (int valueOf22222 : c0963g.fu) {
            ll.m1418g((C0391a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c0963g.fw) {
            ll.bQ(c0962f.eX[Integer.valueOf(valueOf4).intValue()].fN);
        }
        return ll.lw();
    }

    /* renamed from: a */
    private static <T> T m1422a(T[] tArr, int i, String str) throws C0397g {
        if (i < 0 || i >= tArr.length) {
            bL("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    /* renamed from: b */
    public static C0393c m1423b(C0962f c0962f) throws C0397g {
        int i;
        int i2 = 0;
        C0969a[] c0969aArr = new C0969a[c0962f.eX.length];
        for (i = 0; i < c0962f.eX.length; i++) {
            m1419a(i, c0962f, c0969aArr, new HashSet(0));
        }
        C0394d lh = C0393c.lh();
        List arrayList = new ArrayList();
        for (i = 0; i < c0962f.fa.length; i++) {
            arrayList.add(m1420a(c0962f.fa[i], c0962f, c0969aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c0962f.fb.length; i++) {
            arrayList2.add(m1420a(c0962f.fb[i], c0962f, c0969aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c0962f.eZ.length; i++) {
            C0391a a = m1420a(c0962f.eZ[i], c0962f, c0969aArr, i);
            lh.m1411a(a);
            arrayList3.add(a);
        }
        C0963g[] c0963gArr = c0962f.fc;
        int length = c0963gArr.length;
        while (i2 < length) {
            lh.m1412a(m1421a(c0963gArr[i2], arrayList, arrayList3, arrayList2, c0962f));
            i2++;
        }
        lh.bM(c0962f.fg);
        lh.ch(c0962f.fl);
        return lh.lk();
    }

    /* renamed from: b */
    public static void m1424b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void bL(String str) throws C0397g {
        bh.m1385w(str);
        throw new C0397g(str);
    }

    /* renamed from: g */
    public static C0969a m1425g(C0969a c0969a) {
        C0969a c0969a2 = new C0969a();
        c0969a2.type = c0969a.type;
        c0969a2.fW = (int[]) c0969a.fW.clone();
        if (c0969a.fX) {
            c0969a2.fX = c0969a.fX;
        }
        return c0969a2;
    }

    /* renamed from: h */
    private static C0964h m1426h(C0969a c0969a) throws C0397g {
        if (((C0964h) c0969a.m2317a(C0964h.fx)) == null) {
            bL("Expected a ServingValue and didn't get one. Value is: " + c0969a);
        }
        return (C0964h) c0969a.m2317a(C0964h.fx);
    }
}
