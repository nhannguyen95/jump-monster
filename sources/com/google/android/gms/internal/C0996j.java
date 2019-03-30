package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C0996j extends C0675i {
    private static Method jR;
    private static Method jS;
    private static Method jT;
    private static Method jU;
    private static Method jV;
    private static Method jW;
    private static String jX;
    private static C0299p jY;
    static boolean jZ = false;
    private static long startTime = 0;

    /* renamed from: com.google.android.gms.internal.j$a */
    static class C0290a extends Exception {
        public C0290a(Throwable th) {
            super(th);
        }
    }

    protected C0996j(Context context, C0296n c0296n, C0297o c0297o) {
        super(context, c0296n, c0297o);
    }

    /* renamed from: a */
    static String m3106a(Context context, C0296n c0296n) throws C0290a {
        if (jT == null) {
            throw new C0290a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jT.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0296n.mo1685a(byteBuffer.array(), true);
            }
            throw new C0290a();
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m3107a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0290a {
        if (jU == null || motionEvent == null) {
            throw new C0290a();
        }
        try {
            return (ArrayList) jU.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: a */
    protected static synchronized void m3108a(String str, Context context, C0296n c0296n) {
        synchronized (C0996j.class) {
            if (!jZ) {
                try {
                    jY = new C0299p(c0296n, null);
                    jX = str;
                    C0996j.m3112e(context);
                    startTime = C0996j.m3114w().longValue();
                    jZ = true;
                } catch (C0290a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    /* renamed from: b */
    static String m3109b(Context context, C0296n c0296n) throws C0290a {
        if (jW == null) {
            throw new C0290a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jW.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c0296n.mo1685a(byteBuffer.array(), true);
            }
            throw new C0290a();
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: b */
    private static String m3110b(byte[] bArr, String str) throws C0290a {
        try {
            return new String(jY.m1192c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: d */
    static String m3111d(Context context) throws C0290a {
        if (jV == null) {
            throw new C0290a();
        }
        try {
            String str = (String) jV.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0290a();
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: e */
    private static void m3112e(Context context) throws C0290a {
        try {
            byte[] b = jY.m1191b(C0300r.getKey());
            byte[] c = jY.m1192c(b, C0300r.m1193A());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C0290a();
                }
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1194B()));
            Class loadClass2 = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1200H()));
            Class loadClass3 = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1198F()));
            Class loadClass4 = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1204L()));
            Class loadClass5 = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1196D()));
            Class loadClass6 = dexClassLoader.loadClass(C0996j.m3110b(b, C0300r.m1202J()));
            jR = loadClass.getMethod(C0996j.m3110b(b, C0300r.m1195C()), new Class[0]);
            jS = loadClass2.getMethod(C0996j.m3110b(b, C0300r.m1201I()), new Class[0]);
            jT = loadClass3.getMethod(C0996j.m3110b(b, C0300r.m1199G()), new Class[]{Context.class});
            jU = loadClass4.getMethod(C0996j.m3110b(b, C0300r.m1205M()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            jV = loadClass5.getMethod(C0996j.m3110b(b, C0300r.m1197E()), new Class[]{Context.class});
            jW = loadClass6.getMethod(C0996j.m3110b(b, C0300r.m1203K()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        } catch (Throwable e22) {
            throw new C0290a(e22);
        } catch (Throwable e222) {
            throw new C0290a(e222);
        } catch (Throwable e2222) {
            throw new C0290a(e2222);
        } catch (Throwable e22222) {
            throw new C0290a(e22222);
        }
    }

    /* renamed from: v */
    static String m3113v() throws C0290a {
        if (jX != null) {
            return jX;
        }
        throw new C0290a();
    }

    /* renamed from: w */
    static Long m3114w() throws C0290a {
        if (jR == null) {
            throw new C0290a();
        }
        try {
            return (Long) jR.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* renamed from: x */
    static String m3115x() throws C0290a {
        if (jS == null) {
            throw new C0290a();
        }
        try {
            return (String) jS.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C0290a(e);
        } catch (Throwable e2) {
            throw new C0290a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    protected void mo3144b(android.content.Context r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C0996j.m3115x();	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
        r3.m2293a(r0, r1);	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C0996j.m3113v();	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
        r3.m2293a(r0, r1);	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C0996j.m3114w();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r1 = r1.longValue();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r3.m2292a(r0, r1);	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
    L_0x001d:
        r0 = 24;
        r1 = com.google.android.gms.internal.C0996j.m3111d(r4);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
        r3.m2293a(r0, r1);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0029:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0010;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    protected void mo3145c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C0996j.m3113v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m2293a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C0996j.m3115x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m2293a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = com.google.android.gms.internal.C0996j.m3114w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m2292a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r3 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r3;
        r6.m2292a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r1 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m2292a(r0, r1);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jN;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jO;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0996j.m3107a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2292a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r3 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2292a(r2, r3);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m2292a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.jP;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0996j.m3106a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m2293a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.jP;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C0996j.m3109b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m2293a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.c(android.content.Context):void");
    }
}
