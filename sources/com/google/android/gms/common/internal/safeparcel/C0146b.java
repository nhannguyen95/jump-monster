package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0146b {
    /* renamed from: D */
    private static int m210D(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: E */
    private static void m211E(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: F */
    public static void m212F(Parcel parcel, int i) {
        C0146b.m211E(parcel, i);
    }

    /* renamed from: a */
    public static void m213a(Parcel parcel, int i, byte b) {
        C0146b.m233b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m214a(Parcel parcel, int i, double d) {
        C0146b.m233b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m215a(Parcel parcel, int i, float f) {
        C0146b.m233b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m216a(Parcel parcel, int i, long j) {
        C0146b.m233b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m217a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeBundle(bundle);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m218a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m219a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m220a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int D = C0146b.m210D(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m221a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C0146b.m233b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m222a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C0146b.m233b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m223a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeString(str);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m224a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeStringList(list);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m225a(Parcel parcel, int i, short s) {
        C0146b.m233b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m226a(Parcel parcel, int i, boolean z) {
        C0146b.m233b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m227a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeByteArray(bArr);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m228a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeIntArray(iArr);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m229a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : tArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0146b.m232a(parcel, parcelable, i2);
                }
            }
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m230a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeStringArray(strArr);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m231a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int D = C0146b.m210D(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m232a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: b */
    private static void m233b(Parcel parcel, int i, int i2) {
        if (i2 >= GameRequest.TYPE_ALL) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static <T extends Parcelable> void m234b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int D = C0146b.m210D(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C0146b.m232a(parcel, parcelable, 0);
                }
            }
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    public static void m235c(Parcel parcel, int i, int i2) {
        C0146b.m233b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static void m236c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int D = C0146b.m210D(parcel, i);
            parcel.writeList(list);
            C0146b.m211E(parcel, D);
        } else if (z) {
            C0146b.m233b(parcel, i, 0);
        }
    }

    /* renamed from: p */
    public static int m237p(Parcel parcel) {
        return C0146b.m210D(parcel, 20293);
    }
}
