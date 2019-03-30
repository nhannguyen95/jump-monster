package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.p */
public class C0299p {
    private final C0296n jP;
    private final SecureRandom ki;

    /* renamed from: com.google.android.gms.internal.p$a */
    public class C0298a extends Exception {
        final /* synthetic */ C0299p kj;

        public C0298a(C0299p c0299p) {
            this.kj = c0299p;
        }

        public C0298a(C0299p c0299p, Throwable th) {
            this.kj = c0299p;
            super(th);
        }
    }

    public C0299p(C0296n c0296n, SecureRandom secureRandom) {
        this.jP = c0296n;
        this.ki = secureRandom;
    }

    /* renamed from: c */
    static void m1190c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: b */
    public byte[] m1191b(String str) throws C0298a {
        try {
            byte[] a = this.jP.mo1686a(str, false);
            if (a.length != 32) {
                throw new C0298a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C0299p.m1190c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C0298a(this, e);
        }
    }

    /* renamed from: c */
    public byte[] m1192c(byte[] bArr, String str) throws C0298a {
        if (bArr.length != 16) {
            throw new C0298a(this);
        }
        try {
            byte[] a = this.jP.mo1686a(str, false);
            if (a.length <= 16) {
                throw new C0298a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C0298a(this, e);
        } catch (Throwable e2) {
            throw new C0298a(this, e2);
        } catch (Throwable e22) {
            throw new C0298a(this, e22);
        } catch (Throwable e222) {
            throw new C0298a(this, e222);
        } catch (Throwable e2222) {
            throw new C0298a(this, e2222);
        } catch (Throwable e22222) {
            throw new C0298a(this, e22222);
        } catch (Throwable e222222) {
            throw new C0298a(this, e222222);
        }
    }
}
