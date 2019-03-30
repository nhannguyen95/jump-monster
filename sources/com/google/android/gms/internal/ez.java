package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.net.Uri;
import android.widget.ImageView;

public final class ez extends ImageView {
    private Uri CO;
    private int CP;
    private int CQ;

    /* renamed from: L */
    public void m916L(int i) {
        this.CP = i;
    }

    /* renamed from: e */
    public void m917e(Uri uri) {
        this.CO = uri;
    }

    public int eB() {
        return this.CP;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.CQ != 0) {
            canvas.drawColor(this.CQ);
        }
    }
}
