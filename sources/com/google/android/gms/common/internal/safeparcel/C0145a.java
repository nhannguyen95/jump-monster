package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.request.GameRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C0145a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a$a */
    public static class C0144a extends RuntimeException {
        public C0144a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    /* renamed from: A */
    public static ArrayList<String> m172A(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    /* renamed from: B */
    public static Parcel m173B(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    /* renamed from: C */
    public static Parcel[] m174C(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    /* renamed from: R */
    public static int m175R(int i) {
        return GameRequest.TYPE_ALL & i;
    }

    /* renamed from: a */
    public static int m176a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & GameRequest.TYPE_ALL : parcel.readInt();
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m177a(Parcel parcel, int i, Creator<T> creator) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    /* renamed from: a */
    private static void m178a(Parcel parcel, int i, int i2) {
        int a = C0145a.m176a(parcel, i);
        if (a != i2) {
            throw new C0144a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    /* renamed from: a */
    private static void m179a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C0144a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    /* renamed from: a */
    public static void m180a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    /* renamed from: b */
    public static void m181b(Parcel parcel, int i) {
        parcel.setDataPosition(C0145a.m176a(parcel, i) + parcel.dataPosition());
    }

    /* renamed from: b */
    public static <T> T[] m182b(Parcel parcel, int i, Creator<T> creator) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    /* renamed from: c */
    public static <T> ArrayList<T> m183c(Parcel parcel, int i, Creator<T> creator) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    /* renamed from: c */
    public static boolean m184c(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: d */
    public static Boolean m185d(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0145a.m179a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    /* renamed from: e */
    public static byte m186e(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    /* renamed from: f */
    public static short m187f(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    /* renamed from: g */
    public static int m188g(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: h */
    public static Integer m189h(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        if (a == 0) {
            return null;
        }
        C0145a.m179a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: i */
    public static long m190i(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: j */
    public static BigInteger m191j(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    /* renamed from: k */
    public static float m192k(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 4);
        return parcel.readFloat();
    }

    /* renamed from: l */
    public static double m193l(Parcel parcel, int i) {
        C0145a.m178a(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: m */
    public static BigDecimal m194m(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    /* renamed from: n */
    public static int m195n(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: n */
    public static String m196n(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    /* renamed from: o */
    public static int m197o(Parcel parcel) {
        int n = C0145a.m195n(parcel);
        int a = C0145a.m176a(parcel, n);
        int dataPosition = parcel.dataPosition();
        if (C0145a.m175R(n) != 20293) {
            throw new C0144a("Expected object header. Got 0x" + Integer.toHexString(n), parcel);
        }
        n = dataPosition + a;
        if (n >= dataPosition && n <= parcel.dataSize()) {
            return n;
        }
        throw new C0144a("Size read is invalid start=" + dataPosition + " end=" + n, parcel);
    }

    /* renamed from: o */
    public static IBinder m198o(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    /* renamed from: p */
    public static Bundle m199p(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    /* renamed from: q */
    public static byte[] m200q(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    /* renamed from: r */
    public static byte[][] m201r(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return (byte[][]) null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    /* renamed from: s */
    public static boolean[] m202s(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    /* renamed from: t */
    public static int[] m203t(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    /* renamed from: u */
    public static long[] m204u(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    /* renamed from: v */
    public static BigInteger[] m205v(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    /* renamed from: w */
    public static float[] m206w(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    /* renamed from: x */
    public static double[] m207x(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    /* renamed from: y */
    public static BigDecimal[] m208y(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    /* renamed from: z */
    public static String[] m209z(Parcel parcel, int i) {
        int a = C0145a.m176a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }
}
