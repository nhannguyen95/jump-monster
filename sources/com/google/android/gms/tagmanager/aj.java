package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0239d.C0969a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> XU;
    private final String XV;

    public aj(String str, String... strArr) {
        this.XV = str;
        this.XU = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.XU.add(add);
        }
    }

    /* renamed from: a */
    boolean m1366a(Set<String> set) {
        return set.containsAll(this.XU);
    }

    public abstract boolean jX();

    public String kB() {
        return this.XV;
    }

    public Set<String> kC() {
        return this.XU;
    }

    /* renamed from: x */
    public abstract C0969a mo2240x(Map<String, C0969a> map);
}
