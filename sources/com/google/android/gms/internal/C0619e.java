package com.google.android.gms.internal;

import android.util.Base64;

/* renamed from: com.google.android.gms.internal.e */
class C0619e implements C0296n {
    C0619e() {
    }

    /* renamed from: a */
    public String mo1685a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    /* renamed from: a */
    public byte[] mo1686a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
