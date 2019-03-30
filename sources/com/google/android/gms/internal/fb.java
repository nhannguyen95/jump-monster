package com.google.android.gms.internal;

import android.os.Looper;
import android.util.Log;

public final class fb {
    /* renamed from: a */
    public static void m920a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void aj(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(str);
        }
    }

    public static void ak(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: d */
    public static void m921d(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    /* renamed from: x */
    public static void m922x(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
