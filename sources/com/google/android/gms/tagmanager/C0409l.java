package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C0409l<K, V> {
    final C0408a<K, V> WH = new C08341(this);

    /* renamed from: com.google.android.gms.tagmanager.l$a */
    public interface C0408a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: com.google.android.gms.tagmanager.l$1 */
    class C08341 implements C0408a<K, V> {
        final /* synthetic */ C0409l WI;

        C08341(C0409l c0409l) {
            this.WI = c0409l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    /* renamed from: a */
    public C0407k<K, V> m1482a(int i, C0408a<K, V> c0408a) {
        if (i > 0) {
            return jZ() < 12 ? new cz(i, c0408a) : new bb(i, c0408a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int jZ() {
        return VERSION.SDK_INT;
    }
}
