package com.google.android.gms.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class kq<M extends kp<M>, T> {
    protected final Class<T> adV;
    protected final boolean adW;
    protected final int tag;
    protected final int type;

    private kq(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.adV = cls;
        this.tag = i2;
        this.adW = z;
    }

    /* renamed from: a */
    public static <M extends kp<M>, T extends kt> kq<M, T> m1163a(int i, Class<T> cls, int i2) {
        return new kq(i, cls, i2, false);
    }

    /* renamed from: a */
    protected void m1164a(kv kvVar, List<Object> list) {
        list.add(m1166o(kn.m1125n(kvVar.adZ)));
    }

    protected boolean dd(int i) {
        return i == this.tag;
    }

    /* renamed from: f */
    final T m1165f(List<kv> list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        kv kvVar;
        if (this.adW) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                kvVar = (kv) list.get(i2);
                if (dd(kvVar.tag) && kvVar.adZ.length != 0) {
                    m1164a(kvVar, arrayList);
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            T cast = this.adV.cast(Array.newInstance(this.adV.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        }
        i = list.size() - 1;
        kv kvVar2 = null;
        while (kvVar2 == null && i >= 0) {
            kvVar = (kv) list.get(i);
            if (!dd(kvVar.tag) || kvVar.adZ.length == 0) {
                kvVar = kvVar2;
            }
            i--;
            kvVar2 = kvVar;
        }
        return kvVar2 == null ? null : this.adV.cast(m1166o(kn.m1125n(kvVar2.adZ)));
    }

    /* renamed from: o */
    protected Object m1166o(kn knVar) {
        Class componentType = this.adW ? this.adV.getComponentType() : this.adV;
        try {
            kt ktVar;
            switch (this.type) {
                case 10:
                    ktVar = (kt) componentType.newInstance();
                    knVar.m1128a(ktVar, kw.df(this.tag));
                    return ktVar;
                case 11:
                    ktVar = (kt) componentType.newInstance();
                    knVar.m1127a(ktVar);
                    return ktVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
