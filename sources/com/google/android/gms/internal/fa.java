package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class fa extends fu<C0273a, Drawable> {

    /* renamed from: com.google.android.gms.internal.fa$a */
    public static final class C0273a {
        public final int CR;
        public final int CS;

        public C0273a(int i, int i2) {
            this.CR = i;
            this.CS = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0273a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0273a c0273a = (C0273a) obj;
            return c0273a.CR == this.CR && c0273a.CS == this.CS;
        }

        public int hashCode() {
            return fo.hashCode(Integer.valueOf(this.CR), Integer.valueOf(this.CS));
        }
    }

    public fa() {
        super(10);
    }
}
