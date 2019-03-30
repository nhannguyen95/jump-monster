package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0205a;
import com.google.android.gms.internal.C0209b;
import com.google.android.gms.internal.C0239d.C0969a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID = C0205a.HASH.toString();
    private static final String XQ = C0209b.ARG0.toString();
    private static final String XS = C0209b.INPUT_FORMAT.toString();
    private static final String XW = C0209b.ALGORITHM.toString();

    public ao() {
        super(ID, XQ);
    }

    /* renamed from: c */
    private byte[] m2442c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean jX() {
        return true;
    }

    /* renamed from: x */
    public C0969a mo2240x(Map<String, C0969a> map) {
        C0969a c0969a = (C0969a) map.get(XQ);
        if (c0969a == null || c0969a == dh.lT()) {
            return dh.lT();
        }
        byte[] bytes;
        String j = dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(XW);
        String j2 = c0969a == null ? "MD5" : dh.m1461j(c0969a);
        c0969a = (C0969a) map.get(XS);
        String j3 = c0969a == null ? "text" : dh.m1461j(c0969a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0406j.bm(j);
        } else {
            bh.m1385w("Hash: unknown input format: " + j3);
            return dh.lT();
        }
        try {
            return dh.m1472r(C0406j.m1480d(m2442c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m1385w("Hash: unknown algorithm: " + j2);
            return dh.lT();
        }
    }
}
