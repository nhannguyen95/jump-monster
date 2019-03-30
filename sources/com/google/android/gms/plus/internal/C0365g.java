package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C0361c.C0803a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C0365g {
    private static Context Sz;
    private static C0361c Uj;

    /* renamed from: com.google.android.gms.plus.internal.g$a */
    public static class C0364a extends Exception {
        public C0364a(String str) {
            super(str);
        }
    }

    /* renamed from: D */
    private static C0361c m1323D(Context context) throws C0364a {
        fq.m986f(context);
        if (Uj == null) {
            if (Sz == null) {
                Sz = GooglePlayServicesUtil.getRemoteContext(context);
                if (Sz == null) {
                    throw new C0364a("Could not get remote context.");
                }
            }
            try {
                Uj = C0803a.aP((IBinder) Sz.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0364a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0364a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0364a("Could not access creator.");
            }
        }
        return Uj;
    }

    /* renamed from: a */
    public static View m1324a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0926e.m2695d(C0365g.m1323D(context).mo2209a(C0926e.m2696h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
