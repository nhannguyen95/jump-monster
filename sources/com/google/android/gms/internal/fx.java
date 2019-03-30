package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0284b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class fx implements SafeParcelable, C0284b<String, Integer> {
    public static final fy CREATOR = new fy();
    private final HashMap<String, Integer> DT;
    private final HashMap<Integer, String> DU;
    private final ArrayList<C0654a> DV;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.fx$a */
    public static final class C0654a implements SafeParcelable {
        public static final fz CREATOR = new fz();
        final String DW;
        final int DX;
        final int versionCode;

        C0654a(int i, String str, int i2) {
            this.versionCode = i;
            this.DW = str;
            this.DX = i2;
        }

        C0654a(String str, int i) {
            this.versionCode = 1;
            this.DW = str;
            this.DX = i;
        }

        public int describeContents() {
            fz fzVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fz fzVar = CREATOR;
            fz.m1002a(this, out, flags);
        }
    }

    public fx() {
        this.xH = 1;
        this.DT = new HashMap();
        this.DU = new HashMap();
        this.DV = null;
    }

    fx(int i, ArrayList<C0654a> arrayList) {
        this.xH = i;
        this.DT = new HashMap();
        this.DU = new HashMap();
        this.DV = null;
        m2213a((ArrayList) arrayList);
    }

    /* renamed from: a */
    private void m2213a(ArrayList<C0654a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0654a c0654a = (C0654a) it.next();
            m2215f(c0654a.DW, c0654a.DX);
        }
    }

    /* renamed from: a */
    public String m2214a(Integer num) {
        String str = (String) this.DU.get(num);
        return (str == null && this.DT.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        fy fyVar = CREATOR;
        return 0;
    }

    ArrayList<C0654a> eV() {
        ArrayList<C0654a> arrayList = new ArrayList();
        for (String str : this.DT.keySet()) {
            arrayList.add(new C0654a(str, ((Integer) this.DT.get(str)).intValue()));
        }
        return arrayList;
    }

    public int eW() {
        return 7;
    }

    public int eX() {
        return 0;
    }

    /* renamed from: f */
    public fx m2215f(String str, int i) {
        this.DT.put(str, Integer.valueOf(i));
        this.DU.put(Integer.valueOf(i), str);
        return this;
    }

    /* renamed from: g */
    public /* synthetic */ Object mo1766g(Object obj) {
        return m2214a((Integer) obj);
    }

    int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel out, int flags) {
        fy fyVar = CREATOR;
        fy.m999a(this, out, flags);
    }
}
