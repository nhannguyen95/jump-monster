package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.C0193g.C0192a;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.fr;
import com.google.android.gms.internal.fs;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int Av;
    private View Aw;
    private OnClickListener Ax;
    private int mSize;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.Ax = null;
        setStyle(0, 0);
    }

    /* renamed from: a */
    private static Button m121a(Context context, int i, int i2) {
        Button fsVar = new fs(context);
        fsVar.m993a(context.getResources(), i, i2);
        return fsVar;
    }

    /* renamed from: v */
    private void m122v(Context context) {
        if (this.Aw != null) {
            removeView(this.Aw);
        }
        try {
            this.Aw = fr.m2208b(context, this.mSize, this.Av);
        } catch (C0192a e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.Aw = m121a(context, this.mSize, this.Av);
        }
        addView(this.Aw);
        this.Aw.setEnabled(isEnabled());
        this.Aw.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.Ax != null && view == this.Aw) {
            this.Ax.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.Aw.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.Ax = listener;
        if (this.Aw != null) {
            this.Aw.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.Av);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        boolean z = true;
        boolean z2 = buttonSize >= 0 && buttonSize < 3;
        fq.m981a(z2, "Unknown button size " + buttonSize);
        if (colorScheme < 0 || colorScheme >= 2) {
            z = false;
        }
        fq.m981a(z, "Unknown color scheme " + colorScheme);
        this.mSize = buttonSize;
        this.Av = colorScheme;
        m122v(getContext());
    }
}
