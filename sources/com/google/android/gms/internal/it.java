package com.google.android.gms.internal;

import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.internal.C0223c.C0962f;
import com.google.android.gms.internal.C0223c.C0966j;
import java.io.IOException;

public interface it {

    /* renamed from: com.google.android.gms.internal.it$a */
    public static final class C0995a extends kp<C0995a> {
        public long aaY;
        public C0966j aaZ;
        public C0962f fK;

        public C0995a() {
            lV();
        }

        /* renamed from: l */
        public static C0995a m3101l(byte[] bArr) throws ks {
            return (C0995a) kt.m1167a(new C0995a(), bArr);
        }

        /* renamed from: a */
        public void mo1865a(ko koVar) throws IOException {
            koVar.m1152b(1, this.aaY);
            if (this.fK != null) {
                koVar.m1148a(2, this.fK);
            }
            if (this.aaZ != null) {
                koVar.m1148a(3, this.aaZ);
            }
            super.mo1865a(koVar);
        }

        /* renamed from: b */
        public /* synthetic */ kt mo2699b(kn knVar) throws IOException {
            return m3105n(knVar);
        }

        /* renamed from: c */
        public int mo2700c() {
            int c = super.mo2700c() + ko.m1140d(1, this.aaY);
            if (this.fK != null) {
                c += ko.m1135b(2, this.fK);
            }
            if (this.aaZ != null) {
                c += ko.m1135b(3, this.aaZ);
            }
            this.adY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0995a)) {
                return false;
            }
            C0995a c0995a = (C0995a) o;
            if (this.aaY != c0995a.aaY) {
                return false;
            }
            if (this.fK == null) {
                if (c0995a.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c0995a.fK)) {
                return false;
            }
            if (this.aaZ == null) {
                if (c0995a.aaZ != null) {
                    return false;
                }
            } else if (!this.aaZ.equals(c0995a.aaZ)) {
                return false;
            }
            if (this.adU == null || this.adU.isEmpty()) {
                return c0995a.adU == null || c0995a.adU.isEmpty();
            } else {
                return this.adU.equals(c0995a.adU);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aaZ == null ? 0 : this.aaZ.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((((int) (this.aaY ^ (this.aaY >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.adU == null || this.adU.isEmpty())) {
                i = this.adU.hashCode();
            }
            return hashCode + i;
        }

        public C0995a lV() {
            this.aaY = 0;
            this.fK = null;
            this.aaZ = null;
            this.adU = null;
            this.adY = -1;
            return this;
        }

        /* renamed from: n */
        public C0995a m3105n(kn knVar) throws IOException {
            while (true) {
                int mh = knVar.mh();
                switch (mh) {
                    case 0:
                        break;
                    case 8:
                        this.aaY = knVar.mj();
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new C0962f();
                        }
                        knVar.m1127a(this.fK);
                        continue;
                    case Keys.POWER /*26*/:
                        if (this.aaZ == null) {
                            this.aaZ = new C0966j();
                        }
                        knVar.m1127a(this.aaZ);
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
}
