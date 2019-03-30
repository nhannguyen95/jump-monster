package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fq;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C0193g<T> {
    private final String Hx;
    private T Hy;

    /* renamed from: com.google.android.gms.dynamic.g$a */
    public static class C0192a extends Exception {
        public C0192a(String str) {
            super(str);
        }

        public C0192a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0193g(String str) {
        this.Hx = str;
    }

    /* renamed from: d */
    protected abstract T mo1596d(IBinder iBinder);

    /* renamed from: z */
    protected final T m360z(Context context) throws C0192a {
        if (this.Hy == null) {
            fq.m986f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0192a("Could not get remote context.");
            }
            try {
                this.Hy = mo1596d((IBinder) remoteContext.getClassLoader().loadClass(this.Hx).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0192a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0192a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0192a("Could not access creator.");
            }
        }
        return this.Hy;
    }
}
