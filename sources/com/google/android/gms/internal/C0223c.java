package com.google.android.gms.internal;

import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.internal.C0239d.C0969a;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0223c {

    /* renamed from: com.google.android.gms.internal.c$a */
    public static final class C0957a extends kp<C0957a> {
        public int eE;
        public int eF;
        public int level;

        public C0957a() {
            m2912b();
        }

        /* renamed from: a */
        public C0957a m2910a(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        mh = knVar.mk();
                        switch (mh) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = mh;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.eE = knVar.mk();
                        continue;
                    case 24:
                        this.eF = knVar.mk();
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

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            if (this.level != 1) {
                koVar.m1158i(1, this.level);
            }
            if (this.eE != 0) {
                koVar.m1158i(2, this.eE);
            }
            if (this.eF != 0) {
                koVar.m1158i(3, this.eF);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public C0957a m2912b() {
            this.level = 1;
            this.eE = 0;
            this.eF = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2910a(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = super.mo2700c();
            if (this.level != 1) {
                c += ko.m1144j(1, this.level);
            }
            if (this.eE != 0) {
                c += ko.m1144j(2, this.eE);
            }
            if (this.eF != 0) {
                c += ko.m1144j(3, this.eF);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0957a)) {
                return false;
            }
            C0957a c0957a = (C0957a) o;
            if (this.level != c0957a.level || this.eE != c0957a.eE || this.eF != c0957a.eF) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0957a.adU == null || c0957a.adU.isEmpty();
            } else {
                return this.adU.equals(c0957a.adU);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eE) * 31) + this.eF) * 31;
            int hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$b */
    public static final class C0958b extends kp<C0958b> {
        private static volatile C0958b[] eG;
        public int[] eH;
        public int eI;
        public boolean eJ;
        public boolean eK;
        public int name;

        public C0958b() {
            m2920e();
        }

        /* renamed from: d */
        public static C0958b[] m2915d() {
            if (eG == null) {
                synchronized (kr.adX) {
                    if (eG == null) {
                        eG = new C0958b[0];
                    }
                }
            }
            return eG;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            if (this.eK) {
                koVar.m1149a(1, this.eK);
            }
            koVar.m1158i(2, this.eI);
            if (this.eH != null && this.eH.length > 0) {
                for (int i : this.eH) {
                    koVar.m1158i(3, i);
                }
            }
            if (this.name != 0) {
                koVar.m1158i(4, this.name);
            }
            if (this.eJ) {
                koVar.m1149a(6, this.eJ);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2919c(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i = 0;
            int c = super.mo2700c();
            if (this.eK) {
                c += ko.m1136b(1, this.eK);
            }
            int j = ko.m1144j(2, this.eI) + c;
            if (this.eH == null || this.eH.length <= 0) {
                c = j;
            } else {
                for (int cX : this.eH) {
                    i += ko.cX(cX);
                }
                c = (j + i) + (this.eH.length * 1);
            }
            if (this.name != 0) {
                c += ko.m1144j(4, this.name);
            }
            if (this.eJ) {
                c += ko.m1136b(6, this.eJ);
            }
            this.adY = c;
            return c;
        }

        /* renamed from: c */
        public C0958b m2919c(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        this.eK = knVar.ml();
                        continue;
                    case 16:
                        this.eI = knVar.mk();
                        continue;
                    case 24:
                        b = kw.m1177b(knVar, 24);
                        mh = this.eH == null ? 0 : this.eH.length;
                        Object obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eH, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.eH = obj;
                        continue;
                    case Keys.POWER /*26*/:
                        int cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.eH == null ? 0 : this.eH.length;
                        Object obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.eH, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.eH = obj2;
                        knVar.cS(cR);
                        continue;
                    case 32:
                        this.name = knVar.mk();
                        continue;
                    case Keys.f24T /*48*/:
                        this.eJ = knVar.ml();
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

        /* renamed from: e */
        public C0958b m2920e() {
            this.eH = kw.aea;
            this.eI = 0;
            this.name = 0;
            this.eJ = false;
            this.eK = false;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0958b)) {
                return false;
            }
            C0958b c0958b = (C0958b) o;
            if (!kr.equals(this.eH, c0958b.eH) || this.eI != c0958b.eI || this.name != c0958b.name || this.eJ != c0958b.eJ || this.eK != c0958b.eK) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0958b.adU == null || c0958b.adU.isEmpty();
            } else {
                return this.adU.equals(c0958b.adU);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eJ ? 1231 : 1237) + ((((((kr.hashCode(this.eH) + 527) * 31) + this.eI) * 31) + this.name) * 31)) * 31;
            if (!this.eK) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$c */
    public static final class C0959c extends kp<C0959c> {
        private static volatile C0959c[] eL;
        public String eM;
        public long eN;
        public long eO;
        public boolean eP;
        public long eQ;

        public C0959c() {
            m2926g();
        }

        /* renamed from: f */
        public static C0959c[] m2921f() {
            if (eL == null) {
                synchronized (kr.adX) {
                    if (eL == null) {
                        eL = new C0959c[0];
                    }
                }
            }
            return eL;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            if (!this.eM.equals("")) {
                koVar.m1153b(1, this.eM);
            }
            if (this.eN != 0) {
                koVar.m1152b(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                koVar.m1152b(3, this.eO);
            }
            if (this.eP) {
                koVar.m1149a(4, this.eP);
            }
            if (this.eQ != 0) {
                koVar.m1152b(5, this.eQ);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2925d(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = super.mo2700c();
            if (!this.eM.equals("")) {
                c += ko.m1143g(1, this.eM);
            }
            if (this.eN != 0) {
                c += ko.m1140d(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                c += ko.m1140d(3, this.eO);
            }
            if (this.eP) {
                c += ko.m1136b(4, this.eP);
            }
            if (this.eQ != 0) {
                c += ko.m1140d(5, this.eQ);
            }
            this.adY = c;
            return c;
        }

        /* renamed from: d */
        public C0959c m2925d(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 10:
                        this.eM = knVar.readString();
                        continue;
                    case 16:
                        this.eN = knVar.mj();
                        continue;
                    case 24:
                        this.eO = knVar.mj();
                        continue;
                    case 32:
                        this.eP = knVar.ml();
                        continue;
                    case Keys.f16L /*40*/:
                        this.eQ = knVar.mj();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0959c)) {
                return false;
            }
            C0959c c0959c = (C0959c) o;
            if (this.eM == null) {
                if (c0959c.eM != null) {
                    return false;
                }
            } else if (!this.eM.equals(c0959c.eM)) {
                return false;
            }
            if (this.eN != c0959c.eN || this.eO != c0959c.eO || this.eP != c0959c.eP || this.eQ != c0959c.eQ) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0959c.adU == null || c0959c.adU.isEmpty();
            } else {
                return this.adU.equals(c0959c.adU);
            }
        }

        /* renamed from: g */
        public C0959c m2926g() {
            this.eM = "";
            this.eN = 0;
            this.eO = 2147483647L;
            this.eP = false;
            this.eQ = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.eP ? 1231 : 1237) + (((((((this.eM == null ? 0 : this.eM.hashCode()) + 527) * 31) + ((int) (this.eN ^ (this.eN >>> 32)))) * 31) + ((int) (this.eO ^ (this.eO >>> 32)))) * 31)) * 31) + ((int) (this.eQ ^ (this.eQ >>> 32)))) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$d */
    public static final class C0960d extends kp<C0960d> {
        public C0969a[] eR;
        public C0969a[] eS;
        public C0959c[] eT;

        public C0960d() {
            m2931h();
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            int i = 0;
            if (this.eR != null && this.eR.length > 0) {
                for (kt ktVar : this.eR) {
                    if (ktVar != null) {
                        koVar.m1148a(1, ktVar);
                    }
                }
            }
            if (this.eS != null && this.eS.length > 0) {
                for (kt ktVar2 : this.eS) {
                    if (ktVar2 != null) {
                        koVar.m1148a(2, ktVar2);
                    }
                }
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i < this.eT.length) {
                    kt ktVar3 = this.eT[i];
                    if (ktVar3 != null) {
                        koVar.m1148a(3, ktVar3);
                    }
                    i++;
                }
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2930e(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i;
            int i2 = 0;
            int c = super.mo2700c();
            if (this.eR != null && this.eR.length > 0) {
                i = c;
                for (kt ktVar : this.eR) {
                    if (ktVar != null) {
                        i += ko.m1135b(1, ktVar);
                    }
                }
                c = i;
            }
            if (this.eS != null && this.eS.length > 0) {
                i = c;
                for (kt ktVar2 : this.eS) {
                    if (ktVar2 != null) {
                        i += ko.m1135b(2, ktVar2);
                    }
                }
                c = i;
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i2 < this.eT.length) {
                    kt ktVar3 = this.eT[i2];
                    if (ktVar3 != null) {
                        c += ko.m1135b(3, ktVar3);
                    }
                    i2++;
                }
            }
            this.adY = c;
            return c;
        }

        /* renamed from: e */
        public C0960d m2930e(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                switch (mh) {
                    case 0:
                        break;
                    case 10:
                        b = kw.m1177b(knVar, 10);
                        mh = this.eR == null ? 0 : this.eR.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eR, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.eR = obj;
                        continue;
                    case 18:
                        b = kw.m1177b(knVar, 18);
                        mh = this.eS == null ? 0 : this.eS.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.eS = obj;
                        continue;
                    case Keys.POWER /*26*/:
                        b = kw.m1177b(knVar, 26);
                        mh = this.eT == null ? 0 : this.eT.length;
                        obj = new C0959c[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eT, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0959c();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0959c();
                        knVar.m1127a(obj[mh]);
                        this.eT = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0960d)) {
                return false;
            }
            C0960d c0960d = (C0960d) o;
            if (!kr.equals(this.eR, c0960d.eR) || !kr.equals(this.eS, c0960d.eS) || !kr.equals(this.eT, c0960d.eT)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0960d.adU == null || c0960d.adU.isEmpty();
            } else {
                return this.adU.equals(c0960d.adU);
            }
        }

        /* renamed from: h */
        public C0960d m2931h() {
            this.eR = C0969a.m2982r();
            this.eS = C0969a.m2982r();
            this.eT = C0959c.m2921f();
            this.adU = null;
            this.adY = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((kr.hashCode(this.eR) + 527) * 31) + kr.hashCode(this.eS)) * 31) + kr.hashCode(this.eT)) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$e */
    public static final class C0961e extends kp<C0961e> {
        private static volatile C0961e[] eU;
        public int key;
        public int value;

        public C0961e() {
            m2937j();
        }

        /* renamed from: i */
        public static C0961e[] m2932i() {
            if (eU == null) {
                synchronized (kr.adX) {
                    if (eU == null) {
                        eU = new C0961e[0];
                    }
                }
            }
            return eU;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            koVar.m1158i(1, this.key);
            koVar.m1158i(2, this.value);
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2936f(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = (super.mo2700c() + ko.m1144j(1, this.key)) + ko.m1144j(2, this.value);
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0961e)) {
                return false;
            }
            C0961e c0961e = (C0961e) o;
            if (this.key != c0961e.key || this.value != c0961e.value) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0961e.adU == null || c0961e.adU.isEmpty();
            } else {
                return this.adU.equals(c0961e.adU);
            }
        }

        /* renamed from: f */
        public C0961e m2936f(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        this.key = knVar.mk();
                        continue;
                    case 16:
                        this.value = knVar.mk();
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

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode + i;
        }

        /* renamed from: j */
        public C0961e m2937j() {
            this.key = 0;
            this.value = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$f */
    public static final class C0962f extends kp<C0962f> {
        public String[] eV;
        public String[] eW;
        public C0969a[] eX;
        public C0961e[] eY;
        public C0958b[] eZ;
        public C0958b[] fa;
        public C0958b[] fb;
        public C0963g[] fc;
        public String fd;
        public String fe;
        public String ff;
        public String fg;
        public C0957a fh;
        public float fi;
        public boolean fj;
        public String[] fk;
        public int fl;

        public C0962f() {
            m2943k();
        }

        /* renamed from: a */
        public static C0962f m2938a(byte[] bArr) throws ks {
            return (C0962f) kt.m1167a(new C0962f(), bArr);
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            int i = 0;
            if (this.eW != null && this.eW.length > 0) {
                for (String str : this.eW) {
                    if (str != null) {
                        koVar.m1153b(1, str);
                    }
                }
            }
            if (this.eX != null && this.eX.length > 0) {
                for (kt ktVar : this.eX) {
                    if (ktVar != null) {
                        koVar.m1148a(2, ktVar);
                    }
                }
            }
            if (this.eY != null && this.eY.length > 0) {
                for (kt ktVar2 : this.eY) {
                    if (ktVar2 != null) {
                        koVar.m1148a(3, ktVar2);
                    }
                }
            }
            if (this.eZ != null && this.eZ.length > 0) {
                for (kt ktVar22 : this.eZ) {
                    if (ktVar22 != null) {
                        koVar.m1148a(4, ktVar22);
                    }
                }
            }
            if (this.fa != null && this.fa.length > 0) {
                for (kt ktVar222 : this.fa) {
                    if (ktVar222 != null) {
                        koVar.m1148a(5, ktVar222);
                    }
                }
            }
            if (this.fb != null && this.fb.length > 0) {
                for (kt ktVar2222 : this.fb) {
                    if (ktVar2222 != null) {
                        koVar.m1148a(6, ktVar2222);
                    }
                }
            }
            if (this.fc != null && this.fc.length > 0) {
                for (kt ktVar22222 : this.fc) {
                    if (ktVar22222 != null) {
                        koVar.m1148a(7, ktVar22222);
                    }
                }
            }
            if (!this.fd.equals("")) {
                koVar.m1153b(9, this.fd);
            }
            if (!this.fe.equals("")) {
                koVar.m1153b(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                koVar.m1153b(12, this.ff);
            }
            if (!this.fg.equals("")) {
                koVar.m1153b(13, this.fg);
            }
            if (this.fh != null) {
                koVar.m1148a(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                koVar.m1151b(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        koVar.m1153b(16, str2);
                    }
                }
            }
            if (this.fl != 0) {
                koVar.m1158i(17, this.fl);
            }
            if (this.fj) {
                koVar.m1149a(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                while (i < this.eV.length) {
                    String str3 = this.eV[i];
                    if (str3 != null) {
                        koVar.m1153b(19, str3);
                    }
                    i++;
                }
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2942g(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.mo2700c();
            if (this.eW == null || this.eW.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.eW) {
                    if (str != null) {
                        i3++;
                        i2 += ko.cf(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.eX != null && this.eX.length > 0) {
                i2 = i;
                for (kt ktVar : this.eX) {
                    if (ktVar != null) {
                        i2 += ko.m1135b(2, ktVar);
                    }
                }
                i = i2;
            }
            if (this.eY != null && this.eY.length > 0) {
                i2 = i;
                for (kt ktVar2 : this.eY) {
                    if (ktVar2 != null) {
                        i2 += ko.m1135b(3, ktVar2);
                    }
                }
                i = i2;
            }
            if (this.eZ != null && this.eZ.length > 0) {
                i2 = i;
                for (kt ktVar22 : this.eZ) {
                    if (ktVar22 != null) {
                        i2 += ko.m1135b(4, ktVar22);
                    }
                }
                i = i2;
            }
            if (this.fa != null && this.fa.length > 0) {
                i2 = i;
                for (kt ktVar222 : this.fa) {
                    if (ktVar222 != null) {
                        i2 += ko.m1135b(5, ktVar222);
                    }
                }
                i = i2;
            }
            if (this.fb != null && this.fb.length > 0) {
                i2 = i;
                for (kt ktVar2222 : this.fb) {
                    if (ktVar2222 != null) {
                        i2 += ko.m1135b(6, ktVar2222);
                    }
                }
                i = i2;
            }
            if (this.fc != null && this.fc.length > 0) {
                i2 = i;
                for (kt ktVar22222 : this.fc) {
                    if (ktVar22222 != null) {
                        i2 += ko.m1135b(7, ktVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fd.equals("")) {
                i += ko.m1143g(9, this.fd);
            }
            if (!this.fe.equals("")) {
                i += ko.m1143g(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                i += ko.m1143g(12, this.ff);
            }
            if (!this.fg.equals("")) {
                i += ko.m1143g(13, this.fg);
            }
            if (this.fh != null) {
                i += ko.m1135b(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                i += ko.m1138c(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        c++;
                        i3 += ko.cf(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fl != 0) {
                i += ko.m1144j(17, this.fl);
            }
            if (this.fj) {
                i += ko.m1136b(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                i2 = 0;
                i3 = 0;
                while (i4 < this.eV.length) {
                    String str3 = this.eV[i4];
                    if (str3 != null) {
                        i3++;
                        i2 += ko.cf(str3);
                    }
                    i4++;
                }
                i = (i + i2) + (i3 * 2);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0962f)) {
                return false;
            }
            C0962f c0962f = (C0962f) o;
            if (!kr.equals(this.eV, c0962f.eV) || !kr.equals(this.eW, c0962f.eW) || !kr.equals(this.eX, c0962f.eX) || !kr.equals(this.eY, c0962f.eY) || !kr.equals(this.eZ, c0962f.eZ) || !kr.equals(this.fa, c0962f.fa) || !kr.equals(this.fb, c0962f.fb) || !kr.equals(this.fc, c0962f.fc)) {
                return false;
            }
            if (this.fd == null) {
                if (c0962f.fd != null) {
                    return false;
                }
            } else if (!this.fd.equals(c0962f.fd)) {
                return false;
            }
            if (this.fe == null) {
                if (c0962f.fe != null) {
                    return false;
                }
            } else if (!this.fe.equals(c0962f.fe)) {
                return false;
            }
            if (this.ff == null) {
                if (c0962f.ff != null) {
                    return false;
                }
            } else if (!this.ff.equals(c0962f.ff)) {
                return false;
            }
            if (this.fg == null) {
                if (c0962f.fg != null) {
                    return false;
                }
            } else if (!this.fg.equals(c0962f.fg)) {
                return false;
            }
            if (this.fh == null) {
                if (c0962f.fh != null) {
                    return false;
                }
            } else if (!this.fh.equals(c0962f.fh)) {
                return false;
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(c0962f.fi) || this.fj != c0962f.fj || !kr.equals(this.fk, c0962f.fk) || this.fl != c0962f.fl) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0962f.adU == null || c0962f.adU.isEmpty();
            } else {
                return this.adU.equals(c0962f.adU);
            }
        }

        /* renamed from: g */
        public C0962f m2942g(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                switch (mh) {
                    case 0:
                        break;
                    case 10:
                        b = kw.m1177b(knVar, 10);
                        mh = this.eW == null ? 0 : this.eW.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eW, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.eW = obj;
                        continue;
                    case 18:
                        b = kw.m1177b(knVar, 18);
                        mh = this.eX == null ? 0 : this.eX.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eX, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.eX = obj;
                        continue;
                    case Keys.POWER /*26*/:
                        b = kw.m1177b(knVar, 26);
                        mh = this.eY == null ? 0 : this.eY.length;
                        obj = new C0961e[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eY, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0961e();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0961e();
                        knVar.m1127a(obj[mh]);
                        this.eY = obj;
                        continue;
                    case Keys.f10F /*34*/:
                        b = kw.m1177b(knVar, 34);
                        mh = this.eZ == null ? 0 : this.eZ.length;
                        obj = new C0958b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eZ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0958b();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0958b();
                        knVar.m1127a(obj[mh]);
                        this.eZ = obj;
                        continue;
                    case Keys.f18N /*42*/:
                        b = kw.m1177b(knVar, 42);
                        mh = this.fa == null ? 0 : this.fa.length;
                        obj = new C0958b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fa, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0958b();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0958b();
                        knVar.m1127a(obj[mh]);
                        this.fa = obj;
                        continue;
                    case 50:
                        b = kw.m1177b(knVar, 50);
                        mh = this.fb == null ? 0 : this.fb.length;
                        obj = new C0958b[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fb, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0958b();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0958b();
                        knVar.m1127a(obj[mh]);
                        this.fb = obj;
                        continue;
                    case Keys.ALT_RIGHT /*58*/:
                        b = kw.m1177b(knVar, 58);
                        mh = this.fc == null ? 0 : this.fc.length;
                        obj = new C0963g[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0963g();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0963g();
                        knVar.m1127a(obj[mh]);
                        this.fc = obj;
                        continue;
                    case Keys.SEMICOLON /*74*/:
                        this.fd = knVar.readString();
                        continue;
                    case Keys.MENU /*82*/:
                        this.fe = knVar.readString();
                        continue;
                    case Keys.BUTTON_C /*98*/:
                        this.ff = knVar.readString();
                        continue;
                    case Keys.BUTTON_THUMBL /*106*/:
                        this.fg = knVar.readString();
                        continue;
                    case 114:
                        if (this.fh == null) {
                            this.fh = new C0957a();
                        }
                        knVar.m1127a(this.fh);
                        continue;
                    case 125:
                        this.fi = knVar.readFloat();
                        continue;
                    case Keys.CONTROL_RIGHT /*130*/:
                        b = kw.m1177b(knVar, Keys.CONTROL_RIGHT);
                        mh = this.fk == null ? 0 : this.fk.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.fk = obj;
                        continue;
                    case 136:
                        this.fl = knVar.mk();
                        continue;
                    case Keys.NUMPAD_0 /*144*/:
                        this.fj = knVar.ml();
                        continue;
                    case 154:
                        b = kw.m1177b(knVar, 154);
                        mh = this.eV == null ? 0 : this.eV.length;
                        obj = new String[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.eV, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.readString();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.readString();
                        this.eV = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fj ? 1231 : 1237) + (((((this.fh == null ? 0 : this.fh.hashCode()) + (((this.fg == null ? 0 : this.fg.hashCode()) + (((this.ff == null ? 0 : this.ff.hashCode()) + (((this.fe == null ? 0 : this.fe.hashCode()) + (((this.fd == null ? 0 : this.fd.hashCode()) + ((((((((((((((((kr.hashCode(this.eV) + 527) * 31) + kr.hashCode(this.eW)) * 31) + kr.hashCode(this.eX)) * 31) + kr.hashCode(this.eY)) * 31) + kr.hashCode(this.eZ)) * 31) + kr.hashCode(this.fa)) * 31) + kr.hashCode(this.fb)) * 31) + kr.hashCode(this.fc)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.fi)) * 31)) * 31) + kr.hashCode(this.fk)) * 31) + this.fl) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: k */
        public C0962f m2943k() {
            this.eV = kw.aef;
            this.eW = kw.aef;
            this.eX = C0969a.m2982r();
            this.eY = C0961e.m2932i();
            this.eZ = C0958b.m2915d();
            this.fa = C0958b.m2915d();
            this.fb = C0958b.m2915d();
            this.fc = C0963g.m2944l();
            this.fd = "";
            this.fe = "";
            this.ff = "0";
            this.fg = "";
            this.fh = null;
            this.fi = 0.0f;
            this.fj = false;
            this.fk = kw.aef;
            this.fl = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$g */
    public static final class C0963g extends kp<C0963g> {
        private static volatile C0963g[] fm;
        public int[] fn;
        public int[] fo;
        public int[] fp;
        public int[] fq;
        public int[] fr;
        public int[] fs;
        public int[] ft;
        public int[] fu;
        public int[] fv;
        public int[] fw;

        public C0963g() {
            m2949m();
        }

        /* renamed from: l */
        public static C0963g[] m2944l() {
            if (fm == null) {
                synchronized (kr.adX) {
                    if (fm == null) {
                        fm = new C0963g[0];
                    }
                }
            }
            return fm;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            int i = 0;
            if (this.fn != null && this.fn.length > 0) {
                for (int i2 : this.fn) {
                    koVar.m1158i(1, i2);
                }
            }
            if (this.fo != null && this.fo.length > 0) {
                for (int i22 : this.fo) {
                    koVar.m1158i(2, i22);
                }
            }
            if (this.fp != null && this.fp.length > 0) {
                for (int i222 : this.fp) {
                    koVar.m1158i(3, i222);
                }
            }
            if (this.fq != null && this.fq.length > 0) {
                for (int i2222 : this.fq) {
                    koVar.m1158i(4, i2222);
                }
            }
            if (this.fr != null && this.fr.length > 0) {
                for (int i22222 : this.fr) {
                    koVar.m1158i(5, i22222);
                }
            }
            if (this.fs != null && this.fs.length > 0) {
                for (int i222222 : this.fs) {
                    koVar.m1158i(6, i222222);
                }
            }
            if (this.ft != null && this.ft.length > 0) {
                for (int i2222222 : this.ft) {
                    koVar.m1158i(7, i2222222);
                }
            }
            if (this.fu != null && this.fu.length > 0) {
                for (int i22222222 : this.fu) {
                    koVar.m1158i(8, i22222222);
                }
            }
            if (this.fv != null && this.fv.length > 0) {
                for (int i222222222 : this.fv) {
                    koVar.m1158i(9, i222222222);
                }
            }
            if (this.fw != null && this.fw.length > 0) {
                while (i < this.fw.length) {
                    koVar.m1158i(10, this.fw[i]);
                    i++;
                }
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2948h(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo2700c();
            if (this.fn == null || this.fn.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cX : this.fn) {
                    i2 += ko.cX(cX);
                }
                i = (c + i2) + (this.fn.length * 1);
            }
            if (this.fo != null && this.fo.length > 0) {
                c = 0;
                for (int cX2 : this.fo) {
                    c += ko.cX(cX2);
                }
                i = (i + c) + (this.fo.length * 1);
            }
            if (this.fp != null && this.fp.length > 0) {
                c = 0;
                for (int cX22 : this.fp) {
                    c += ko.cX(cX22);
                }
                i = (i + c) + (this.fp.length * 1);
            }
            if (this.fq != null && this.fq.length > 0) {
                c = 0;
                for (int cX222 : this.fq) {
                    c += ko.cX(cX222);
                }
                i = (i + c) + (this.fq.length * 1);
            }
            if (this.fr != null && this.fr.length > 0) {
                c = 0;
                for (int cX2222 : this.fr) {
                    c += ko.cX(cX2222);
                }
                i = (i + c) + (this.fr.length * 1);
            }
            if (this.fs != null && this.fs.length > 0) {
                c = 0;
                for (int cX22222 : this.fs) {
                    c += ko.cX(cX22222);
                }
                i = (i + c) + (this.fs.length * 1);
            }
            if (this.ft != null && this.ft.length > 0) {
                c = 0;
                for (int cX222222 : this.ft) {
                    c += ko.cX(cX222222);
                }
                i = (i + c) + (this.ft.length * 1);
            }
            if (this.fu != null && this.fu.length > 0) {
                c = 0;
                for (int cX2222222 : this.fu) {
                    c += ko.cX(cX2222222);
                }
                i = (i + c) + (this.fu.length * 1);
            }
            if (this.fv != null && this.fv.length > 0) {
                c = 0;
                for (int cX22222222 : this.fv) {
                    c += ko.cX(cX22222222);
                }
                i = (i + c) + (this.fv.length * 1);
            }
            if (this.fw != null && this.fw.length > 0) {
                i2 = 0;
                while (i3 < this.fw.length) {
                    i2 += ko.cX(this.fw[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fw.length * 1);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0963g)) {
                return false;
            }
            C0963g c0963g = (C0963g) o;
            if (!kr.equals(this.fn, c0963g.fn) || !kr.equals(this.fo, c0963g.fo) || !kr.equals(this.fp, c0963g.fp) || !kr.equals(this.fq, c0963g.fq) || !kr.equals(this.fr, c0963g.fr) || !kr.equals(this.fs, c0963g.fs) || !kr.equals(this.ft, c0963g.ft) || !kr.equals(this.fu, c0963g.fu) || !kr.equals(this.fv, c0963g.fv) || !kr.equals(this.fw, c0963g.fw)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0963g.adU == null || c0963g.adU.isEmpty();
            } else {
                return this.adU.equals(c0963g.adU);
            }
        }

        /* renamed from: h */
        public C0963g m2948h(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int cR;
                Object obj2;
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        b = kw.m1177b(knVar, 8);
                        mh = this.fn == null ? 0 : this.fn.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fn = obj;
                        continue;
                    case 10:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fn == null ? 0 : this.fn.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fn, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fn = obj2;
                        knVar.cS(cR);
                        continue;
                    case 16:
                        b = kw.m1177b(knVar, 16);
                        mh = this.fo == null ? 0 : this.fo.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fo, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fo = obj;
                        continue;
                    case 18:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fo == null ? 0 : this.fo.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fo, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fo = obj2;
                        knVar.cS(cR);
                        continue;
                    case 24:
                        b = kw.m1177b(knVar, 24);
                        mh = this.fp == null ? 0 : this.fp.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fp, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fp = obj;
                        continue;
                    case Keys.POWER /*26*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fp == null ? 0 : this.fp.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fp, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fp = obj2;
                        knVar.cS(cR);
                        continue;
                    case 32:
                        b = kw.m1177b(knVar, 32);
                        mh = this.fq == null ? 0 : this.fq.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fq = obj;
                        continue;
                    case Keys.f10F /*34*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fq = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.f16L /*40*/:
                        b = kw.m1177b(knVar, 40);
                        mh = this.fr == null ? 0 : this.fr.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fr, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fr = obj;
                        continue;
                    case Keys.f18N /*42*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fr == null ? 0 : this.fr.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fr, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fr = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.f24T /*48*/:
                        b = kw.m1177b(knVar, 48);
                        mh = this.fs == null ? 0 : this.fs.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fs, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fs = obj;
                        continue;
                    case 50:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fs == null ? 0 : this.fs.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fs, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fs = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.PERIOD /*56*/:
                        b = kw.m1177b(knVar, 56);
                        mh = this.ft == null ? 0 : this.ft.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.ft, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.ft = obj;
                        continue;
                    case Keys.ALT_RIGHT /*58*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.ft == null ? 0 : this.ft.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.ft, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.ft = obj2;
                        knVar.cS(cR);
                        continue;
                    case 64:
                        b = kw.m1177b(knVar, 64);
                        mh = this.fu == null ? 0 : this.fu.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fu, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fu = obj;
                        continue;
                    case Keys.ENTER /*66*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fu == null ? 0 : this.fu.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fu = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.RIGHT_BRACKET /*72*/:
                        b = kw.m1177b(knVar, 72);
                        mh = this.fv == null ? 0 : this.fv.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fv = obj;
                        continue;
                    case Keys.SEMICOLON /*74*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fv == null ? 0 : this.fv.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fv, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fv = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.FOCUS /*80*/:
                        b = kw.m1177b(knVar, 80);
                        mh = this.fw == null ? 0 : this.fw.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fw, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fw = obj;
                        continue;
                    case Keys.MENU /*82*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fw == null ? 0 : this.fw.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fw, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fw = obj2;
                        knVar.cS(cR);
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

        public int hashCode() {
            int hashCode = (((((((((((((((((((kr.hashCode(this.fn) + 527) * 31) + kr.hashCode(this.fo)) * 31) + kr.hashCode(this.fp)) * 31) + kr.hashCode(this.fq)) * 31) + kr.hashCode(this.fr)) * 31) + kr.hashCode(this.fs)) * 31) + kr.hashCode(this.ft)) * 31) + kr.hashCode(this.fu)) * 31) + kr.hashCode(this.fv)) * 31) + kr.hashCode(this.fw)) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }

        /* renamed from: m */
        public C0963g m2949m() {
            this.fn = kw.aea;
            this.fo = kw.aea;
            this.fp = kw.aea;
            this.fq = kw.aea;
            this.fr = kw.aea;
            this.fs = kw.aea;
            this.ft = kw.aea;
            this.fu = kw.aea;
            this.fv = kw.aea;
            this.fw = kw.aea;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$h */
    public static final class C0964h extends kp<C0964h> {
        public static final kq<C0969a, C0964h> fx = kq.m1163a(11, C0964h.class, 810);
        private static final C0964h[] fy = new C0964h[0];
        public int[] fA;
        public int[] fB;
        public int fC;
        public int[] fD;
        public int fE;
        public int fF;
        public int[] fz;

        public C0964h() {
            m2954n();
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            int i = 0;
            if (this.fz != null && this.fz.length > 0) {
                for (int i2 : this.fz) {
                    koVar.m1158i(1, i2);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int i22 : this.fA) {
                    koVar.m1158i(2, i22);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int i222 : this.fB) {
                    koVar.m1158i(3, i222);
                }
            }
            if (this.fC != 0) {
                koVar.m1158i(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                while (i < this.fD.length) {
                    koVar.m1158i(5, this.fD[i]);
                    i++;
                }
            }
            if (this.fE != 0) {
                koVar.m1158i(6, this.fE);
            }
            if (this.fF != 0) {
                koVar.m1158i(7, this.fF);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2953i(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo2700c();
            if (this.fz == null || this.fz.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int cX : this.fz) {
                    i2 += ko.cX(cX);
                }
                i = (c + i2) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int cX2 : this.fA) {
                    c += ko.cX(cX2);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int cX22 : this.fB) {
                    c += ko.cX(cX22);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != 0) {
                i += ko.m1144j(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                i2 = 0;
                while (i3 < this.fD.length) {
                    i2 += ko.cX(this.fD[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fD.length * 1);
            }
            if (this.fE != 0) {
                i += ko.m1144j(6, this.fE);
            }
            if (this.fF != 0) {
                i += ko.m1144j(7, this.fF);
            }
            this.adY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0964h)) {
                return false;
            }
            C0964h c0964h = (C0964h) o;
            if (!kr.equals(this.fz, c0964h.fz) || !kr.equals(this.fA, c0964h.fA) || !kr.equals(this.fB, c0964h.fB) || this.fC != c0964h.fC || !kr.equals(this.fD, c0964h.fD) || this.fE != c0964h.fE || this.fF != c0964h.fF) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0964h.adU == null || c0964h.adU.isEmpty();
            } else {
                return this.adU.equals(c0964h.adU);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((kr.hashCode(this.fz) + 527) * 31) + kr.hashCode(this.fA)) * 31) + kr.hashCode(this.fB)) * 31) + this.fC) * 31) + kr.hashCode(this.fD)) * 31) + this.fE) * 31) + this.fF) * 31;
            int hashCode2 = (this.adU == null || this.adU.isEmpty()) ? 0 : this.adU.hashCode();
            return hashCode2 + hashCode;
        }

        /* renamed from: i */
        public C0964h m2953i(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int cR;
                Object obj2;
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        b = kw.m1177b(knVar, 8);
                        mh = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fz = obj;
                        continue;
                    case 10:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fz = obj2;
                        knVar.cS(cR);
                        continue;
                    case 16:
                        b = kw.m1177b(knVar, 16);
                        mh = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fA = obj;
                        continue;
                    case 18:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fA = obj2;
                        knVar.cS(cR);
                        continue;
                    case 24:
                        b = kw.m1177b(knVar, 24);
                        mh = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fB = obj;
                        continue;
                    case Keys.POWER /*26*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fB = obj2;
                        knVar.cS(cR);
                        continue;
                    case 32:
                        this.fC = knVar.mk();
                        continue;
                    case Keys.f16L /*40*/:
                        b = kw.m1177b(knVar, 40);
                        mh = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = knVar.mk();
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = knVar.mk();
                        this.fD = obj;
                        continue;
                    case Keys.f18N /*42*/:
                        cR = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            knVar.mk();
                            mh++;
                        }
                        knVar.cT(b);
                        b = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(mh + b)];
                        if (b != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = knVar.mk();
                            b++;
                        }
                        this.fD = obj2;
                        knVar.cS(cR);
                        continue;
                    case Keys.f24T /*48*/:
                        this.fE = knVar.mk();
                        continue;
                    case Keys.PERIOD /*56*/:
                        this.fF = knVar.mk();
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

        /* renamed from: n */
        public C0964h m2954n() {
            this.fz = kw.aea;
            this.fA = kw.aea;
            this.fB = kw.aea;
            this.fC = 0;
            this.fD = kw.aea;
            this.fE = 0;
            this.fF = 0;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$i */
    public static final class C0965i extends kp<C0965i> {
        private static volatile C0965i[] fG;
        public C0969a fH;
        public C0960d fI;
        public String name;

        public C0965i() {
            m2960p();
        }

        /* renamed from: o */
        public static C0965i[] m2955o() {
            if (fG == null) {
                synchronized (kr.adX) {
                    if (fG == null) {
                        fG = new C0965i[0];
                    }
                }
            }
            return fG;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            if (!this.name.equals("")) {
                koVar.m1153b(1, this.name);
            }
            if (this.fH != null) {
                koVar.m1148a(2, this.fH);
            }
            if (this.fI != null) {
                koVar.m1148a(3, this.fI);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2959j(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = super.mo2700c();
            if (!this.name.equals("")) {
                c += ko.m1143g(1, this.name);
            }
            if (this.fH != null) {
                c += ko.m1135b(2, this.fH);
            }
            if (this.fI != null) {
                c += ko.m1135b(3, this.fI);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0965i)) {
                return false;
            }
            C0965i c0965i = (C0965i) o;
            if (this.name == null) {
                if (c0965i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c0965i.name)) {
                return false;
            }
            if (this.fH == null) {
                if (c0965i.fH != null) {
                    return false;
                }
            } else if (!this.fH.equals(c0965i.fH)) {
                return false;
            }
            if (this.fI == null) {
                if (c0965i.fI != null) {
                    return false;
                }
            } else if (!this.fI.equals(c0965i.fI)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0965i.adU == null || c0965i.adU.isEmpty();
            } else {
                return this.adU.equals(c0965i.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fI == null ? 0 : this.fI.hashCode()) + (((this.fH == null ? 0 : this.fH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: j */
        public C0965i m2959j(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 10:
                        this.name = knVar.readString();
                        continue;
                    case 18:
                        if (this.fH == null) {
                            this.fH = new C0969a();
                        }
                        knVar.m1127a(this.fH);
                        continue;
                    case Keys.POWER /*26*/:
                        if (this.fI == null) {
                            this.fI = new C0960d();
                        }
                        knVar.m1127a(this.fI);
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

        /* renamed from: p */
        public C0965i m2960p() {
            this.name = "";
            this.fH = null;
            this.fI = null;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$j */
    public static final class C0966j extends kp<C0966j> {
        public C0965i[] fJ;
        public C0962f fK;
        public String fL;

        public C0966j() {
            m2966q();
        }

        /* renamed from: b */
        public static C0966j m2961b(byte[] bArr) throws ks {
            return (C0966j) kt.m1167a(new C0966j(), bArr);
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            if (this.fJ != null && this.fJ.length > 0) {
                for (kt ktVar : this.fJ) {
                    if (ktVar != null) {
                        koVar.m1148a(1, ktVar);
                    }
                }
            }
            if (this.fK != null) {
                koVar.m1148a(2, this.fK);
            }
            if (!this.fL.equals("")) {
                koVar.m1153b(3, this.fL);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2965k(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = super.mo2700c();
            if (this.fJ != null && this.fJ.length > 0) {
                for (kt ktVar : this.fJ) {
                    if (ktVar != null) {
                        c += ko.m1135b(1, ktVar);
                    }
                }
            }
            if (this.fK != null) {
                c += ko.m1135b(2, this.fK);
            }
            if (!this.fL.equals("")) {
                c += ko.m1143g(3, this.fL);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0966j)) {
                return false;
            }
            C0966j c0966j = (C0966j) o;
            if (!kr.equals(this.fJ, c0966j.fJ)) {
                return false;
            }
            if (this.fK == null) {
                if (c0966j.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c0966j.fK)) {
                return false;
            }
            if (this.fL == null) {
                if (c0966j.fL != null) {
                    return false;
                }
            } else if (!this.fL.equals(c0966j.fL)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0966j.adU == null || c0966j.adU.isEmpty();
            } else {
                return this.adU.equals(c0966j.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fL == null ? 0 : this.fL.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((kr.hashCode(this.fJ) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: k */
        public C0966j m2965k(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 10:
                        int b = kw.m1177b(knVar, 10);
                        mh = this.fJ == null ? 0 : this.fJ.length;
                        Object obj = new C0965i[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0965i();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0965i();
                        knVar.m1127a(obj[mh]);
                        this.fJ = obj;
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new C0962f();
                        }
                        knVar.m1127a(this.fK);
                        continue;
                    case Keys.POWER /*26*/:
                        this.fL = knVar.readString();
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

        /* renamed from: q */
        public C0966j m2966q() {
            this.fJ = C0965i.m2955o();
            this.fK = null;
            this.fL = "";
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }
}
