package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0190d.C0575a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C0926e<T> extends C0575a {
    private final T Hw;

    private C0926e(T t) {
        this.Hw = t;
    }

    /* renamed from: d */
    public static <T> T m2695d(C0190d c0190d) {
        if (c0190d instanceof C0926e) {
            return ((C0926e) c0190d).Hw;
        }
        IBinder asBinder = c0190d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    /* renamed from: h */
    public static <T> C0190d m2696h(T t) {
        return new C0926e(t);
    }
}
