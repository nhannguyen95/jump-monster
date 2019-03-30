package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fq;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0135b {
    protected final DataHolder BB;
    protected final int BD;
    private final int BE;

    public C0135b(DataHolder dataHolder, int i) {
        this.BB = (DataHolder) fq.m986f(dataHolder);
        boolean z = i >= 0 && i < dataHolder.getCount();
        fq.m987x(z);
        this.BD = i;
        this.BE = dataHolder.m1681G(this.BD);
    }

    /* renamed from: a */
    protected void m143a(String str, CharArrayBuffer charArrayBuffer) {
        this.BB.copyToBuffer(str, this.BD, this.BE, charArrayBuffer);
    }

    protected Uri ah(String str) {
        return this.BB.parseUri(str, this.BD, this.BE);
    }

    protected boolean ai(String str) {
        return this.BB.hasNull(str, this.BD, this.BE);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0135b)) {
            return false;
        }
        C0135b c0135b = (C0135b) obj;
        return fo.equal(Integer.valueOf(c0135b.BD), Integer.valueOf(this.BD)) && fo.equal(Integer.valueOf(c0135b.BE), Integer.valueOf(this.BE)) && c0135b.BB == this.BB;
    }

    protected boolean getBoolean(String column) {
        return this.BB.getBoolean(column, this.BD, this.BE);
    }

    protected byte[] getByteArray(String column) {
        return this.BB.getByteArray(column, this.BD, this.BE);
    }

    protected int getInteger(String column) {
        return this.BB.getInteger(column, this.BD, this.BE);
    }

    protected long getLong(String column) {
        return this.BB.getLong(column, this.BD, this.BE);
    }

    protected String getString(String column) {
        return this.BB.getString(column, this.BD, this.BE);
    }

    public boolean hasColumn(String column) {
        return this.BB.hasColumn(column);
    }

    public int hashCode() {
        return fo.hashCode(Integer.valueOf(this.BD), Integer.valueOf(this.BE), this.BB);
    }

    public boolean isDataValid() {
        return !this.BB.isClosed();
    }
}
