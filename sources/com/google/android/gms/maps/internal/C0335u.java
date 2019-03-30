package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C0317c.C0734a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.u */
public class C0335u {
    private static C0317c SA;
    private static Context Sz;

    /* renamed from: A */
    public static C0317c m1248A(Context context) throws GooglePlayServicesNotAvailableException {
        fq.m986f(context);
        if (SA != null) {
            return SA;
        }
        C0335u.m1249B(context);
        SA = C0335u.m1250C(context);
        try {
            SA.mo2037a(C0926e.m2696h(C0335u.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return SA;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: B */
    private static void m1249B(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: C */
    private static C0317c m1250C(Context context) {
        if (C0335u.iz()) {
            Log.i(C0335u.class.getSimpleName(), "Making Creator statically");
            return (C0317c) C0335u.m1252c(C0335u.iA());
        }
        Log.i(C0335u.class.getSimpleName(), "Making Creator dynamically");
        return C0734a.ab((IBinder) C0335u.m1251a(C0335u.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    /* renamed from: a */
    private static <T> T m1251a(ClassLoader classLoader, String str) {
        try {
            return C0335u.m1252c(((ClassLoader) fq.m986f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: c */
    private static <T> T m1252c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (Sz == null) {
            if (C0335u.iz()) {
                Sz = context.getApplicationContext();
            } else {
                Sz = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return Sz;
    }

    private static Class<?> iA() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean iz() {
        return false;
    }
}
