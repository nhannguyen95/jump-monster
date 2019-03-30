package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.safeparcel.c */
public final class C0147c {
    /* renamed from: a */
    public static <T extends SafeParcelable> byte[] m238a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
