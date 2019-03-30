package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0550c<T extends SafeParcelable> extends DataBuffer<T> {
    private static final String[] BF = new String[]{"data"};
    private final Creator<T> BG;

    public C0550c(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.BG = creator;
    }

    /* renamed from: F */
    public T m1683F(int i) {
        byte[] byteArray = this.BB.getByteArray("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.BG.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }

    public /* synthetic */ Object get(int x0) {
        return m1683F(x0);
    }
}
