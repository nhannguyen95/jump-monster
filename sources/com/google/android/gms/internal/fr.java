package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0193g;
import com.google.android.gms.dynamic.C0193g.C0192a;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.fn.C0653a;

public final class fr extends C0193g<fn> {
    private static final fr DK = new fr();

    private fr() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: b */
    public static View m2208b(Context context, int i, int i2) throws C0192a {
        return DK.m2209c(context, i, i2);
    }

    /* renamed from: c */
    private View m2209c(Context context, int i, int i2) throws C0192a {
        try {
            return (View) C0926e.m2695d(((fn) m360z(context)).mo1763a(C0926e.m2696h(context), i, i2));
        } catch (Throwable e) {
            throw new C0192a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: E */
    public fn m2210E(IBinder iBinder) {
        return C0653a.m2207D(iBinder);
    }

    /* renamed from: d */
    public /* synthetic */ Object mo1596d(IBinder iBinder) {
        return m2210E(iBinder);
    }
}
