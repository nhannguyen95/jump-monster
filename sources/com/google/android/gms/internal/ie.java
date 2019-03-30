package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C0655a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class ie extends ga implements SafeParcelable, Moment {
    public static final C0288if CREATOR = new C0288if();
    private static final HashMap<String, C0655a<?, ?>> UI = new HashMap();
    private String Rd;
    private final Set<Integer> UJ;
    private ic VE;
    private ic VF;
    private String Vw;
    private String wp;
    private final int xH;

    static {
        UI.put("id", C0655a.m2224j("id", 2));
        UI.put("result", C0655a.m2218a("result", 4, ic.class));
        UI.put("startDate", C0655a.m2224j("startDate", 5));
        UI.put("target", C0655a.m2218a("target", 6, ic.class));
        UI.put("type", C0655a.m2224j("type", 7));
    }

    public ie() {
        this.xH = 1;
        this.UJ = new HashSet();
    }

    ie(Set<Integer> set, int i, String str, ic icVar, String str2, ic icVar2, String str3) {
        this.UJ = set;
        this.xH = i;
        this.wp = str;
        this.VE = icVar;
        this.Vw = str2;
        this.VF = icVar2;
        this.Rd = str3;
    }

    public ie(Set<Integer> set, String str, ic icVar, String str2, ic icVar2, String str3) {
        this.UJ = set;
        this.xH = 1;
        this.wp = str;
        this.VE = icVar;
        this.Vw = str2;
        this.VF = icVar2;
        this.Rd = str3;
    }

    /* renamed from: a */
    protected boolean mo2914a(C0655a c0655a) {
        return this.UJ.contains(Integer.valueOf(c0655a.ff()));
    }

    protected Object aq(String str) {
        return null;
    }

    protected boolean ar(String str) {
        return false;
    }

    /* renamed from: b */
    protected Object mo2915b(C0655a c0655a) {
        switch (c0655a.ff()) {
            case 2:
                return this.wp;
            case 4:
                return this.VE;
            case 5:
                return this.Vw;
            case 6:
                return this.VF;
            case 7:
                return this.Rd;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0655a.ff());
        }
    }

    public int describeContents() {
        C0288if c0288if = CREATOR;
        return 0;
    }

    public HashMap<String, C0655a<?, ?>> eY() {
        return UI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ie)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ie ieVar = (ie) obj;
        for (C0655a c0655a : UI.values()) {
            if (mo2914a(c0655a)) {
                if (!ieVar.mo2914a(c0655a)) {
                    return false;
                }
                if (!mo2915b(c0655a).equals(ieVar.mo2915b(c0655a))) {
                    return false;
                }
            } else if (ieVar.mo2914a(c0655a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return jt();
    }

    public String getId() {
        return this.wp;
    }

    public ItemScope getResult() {
        return this.VE;
    }

    public String getStartDate() {
        return this.Vw;
    }

    public ItemScope getTarget() {
        return this.VF;
    }

    public String getType() {
        return this.Rd;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0655a c0655a : UI.values()) {
            int hashCode;
            if (mo2914a(c0655a)) {
                hashCode = mo2915b(c0655a).hashCode() + (i + c0655a.ff());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    Set<Integer> ja() {
        return this.UJ;
    }

    ic jr() {
        return this.VE;
    }

    ic js() {
        return this.VF;
    }

    public ie jt() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0288if c0288if = CREATOR;
        C0288if.m1079a(this, out, flags);
    }
}
