package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0145a;
import com.google.android.gms.common.internal.safeparcel.C0145a.C0144a;
import com.google.android.gms.common.internal.safeparcel.C0146b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0655a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class gg extends ga implements SafeParcelable {
    public static final gh CREATOR = new gh();
    private final gd Eg;
    private final Parcel En;
    private final int Eo;
    private int Ep;
    private int Eq;
    private final String mClassName;
    private final int xH;

    gg(int i, Parcel parcel, gd gdVar) {
        this.xH = i;
        this.En = (Parcel) fq.m986f(parcel);
        this.Eo = 2;
        this.Eg = gdVar;
        if (this.Eg == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.Eg.fo();
        }
        this.Ep = 2;
    }

    private gg(SafeParcelable safeParcelable, gd gdVar, String str) {
        this.xH = 1;
        this.En = Parcel.obtain();
        safeParcelable.writeToParcel(this.En, 0);
        this.Eo = 1;
        this.Eg = (gd) fq.m986f(gdVar);
        this.mClassName = (String) fq.m986f(str);
        this.Ep = 2;
    }

    /* renamed from: a */
    public static <T extends ga & SafeParcelable> gg m2232a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new gg((SafeParcelable) t, m2238b(t), canonicalName);
    }

    /* renamed from: a */
    private static void m2233a(gd gdVar, ga gaVar) {
        Class cls = gaVar.getClass();
        if (!gdVar.m2231b(cls)) {
            HashMap eY = gaVar.eY();
            gdVar.m2230a(cls, gaVar.eY());
            for (String str : eY.keySet()) {
                C0655a c0655a = (C0655a) eY.get(str);
                Class fg = c0655a.fg();
                if (fg != null) {
                    try {
                        m2233a(gdVar, (ga) fg.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0655a.fg().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0655a.fg().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m2234a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(gp.av(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(gj.m1033d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(gj.m1034e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                gq.m1038a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m2235a(StringBuilder stringBuilder, C0655a<?, ?> c0655a, Parcel parcel, int i) {
        switch (c0655a.eX()) {
            case 0:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, Integer.valueOf(C0145a.m188g(parcel, i))));
                return;
            case 1:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, C0145a.m191j(parcel, i)));
                return;
            case 2:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, Long.valueOf(C0145a.m190i(parcel, i))));
                return;
            case 3:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, Float.valueOf(C0145a.m192k(parcel, i))));
                return;
            case 4:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, Double.valueOf(C0145a.m193l(parcel, i))));
                return;
            case 5:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, C0145a.m194m(parcel, i)));
                return;
            case 6:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, Boolean.valueOf(C0145a.m184c(parcel, i))));
                return;
            case 7:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, C0145a.m196n(parcel, i)));
                return;
            case 8:
            case 9:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, C0145a.m200q(parcel, i)));
                return;
            case 10:
                m2240b(stringBuilder, (C0655a) c0655a, m1008a(c0655a, m2242c(C0145a.m199p(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0655a.eX());
        }
    }

    /* renamed from: a */
    private void m2236a(StringBuilder stringBuilder, String str, C0655a<?, ?> c0655a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0655a.fi()) {
            m2235a(stringBuilder, c0655a, parcel, i);
        } else {
            m2239b(stringBuilder, c0655a, parcel, i);
        }
    }

    /* renamed from: a */
    private void m2237a(StringBuilder stringBuilder, HashMap<String, C0655a<?, ?>> hashMap, Parcel parcel) {
        HashMap c = m2243c((HashMap) hashMap);
        stringBuilder.append('{');
        int o = C0145a.m197o(parcel);
        Object obj = null;
        while (parcel.dataPosition() < o) {
            int n = C0145a.m195n(parcel);
            Entry entry = (Entry) c.get(Integer.valueOf(C0145a.m175R(n)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m2236a(stringBuilder, (String) entry.getKey(), (C0655a) entry.getValue(), parcel, n);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0144a("Overread allowed size end=" + o, parcel);
        }
        stringBuilder.append('}');
    }

    /* renamed from: b */
    private static gd m2238b(ga gaVar) {
        gd gdVar = new gd(gaVar.getClass());
        m2233a(gdVar, gaVar);
        gdVar.fm();
        gdVar.fl();
        return gdVar;
    }

    /* renamed from: b */
    private void m2239b(StringBuilder stringBuilder, C0655a<?, ?> c0655a, Parcel parcel, int i) {
        if (c0655a.fd()) {
            stringBuilder.append("[");
            switch (c0655a.eX()) {
                case 0:
                    gi.m1028a(stringBuilder, C0145a.m203t(parcel, i));
                    break;
                case 1:
                    gi.m1030a(stringBuilder, C0145a.m205v(parcel, i));
                    break;
                case 2:
                    gi.m1029a(stringBuilder, C0145a.m204u(parcel, i));
                    break;
                case 3:
                    gi.m1027a(stringBuilder, C0145a.m206w(parcel, i));
                    break;
                case 4:
                    gi.m1026a(stringBuilder, C0145a.m207x(parcel, i));
                    break;
                case 5:
                    gi.m1030a(stringBuilder, C0145a.m208y(parcel, i));
                    break;
                case 6:
                    gi.m1032a(stringBuilder, C0145a.m202s(parcel, i));
                    break;
                case 7:
                    gi.m1031a(stringBuilder, C0145a.m209z(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] C = C0145a.m174C(parcel, i);
                    int length = C.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        C[i2].setDataPosition(0);
                        m2237a(stringBuilder, c0655a.fk(), C[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0655a.eX()) {
            case 0:
                stringBuilder.append(C0145a.m188g(parcel, i));
                return;
            case 1:
                stringBuilder.append(C0145a.m191j(parcel, i));
                return;
            case 2:
                stringBuilder.append(C0145a.m190i(parcel, i));
                return;
            case 3:
                stringBuilder.append(C0145a.m192k(parcel, i));
                return;
            case 4:
                stringBuilder.append(C0145a.m193l(parcel, i));
                return;
            case 5:
                stringBuilder.append(C0145a.m194m(parcel, i));
                return;
            case 6:
                stringBuilder.append(C0145a.m184c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(gp.av(C0145a.m196n(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(gj.m1033d(C0145a.m200q(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(gj.m1034e(C0145a.m200q(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle p = C0145a.m199p(parcel, i);
                Set<String> keySet = p.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(gp.av(p.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel B = C0145a.m173B(parcel, i);
                B.setDataPosition(0);
                m2237a(stringBuilder, c0655a.fk(), B);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m2240b(StringBuilder stringBuilder, C0655a<?, ?> c0655a, Object obj) {
        if (c0655a.fc()) {
            m2241b(stringBuilder, (C0655a) c0655a, (ArrayList) obj);
        } else {
            m2234a(stringBuilder, c0655a.eW(), obj);
        }
    }

    /* renamed from: b */
    private void m2241b(StringBuilder stringBuilder, C0655a<?, ?> c0655a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m2234a(stringBuilder, c0655a.eW(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    /* renamed from: c */
    public static HashMap<String, String> m2242c(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* renamed from: c */
    private static HashMap<Integer, Entry<String, C0655a<?, ?>>> m2243c(HashMap<String, C0655a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0655a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0655a) entry.getValue()).ff()), entry);
        }
        return hashMap2;
    }

    protected Object aq(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean ar(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        gh ghVar = CREATOR;
        return 0;
    }

    public HashMap<String, C0655a<?, ?>> eY() {
        return this.Eg == null ? null : this.Eg.au(this.mClassName);
    }

    public Parcel fq() {
        switch (this.Ep) {
            case 0:
                this.Eq = C0146b.m237p(this.En);
                C0146b.m212F(this.En, this.Eq);
                this.Ep = 2;
                break;
            case 1:
                C0146b.m212F(this.En, this.Eq);
                this.Ep = 2;
                break;
        }
        return this.En;
    }

    gd fr() {
        switch (this.Eo) {
            case 0:
                return null;
            case 1:
                return this.Eg;
            case 2:
                return this.Eg;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Eo);
        }
    }

    public int getVersionCode() {
        return this.xH;
    }

    public String toString() {
        fq.m983b(this.Eg, (Object) "Cannot convert to JSON on client side.");
        Parcel fq = fq();
        fq.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m2237a(stringBuilder, this.Eg.au(this.mClassName), fq);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        gh ghVar = CREATOR;
        gh.m1023a(this, out, flags);
    }
}
