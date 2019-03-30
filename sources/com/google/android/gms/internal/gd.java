package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0655a;
import java.util.ArrayList;
import java.util.HashMap;

public class gd implements SafeParcelable {
    public static final ge CREATOR = new ge();
    private final HashMap<String, HashMap<String, C0655a<?, ?>>> Ei;
    private final ArrayList<C0656a> Ej;
    private final String Ek;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.gd$a */
    public static class C0656a implements SafeParcelable {
        public static final gf CREATOR = new gf();
        final ArrayList<C0657b> El;
        final String className;
        final int versionCode;

        C0656a(int i, String str, ArrayList<C0657b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.El = arrayList;
        }

        C0656a(String str, HashMap<String, C0655a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.El = C0656a.m2228b(hashMap);
        }

        /* renamed from: b */
        private static ArrayList<C0657b> m2228b(HashMap<String, C0655a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0657b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0657b(str, (C0655a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            gf gfVar = CREATOR;
            return 0;
        }

        HashMap<String, C0655a<?, ?>> fp() {
            HashMap<String, C0655a<?, ?>> hashMap = new HashMap();
            int size = this.El.size();
            for (int i = 0; i < size; i++) {
                C0657b c0657b = (C0657b) this.El.get(i);
                hashMap.put(c0657b.eM, c0657b.Em);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            gf gfVar = CREATOR;
            gf.m1020a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.gd$b */
    public static class C0657b implements SafeParcelable {
        public static final gc CREATOR = new gc();
        final C0655a<?, ?> Em;
        final String eM;
        final int versionCode;

        C0657b(int i, String str, C0655a<?, ?> c0655a) {
            this.versionCode = i;
            this.eM = str;
            this.Em = c0655a;
        }

        C0657b(String str, C0655a<?, ?> c0655a) {
            this.versionCode = 1;
            this.eM = str;
            this.Em = c0655a;
        }

        public int describeContents() {
            gc gcVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            gc gcVar = CREATOR;
            gc.m1014a(this, out, flags);
        }
    }

    gd(int i, ArrayList<C0656a> arrayList, String str) {
        this.xH = i;
        this.Ej = null;
        this.Ei = m2229b((ArrayList) arrayList);
        this.Ek = (String) fq.m986f(str);
        fl();
    }

    public gd(Class<? extends ga> cls) {
        this.xH = 1;
        this.Ej = null;
        this.Ei = new HashMap();
        this.Ek = cls.getCanonicalName();
    }

    /* renamed from: b */
    private static HashMap<String, HashMap<String, C0655a<?, ?>>> m2229b(ArrayList<C0656a> arrayList) {
        HashMap<String, HashMap<String, C0655a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0656a c0656a = (C0656a) arrayList.get(i);
            hashMap.put(c0656a.className, c0656a.fp());
        }
        return hashMap;
    }

    /* renamed from: a */
    public void m2230a(Class<? extends ga> cls, HashMap<String, C0655a<?, ?>> hashMap) {
        this.Ei.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap<String, C0655a<?, ?>> au(String str) {
        return (HashMap) this.Ei.get(str);
    }

    /* renamed from: b */
    public boolean m2231b(Class<? extends ga> cls) {
        return this.Ei.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ge geVar = CREATOR;
        return 0;
    }

    public void fl() {
        for (String str : this.Ei.keySet()) {
            HashMap hashMap = (HashMap) this.Ei.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0655a) hashMap.get(str2)).m2226a(this);
            }
        }
    }

    public void fm() {
        for (String str : this.Ei.keySet()) {
            HashMap hashMap = (HashMap) this.Ei.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0655a) hashMap.get(str2)).fb());
            }
            this.Ei.put(str, hashMap2);
        }
    }

    ArrayList<C0656a> fn() {
        ArrayList<C0656a> arrayList = new ArrayList();
        for (String str : this.Ei.keySet()) {
            arrayList.add(new C0656a(str, (HashMap) this.Ei.get(str)));
        }
        return arrayList;
    }

    public String fo() {
        return this.Ek;
    }

    int getVersionCode() {
        return this.xH;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.Ei.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.Ei.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ge geVar = CREATOR;
        ge.m1017a(this, out, flags);
    }
}
