package com.google.android.gms.internal;

import com.badlogic.gdx.Input.Keys;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C0239d {

    /* renamed from: com.google.android.gms.internal.d$a */
    public static final class C0969a extends kp<C0969a> {
        private static volatile C0969a[] fM;
        public String fN;
        public C0969a[] fO;
        public C0969a[] fP;
        public C0969a[] fQ;
        public String fR;
        public String fS;
        public long fT;
        public boolean fU;
        public C0969a[] fV;
        public int[] fW;
        public boolean fX;
        public int type;

        public C0969a() {
            m2987s();
        }

        /* renamed from: r */
        public static C0969a[] m2982r() {
            if (fM == null) {
                synchronized (kr.adX) {
                    if (fM == null) {
                        fM = new C0969a[0];
                    }
                }
            }
            return fM;
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            int i = 0;
            koVar.m1158i(1, this.type);
            if (!this.fN.equals("")) {
                koVar.m1153b(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                for (kt ktVar : this.fO) {
                    if (ktVar != null) {
                        koVar.m1148a(3, ktVar);
                    }
                }
            }
            if (this.fP != null && this.fP.length > 0) {
                for (kt ktVar2 : this.fP) {
                    if (ktVar2 != null) {
                        koVar.m1148a(4, ktVar2);
                    }
                }
            }
            if (this.fQ != null && this.fQ.length > 0) {
                for (kt ktVar22 : this.fQ) {
                    if (ktVar22 != null) {
                        koVar.m1148a(5, ktVar22);
                    }
                }
            }
            if (!this.fR.equals("")) {
                koVar.m1153b(6, this.fR);
            }
            if (!this.fS.equals("")) {
                koVar.m1153b(7, this.fS);
            }
            if (this.fT != 0) {
                koVar.m1152b(8, this.fT);
            }
            if (this.fX) {
                koVar.m1149a(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int i2 : this.fW) {
                    koVar.m1158i(10, i2);
                }
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i < this.fV.length) {
                    kt ktVar3 = this.fV[i];
                    if (ktVar3 != null) {
                        koVar.m1148a(11, ktVar3);
                    }
                    i++;
                }
            }
            if (this.fU) {
                koVar.m1149a(12, this.fU);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m2986l(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int i;
            int i2 = 0;
            int c = super.mo2700c() + ko.m1144j(1, this.type);
            if (!this.fN.equals("")) {
                c += ko.m1143g(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                i = c;
                for (kt ktVar : this.fO) {
                    if (ktVar != null) {
                        i += ko.m1135b(3, ktVar);
                    }
                }
                c = i;
            }
            if (this.fP != null && this.fP.length > 0) {
                i = c;
                for (kt ktVar2 : this.fP) {
                    if (ktVar2 != null) {
                        i += ko.m1135b(4, ktVar2);
                    }
                }
                c = i;
            }
            if (this.fQ != null && this.fQ.length > 0) {
                i = c;
                for (kt ktVar22 : this.fQ) {
                    if (ktVar22 != null) {
                        i += ko.m1135b(5, ktVar22);
                    }
                }
                c = i;
            }
            if (!this.fR.equals("")) {
                c += ko.m1143g(6, this.fR);
            }
            if (!this.fS.equals("")) {
                c += ko.m1143g(7, this.fS);
            }
            if (this.fT != 0) {
                c += ko.m1140d(8, this.fT);
            }
            if (this.fX) {
                c += ko.m1136b(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                int i3 = 0;
                for (int cX : this.fW) {
                    i3 += ko.cX(cX);
                }
                c = (c + i3) + (this.fW.length * 1);
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i2 < this.fV.length) {
                    kt ktVar3 = this.fV[i2];
                    if (ktVar3 != null) {
                        c += ko.m1135b(11, ktVar3);
                    }
                    i2++;
                }
            }
            if (this.fU) {
                c += ko.m1136b(12, this.fU);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0969a)) {
                return false;
            }
            C0969a c0969a = (C0969a) o;
            if (this.type != c0969a.type) {
                return false;
            }
            if (this.fN == null) {
                if (c0969a.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(c0969a.fN)) {
                return false;
            }
            if (!kr.equals(this.fO, c0969a.fO) || !kr.equals(this.fP, c0969a.fP) || !kr.equals(this.fQ, c0969a.fQ)) {
                return false;
            }
            if (this.fR == null) {
                if (c0969a.fR != null) {
                    return false;
                }
            } else if (!this.fR.equals(c0969a.fR)) {
                return false;
            }
            if (this.fS == null) {
                if (c0969a.fS != null) {
                    return false;
                }
            } else if (!this.fS.equals(c0969a.fS)) {
                return false;
            }
            if (this.fT != c0969a.fT || this.fU != c0969a.fU || !kr.equals(this.fV, c0969a.fV) || !kr.equals(this.fW, c0969a.fW) || this.fX != c0969a.fX) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0969a.adU == null || c0969a.adU.isEmpty();
            } else {
                return this.adU.equals(c0969a.adU);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.fU ? 1231 : 1237) + (((((this.fS == null ? 0 : this.fS.hashCode()) + (((this.fR == null ? 0 : this.fR.hashCode()) + (((((((((this.fN == null ? 0 : this.fN.hashCode()) + ((this.type + 527) * 31)) * 31) + kr.hashCode(this.fO)) * 31) + kr.hashCode(this.fP)) * 31) + kr.hashCode(this.fQ)) * 31)) * 31)) * 31) + ((int) (this.fT ^ (this.fT >>> 32)))) * 31)) * 31) + kr.hashCode(this.fV)) * 31) + kr.hashCode(this.fW)) * 31;
            if (!this.fX) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i2 = this.adU.hashCode();
            }
            return hashCode + i2;
        }

        /* renamed from: l */
        public C0969a m2986l(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                int b;
                Object obj;
                int i;
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        mh = knVar.mk();
                        switch (mh) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = mh;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.fN = knVar.readString();
                        continue;
                    case Keys.POWER /*26*/:
                        b = kw.m1177b(knVar, 26);
                        mh = this.fO == null ? 0 : this.fO.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fO, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.fO = obj;
                        continue;
                    case Keys.f10F /*34*/:
                        b = kw.m1177b(knVar, 34);
                        mh = this.fP == null ? 0 : this.fP.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fP, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.fP = obj;
                        continue;
                    case Keys.f18N /*42*/:
                        b = kw.m1177b(knVar, 42);
                        mh = this.fQ == null ? 0 : this.fQ.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fQ, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.fQ = obj;
                        continue;
                    case 50:
                        this.fR = knVar.readString();
                        continue;
                    case Keys.ALT_RIGHT /*58*/:
                        this.fS = knVar.readString();
                        continue;
                    case 64:
                        this.fT = knVar.mj();
                        continue;
                    case Keys.RIGHT_BRACKET /*72*/:
                        this.fX = knVar.ml();
                        continue;
                    case Keys.FOCUS /*80*/:
                        int b2 = kw.m1177b(knVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                knVar.mh();
                            }
                            int mk = knVar.mk();
                            switch (mk) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    mh = b + 1;
                                    obj2[b] = mk;
                                    break;
                                default:
                                    mh = b;
                                    break;
                            }
                            i++;
                            b = mh;
                        }
                        if (b != 0) {
                            mh = this.fW == null ? 0 : this.fW.length;
                            if (mh != 0 || b != obj2.length) {
                                Object obj3 = new int[(mh + b)];
                                if (mh != 0) {
                                    System.arraycopy(this.fW, 0, obj3, 0, mh);
                                }
                                System.arraycopy(obj2, 0, obj3, mh, b);
                                this.fW = obj3;
                                break;
                            }
                            this.fW = obj2;
                            break;
                        }
                        continue;
                    case Keys.MENU /*82*/:
                        i = knVar.cR(knVar.mn());
                        b = knVar.getPosition();
                        mh = 0;
                        while (knVar.ms() > 0) {
                            switch (knVar.mk()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    mh++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (mh != 0) {
                            knVar.cT(b);
                            b = this.fW == null ? 0 : this.fW.length;
                            Object obj4 = new int[(mh + b)];
                            if (b != 0) {
                                System.arraycopy(this.fW, 0, obj4, 0, b);
                            }
                            while (knVar.ms() > 0) {
                                int mk2 = knVar.mk();
                                switch (mk2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        mh = b + 1;
                                        obj4[b] = mk2;
                                        b = mh;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.fW = obj4;
                        }
                        knVar.cS(i);
                        continue;
                    case 90:
                        b = kw.m1177b(knVar, 90);
                        mh = this.fV == null ? 0 : this.fV.length;
                        obj = new C0969a[(b + mh)];
                        if (mh != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, mh);
                        }
                        while (mh < obj.length - 1) {
                            obj[mh] = new C0969a();
                            knVar.m1127a(obj[mh]);
                            knVar.mh();
                            mh++;
                        }
                        obj[mh] = new C0969a();
                        knVar.m1127a(obj[mh]);
                        this.fV = obj;
                        continue;
                    case Keys.BUTTON_A /*96*/:
                        this.fU = knVar.ml();
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

        /* renamed from: s */
        public C0969a m2987s() {
            this.type = 1;
            this.fN = "";
            this.fO = C0969a.m2982r();
            this.fP = C0969a.m2982r();
            this.fQ = C0969a.m2982r();
            this.fR = "";
            this.fS = "";
            this.fT = 0;
            this.fU = false;
            this.fV = C0969a.m2982r();
            this.fW = kw.aea;
            this.fX = false;
            this.adU = null;
            this.adY = -1;
            return this;
        }
    }
}
