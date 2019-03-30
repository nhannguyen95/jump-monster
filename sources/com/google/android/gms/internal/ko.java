package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class ko {
    private final int adT;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.ko$a */
    public static class C0293a extends IOException {
        C0293a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private ko(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.adT = i + i2;
    }

    /* renamed from: A */
    public static int m1130A(long j) {
        return m1132D(j);
    }

    /* renamed from: B */
    public static int m1131B(long j) {
        return m1132D(m1134E(j));
    }

    /* renamed from: D */
    public static int m1132D(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: E */
    public static int m1133E(boolean z) {
        return 1;
    }

    /* renamed from: E */
    public static long m1134E(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: b */
    public static int m1135b(int i, kt ktVar) {
        return cZ(i) + m1139c(ktVar);
    }

    /* renamed from: b */
    public static int m1136b(int i, boolean z) {
        return cZ(i) + m1133E(z);
    }

    /* renamed from: b */
    public static ko m1137b(byte[] bArr, int i, int i2) {
        return new ko(bArr, i, i2);
    }

    /* renamed from: c */
    public static int m1138c(int i, float f) {
        return cZ(i) + m1141e(f);
    }

    /* renamed from: c */
    public static int m1139c(kt ktVar) {
        int c = ktVar.mo2700c();
        return c + db(c);
    }

    public static int cX(int i) {
        return i >= 0 ? db(i) : 10;
    }

    public static int cZ(int i) {
        return db(kw.m1178l(i, 0));
    }

    public static int cf(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + db(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: d */
    public static int m1140d(int i, long j) {
        return cZ(i) + m1130A(j);
    }

    public static int db(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    /* renamed from: e */
    public static int m1141e(float f) {
        return 4;
    }

    /* renamed from: e */
    public static int m1142e(int i, long j) {
        return cZ(i) + m1131B(j);
    }

    /* renamed from: g */
    public static int m1143g(int i, String str) {
        return cZ(i) + cf(str);
    }

    /* renamed from: j */
    public static int m1144j(int i, int i2) {
        return cZ(i) + cX(i2);
    }

    /* renamed from: o */
    public static ko m1145o(byte[] bArr) {
        return m1137b(bArr, 0, bArr.length);
    }

    /* renamed from: C */
    public void m1146C(long j) throws IOException {
        while ((-128 & j) != 0) {
            cY((((int) j) & 127) | 128);
            j >>>= 7;
        }
        cY((int) j);
    }

    /* renamed from: D */
    public void m1147D(boolean z) throws IOException {
        cY(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m1148a(int i, kt ktVar) throws IOException {
        m1159k(i, 2);
        m1154b(ktVar);
    }

    /* renamed from: a */
    public void m1149a(int i, boolean z) throws IOException {
        m1159k(i, 0);
        m1147D(z);
    }

    /* renamed from: b */
    public void m1150b(byte b) throws IOException {
        if (this.position == this.adT) {
            throw new C0293a(this.position, this.adT);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void m1151b(int i, float f) throws IOException {
        m1159k(i, 5);
        m1157d(f);
    }

    /* renamed from: b */
    public void m1152b(int i, long j) throws IOException {
        m1159k(i, 0);
        m1161y(j);
    }

    /* renamed from: b */
    public void m1153b(int i, String str) throws IOException {
        m1159k(i, 2);
        ce(str);
    }

    /* renamed from: b */
    public void m1154b(kt ktVar) throws IOException {
        da(ktVar.mF());
        ktVar.mo1865a(this);
    }

    /* renamed from: c */
    public void m1155c(int i, long j) throws IOException {
        m1159k(i, 0);
        m1162z(j);
    }

    /* renamed from: c */
    public void m1156c(byte[] bArr, int i, int i2) throws IOException {
        if (this.adT - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C0293a(this.position, this.adT);
    }

    public void cW(int i) throws IOException {
        if (i >= 0) {
            da(i);
        } else {
            m1146C((long) i);
        }
    }

    public void cY(int i) throws IOException {
        m1150b((byte) i);
    }

    public void ce(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        da(bytes.length);
        m1160p(bytes);
    }

    /* renamed from: d */
    public void m1157d(float f) throws IOException {
        dc(Float.floatToIntBits(f));
    }

    public void da(int i) throws IOException {
        while ((i & -128) != 0) {
            cY((i & 127) | 128);
            i >>>= 7;
        }
        cY(i);
    }

    public void dc(int i) throws IOException {
        cY(i & 255);
        cY((i >> 8) & 255);
        cY((i >> 16) & 255);
        cY((i >> 24) & 255);
    }

    /* renamed from: i */
    public void m1158i(int i, int i2) throws IOException {
        m1159k(i, 0);
        cW(i2);
    }

    /* renamed from: k */
    public void m1159k(int i, int i2) throws IOException {
        da(kw.m1178l(i, i2));
    }

    public int mv() {
        return this.adT - this.position;
    }

    public void mw() {
        if (mv() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: p */
    public void m1160p(byte[] bArr) throws IOException {
        m1156c(bArr, 0, bArr.length);
    }

    /* renamed from: y */
    public void m1161y(long j) throws IOException {
        m1146C(j);
    }

    /* renamed from: z */
    public void m1162z(long j) throws IOException {
        m1146C(m1134E(j));
    }
}
