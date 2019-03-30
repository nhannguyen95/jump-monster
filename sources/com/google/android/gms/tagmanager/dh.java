package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0239d.C0969a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh {
    private static final Object aaF = null;
    private static Long aaG = new Long(0);
    private static Double aaH = new Double(0.0d);
    private static dg aaI = dg.m1459w(0);
    private static String aaJ = new String("");
    private static Boolean aaK = new Boolean(false);
    private static List<Object> aaL = new ArrayList(0);
    private static Map<Object, Object> aaM = new HashMap();
    private static C0969a aaN = m1472r(aaJ);

    public static C0969a bX(String str) {
        C0969a c0969a = new C0969a();
        c0969a.type = 5;
        c0969a.fS = str;
        return c0969a;
    }

    private static dg bY(String str) {
        try {
            return dg.bW(str);
        } catch (NumberFormatException e) {
            bh.m1385w("Failed to convert '" + str + "' to a number.");
            return aaI;
        }
    }

    private static Long bZ(String str) {
        dg bY = bY(str);
        return bY == aaI ? aaG : Long.valueOf(bY.longValue());
    }

    private static Double ca(String str) {
        dg bY = bY(str);
        return bY == aaI ? aaH : Double.valueOf(bY.doubleValue());
    }

    private static Boolean cb(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : aaK;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m1385w("getDouble received non-Number");
        return 0.0d;
    }

    /* renamed from: j */
    public static String m1461j(C0969a c0969a) {
        return m1465m(m1469o(c0969a));
    }

    /* renamed from: k */
    public static dg m1462k(C0969a c0969a) {
        return m1466n(m1469o(c0969a));
    }

    /* renamed from: l */
    public static Long m1463l(C0969a c0969a) {
        return m1468o(m1469o(c0969a));
    }

    public static Object lN() {
        return aaF;
    }

    public static Long lO() {
        return aaG;
    }

    public static Double lP() {
        return aaH;
    }

    public static Boolean lQ() {
        return aaK;
    }

    public static dg lR() {
        return aaI;
    }

    public static String lS() {
        return aaJ;
    }

    public static C0969a lT() {
        return aaN;
    }

    /* renamed from: m */
    public static Double m1464m(C0969a c0969a) {
        return m1470p(m1469o(c0969a));
    }

    /* renamed from: m */
    public static String m1465m(Object obj) {
        return obj == null ? aaJ : obj.toString();
    }

    /* renamed from: n */
    public static dg m1466n(Object obj) {
        return obj instanceof dg ? (dg) obj : m1474t(obj) ? dg.m1459w(m1475u(obj)) : m1473s(obj) ? dg.m1458a(Double.valueOf(getDouble(obj))) : bY(m1465m(obj));
    }

    /* renamed from: n */
    public static Boolean m1467n(C0969a c0969a) {
        return m1471q(m1469o(c0969a));
    }

    /* renamed from: o */
    public static Long m1468o(Object obj) {
        return m1474t(obj) ? Long.valueOf(m1475u(obj)) : bZ(m1465m(obj));
    }

    /* renamed from: o */
    public static Object m1469o(C0969a c0969a) {
        int i = 0;
        if (c0969a == null) {
            return aaF;
        }
        C0969a[] c0969aArr;
        int length;
        switch (c0969a.type) {
            case 1:
                return c0969a.fN;
            case 2:
                ArrayList arrayList = new ArrayList(c0969a.fO.length);
                c0969aArr = c0969a.fO;
                length = c0969aArr.length;
                while (i < length) {
                    Object o = m1469o(c0969aArr[i]);
                    if (o == aaF) {
                        return aaF;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (c0969a.fP.length != c0969a.fQ.length) {
                    bh.m1385w("Converting an invalid value to object: " + c0969a.toString());
                    return aaF;
                }
                Map hashMap = new HashMap(c0969a.fQ.length);
                while (i < c0969a.fP.length) {
                    Object o2 = m1469o(c0969a.fP[i]);
                    Object o3 = m1469o(c0969a.fQ[i]);
                    if (o2 == aaF || o3 == aaF) {
                        return aaF;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                bh.m1385w("Trying to convert a macro reference to object");
                return aaF;
            case 5:
                bh.m1385w("Trying to convert a function id to object");
                return aaF;
            case 6:
                return Long.valueOf(c0969a.fT);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                c0969aArr = c0969a.fV;
                length = c0969aArr.length;
                while (i < length) {
                    String j = m1461j(c0969aArr[i]);
                    if (j == aaJ) {
                        return aaF;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(c0969a.fU);
            default:
                bh.m1385w("Failed to convert a value of type: " + c0969a.type);
                return aaF;
        }
    }

    /* renamed from: p */
    public static Double m1470p(Object obj) {
        return m1473s(obj) ? Double.valueOf(getDouble(obj)) : ca(m1465m(obj));
    }

    /* renamed from: q */
    public static Boolean m1471q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : cb(m1465m(obj));
    }

    /* renamed from: r */
    public static C0969a m1472r(Object obj) {
        boolean z = false;
        C0969a c0969a = new C0969a();
        if (obj instanceof C0969a) {
            return (C0969a) obj;
        }
        if (obj instanceof String) {
            c0969a.type = 1;
            c0969a.fN = (String) obj;
        } else if (obj instanceof List) {
            c0969a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object r : list) {
                C0969a r2 = m1472r(r);
                if (r2 == aaN) {
                    return aaN;
                }
                r0 = r1 || r2.fX;
                r5.add(r2);
                r1 = r0;
            }
            c0969a.fO = (C0969a[]) r5.toArray(new C0969a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c0969a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C0969a r3 = m1472r(entry.getKey());
                C0969a r4 = m1472r(entry.getValue());
                if (r3 == aaN || r4 == aaN) {
                    return aaN;
                }
                r0 = r1 || r3.fX || r4.fX;
                r5.add(r3);
                arrayList.add(r4);
                r1 = r0;
            }
            c0969a.fP = (C0969a[]) r5.toArray(new C0969a[0]);
            c0969a.fQ = (C0969a[]) arrayList.toArray(new C0969a[0]);
            z = r1;
        } else if (m1473s(obj)) {
            c0969a.type = 1;
            c0969a.fN = obj.toString();
        } else if (m1474t(obj)) {
            c0969a.type = 6;
            c0969a.fT = m1475u(obj);
        } else if (obj instanceof Boolean) {
            c0969a.type = 8;
            c0969a.fU = ((Boolean) obj).booleanValue();
        } else {
            bh.m1385w("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return aaN;
        }
        c0969a.fX = z;
        return c0969a;
    }

    /* renamed from: s */
    private static boolean m1473s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dg) && ((dg) obj).lI());
    }

    /* renamed from: t */
    private static boolean m1474t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dg) && ((dg) obj).lJ());
    }

    /* renamed from: u */
    private static long m1475u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m1385w("getInt64 received non-Number");
        return 0;
    }
}
