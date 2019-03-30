package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0076R;

public final class fs extends Button {
    public fs(Context context) {
        this(context, null);
    }

    public fs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: b */
    private int m989b(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    /* renamed from: b */
    private void m990b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case 0:
            case 1:
                b = m989b(i2, C0076R.drawable.common_signin_btn_text_dark, C0076R.drawable.common_signin_btn_text_light);
                break;
            case 2:
                b = m989b(i2, C0076R.drawable.common_signin_btn_icon_dark, C0076R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    /* renamed from: c */
    private void m991c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    /* renamed from: c */
    private void m992c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m989b(i2, C0076R.color.common_signin_btn_text_dark, C0076R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0076R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0076R.string.common_signin_button_text_long));
                return;
            case 2:
                setText(null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    /* renamed from: a */
    public void m993a(Resources resources, int i, int i2) {
        boolean z = true;
        boolean z2 = i >= 0 && i < 3;
        fq.m981a(z2, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        fq.m981a(z, "Unknown color scheme " + i2);
        m991c(resources);
        m990b(resources, i, i2);
        m992c(resources, i, i2);
    }
}
