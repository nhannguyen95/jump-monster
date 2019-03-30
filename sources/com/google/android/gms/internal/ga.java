package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ga {

    /* renamed from: com.google.android.gms.internal.ga$b */
    public interface C0284b<I, O> {
        int eW();

        int eX();

        /* renamed from: g */
        I mo1766g(O o);
    }

    /* renamed from: com.google.android.gms.internal.ga$a */
    public static class C0655a<I, O> implements SafeParcelable {
        public static final gb CREATOR = new gb();
        protected final int DY;
        protected final boolean DZ;
        protected final int Ea;
        protected final boolean Eb;
        protected final String Ec;
        protected final int Ed;
        protected final Class<? extends ga> Ee;
        protected final String Ef;
        private gd Eg;
        private C0284b<I, O> Eh;
        private final int xH;

        C0655a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, fv fvVar) {
            this.xH = i;
            this.DY = i2;
            this.DZ = z;
            this.Ea = i3;
            this.Eb = z2;
            this.Ec = str;
            this.Ed = i4;
            if (str2 == null) {
                this.Ee = null;
                this.Ef = null;
            } else {
                this.Ee = gg.class;
                this.Ef = str2;
            }
            if (fvVar == null) {
                this.Eh = null;
            } else {
                this.Eh = fvVar.eU();
            }
        }

        protected C0655a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends ga> cls, C0284b<I, O> c0284b) {
            this.xH = 1;
            this.DY = i;
            this.DZ = z;
            this.Ea = i2;
            this.Eb = z2;
            this.Ec = str;
            this.Ed = i3;
            this.Ee = cls;
            if (cls == null) {
                this.Ef = null;
            } else {
                this.Ef = cls.getCanonicalName();
            }
            this.Eh = c0284b;
        }

        /* renamed from: a */
        public static C0655a m2217a(String str, int i, C0284b<?, ?> c0284b, boolean z) {
            return new C0655a(c0284b.eW(), z, c0284b.eX(), false, str, i, null, c0284b);
        }

        /* renamed from: a */
        public static <T extends ga> C0655a<T, T> m2218a(String str, int i, Class<T> cls) {
            return new C0655a(11, false, 11, false, str, i, cls, null);
        }

        /* renamed from: b */
        public static <T extends ga> C0655a<ArrayList<T>, ArrayList<T>> m2219b(String str, int i, Class<T> cls) {
            return new C0655a(11, true, 11, true, str, i, cls, null);
        }

        /* renamed from: g */
        public static C0655a<Integer, Integer> m2221g(String str, int i) {
            return new C0655a(0, false, 0, false, str, i, null, null);
        }

        /* renamed from: h */
        public static C0655a<Double, Double> m2222h(String str, int i) {
            return new C0655a(4, false, 4, false, str, i, null, null);
        }

        /* renamed from: i */
        public static C0655a<Boolean, Boolean> m2223i(String str, int i) {
            return new C0655a(6, false, 6, false, str, i, null, null);
        }

        /* renamed from: j */
        public static C0655a<String, String> m2224j(String str, int i) {
            return new C0655a(7, false, 7, false, str, i, null, null);
        }

        /* renamed from: k */
        public static C0655a<ArrayList<String>, ArrayList<String>> m2225k(String str, int i) {
            return new C0655a(7, true, 7, true, str, i, null, null);
        }

        /* renamed from: a */
        public void m2226a(gd gdVar) {
            this.Eg = gdVar;
        }

        public int describeContents() {
            gb gbVar = CREATOR;
            return 0;
        }

        public int eW() {
            return this.DY;
        }

        public int eX() {
            return this.Ea;
        }

        public C0655a<I, O> fb() {
            return new C0655a(this.xH, this.DY, this.DZ, this.Ea, this.Eb, this.Ec, this.Ed, this.Ef, fj());
        }

        public boolean fc() {
            return this.DZ;
        }

        public boolean fd() {
            return this.Eb;
        }

        public String fe() {
            return this.Ec;
        }

        public int ff() {
            return this.Ed;
        }

        public Class<? extends ga> fg() {
            return this.Ee;
        }

        String fh() {
            return this.Ef == null ? null : this.Ef;
        }

        public boolean fi() {
            return this.Eh != null;
        }

        fv fj() {
            return this.Eh == null ? null : fv.m2212a(this.Eh);
        }

        public HashMap<String, C0655a<?, ?>> fk() {
            fq.m986f(this.Ef);
            fq.m986f(this.Eg);
            return this.Eg.au(this.Ef);
        }

        /* renamed from: g */
        public I m2227g(O o) {
            return this.Eh.mo1766g(o);
        }

        public int getVersionCode() {
            return this.xH;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.xH).append('\n');
            stringBuilder.append("                 typeIn=").append(this.DY).append('\n');
            stringBuilder.append("            typeInArray=").append(this.DZ).append('\n');
            stringBuilder.append("                typeOut=").append(this.Ea).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.Eb).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.Ec).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Ed).append('\n');
            stringBuilder.append("       concreteTypeName=").append(fh()).append('\n');
            if (fg() != null) {
                stringBuilder.append("     concreteType.class=").append(fg().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.Eh == null ? "null" : this.Eh.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            gb gbVar = CREATOR;
            gb.m1011a(this, out, flags);
        }
    }

    /* renamed from: a */
    private void m1006a(StringBuilder stringBuilder, C0655a c0655a, Object obj) {
        if (c0655a.eW() == 11) {
            stringBuilder.append(((ga) c0655a.fg().cast(obj)).toString());
        } else if (c0655a.eW() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(gp.av((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    /* renamed from: a */
    private void m1007a(StringBuilder stringBuilder, C0655a c0655a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m1006a(stringBuilder, c0655a, obj);
            }
        }
        stringBuilder.append("]");
    }

    /* renamed from: a */
    protected <O, I> I m1008a(C0655a<I, O> c0655a, Object obj) {
        return c0655a.Eh != null ? c0655a.m2227g(obj) : obj;
    }

    /* renamed from: a */
    protected boolean mo2914a(C0655a c0655a) {
        return c0655a.eX() == 11 ? c0655a.fd() ? at(c0655a.fe()) : as(c0655a.fe()) : ar(c0655a.fe());
    }

    protected abstract Object aq(String str);

    protected abstract boolean ar(String str);

    protected boolean as(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean at(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* renamed from: b */
    protected Object mo2915b(C0655a c0655a) {
        boolean z = true;
        String fe = c0655a.fe();
        if (c0655a.fg() == null) {
            return aq(c0655a.fe());
        }
        if (aq(c0655a.fe()) != null) {
            z = false;
        }
        fq.m981a(z, "Concrete field shouldn't be value object: " + c0655a.fe());
        Map fa = c0655a.fd() ? fa() : eZ();
        if (fa != null) {
            return fa.get(fe);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(fe.charAt(0)) + fe.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, C0655a<?, ?>> eY();

    public HashMap<String, Object> eZ() {
        return null;
    }

    public HashMap<String, Object> fa() {
        return null;
    }

    public String toString() {
        HashMap eY = eY();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : eY.keySet()) {
            C0655a c0655a = (C0655a) eY.get(str);
            if (mo2914a(c0655a)) {
                Object a = m1008a(c0655a, mo2915b(c0655a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c0655a.eX()) {
                        case 8:
                            stringBuilder.append("\"").append(gj.m1033d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(gj.m1034e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            gq.m1038a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c0655a.fc()) {
                                m1006a(stringBuilder, c0655a, a);
                                break;
                            }
                            m1007a(stringBuilder, c0655a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
