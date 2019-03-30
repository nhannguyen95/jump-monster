package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.co.C0613a;

public final class cp extends C0613a {
    private final InAppPurchaseListener mp;

    public cp(InAppPurchaseListener inAppPurchaseListener) {
        this.mp = inAppPurchaseListener;
    }

    /* renamed from: a */
    public void mo1677a(cn cnVar) {
        this.mp.onInAppPurchaseRequested(new cq(cnVar));
    }
}
