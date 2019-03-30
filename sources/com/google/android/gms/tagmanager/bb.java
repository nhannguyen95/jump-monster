package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0409l.C0408a;

class bb<K, V> implements C0407k<K, V> {
    private LruCache<K, V> Yu;

    bb(int i, final C0408a<K, V> c0408a) {
        this.Yu = new LruCache<K, V>(this, i) {
            final /* synthetic */ bb Yw;

            protected int sizeOf(K key, V value) {
                return c0408a.sizeOf(key, value);
            }
        };
    }

    /* renamed from: e */
    public void mo2245e(K k, V v) {
        this.Yu.put(k, v);
    }

    public V get(K key) {
        return this.Yu.get(key);
    }
}
