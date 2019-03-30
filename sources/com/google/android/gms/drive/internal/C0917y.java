package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.kn;
import com.google.android.gms.internal.ko;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.ks;
import com.google.android.gms.internal.kt;
import java.io.IOException;

/* renamed from: com.google.android.gms.drive.internal.y */
public final class C0917y extends kp<C0917y> {
    public String FC;
    public long FD;
    public long FE;
    public int versionCode;

    public C0917y() {
        fH();
    }

    /* renamed from: g */
    public static C0917y m2657g(byte[] bArr) throws ks {
        return (C0917y) kt.m1167a(new C0917y(), bArr);
    }

    /* renamed from: a */
    public void mo1865a(ko koVar) throws IOException {
        koVar.m1158i(1, this.versionCode);
        koVar.m1153b(2, this.FC);
        koVar.m1155c(3, this.FD);
        koVar.m1155c(4, this.FE);
        super.mo1865a(koVar);
    }

    /* renamed from: b */
    public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
        return m2661m(knVar);
    }

    /* renamed from: c */
    public int mo2700c() {
        int c = (((super.mo2700c() + ko.m1144j(1, this.versionCode)) + ko.m1143g(2, this.FC)) + ko.m1142e(3, this.FD)) + ko.m1142e(4, this.FE);
        this.adY = c;
        return c;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C0917y)) {
            return false;
        }
        C0917y c0917y = (C0917y) o;
        if (this.versionCode != c0917y.versionCode) {
            return false;
        }
        if (this.FC == null) {
            if (c0917y.FC != null) {
                return false;
            }
        } else if (!this.FC.equals(c0917y.FC)) {
            return false;
        }
        if (this.FD != c0917y.FD || this.FE != c0917y.FE) {
            return false;
        }
        if (this.adU == null || this.adU.isEmpty()) {
            return c0917y.adU == null || c0917y.adU.isEmpty();
        } else {
            return this.adU.equals(c0917y.adU);
        }
    }

    public C0917y fH() {
        this.versionCode = 1;
        this.FC = "";
        this.FD = -1;
        this.FE = -1;
        this.adU = null;
        this.adY = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.FC == null ? 0 : this.FC.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.FD ^ (this.FD >>> 32)))) * 31) + ((int) (this.FE ^ (this.FE >>> 32)))) * 31;
        if (!(this.adU == null || this.adU.isEmpty())) {
            i = this.adU.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: m */
    public C0917y m2661m(kn knVar) throws IOException {
        while (true) {
            int mh = knVar.mh();
            switch (mh) {
                case 0:
                    break;
                case 8:
                    this.versionCode = knVar.mk();
                    continue;
                case 18:
                    this.FC = knVar.readString();
                    continue;
                case 24:
                    this.FD = knVar.mm();
                    continue;
                case 32:
                    this.FE = knVar.mm();
                    continue;
                default:
                    if (!m2319a(knVar, mh)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
