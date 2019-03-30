package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class fo {

    /* renamed from: com.google.android.gms.internal.fo$a */
    public static final class C0282a {
        private final List<String> DI;
        private final Object DJ;

        private C0282a(Object obj) {
            this.DJ = fq.m986f(obj);
            this.DI = new ArrayList();
        }

        /* renamed from: a */
        public C0282a m976a(String str, Object obj) {
            this.DI.add(((String) fq.m986f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.DJ.getClass().getSimpleName()).append('{');
            int size = this.DI.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.DI.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    /* renamed from: e */
    public static C0282a m977e(Object obj) {
        return new C0282a(obj);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
