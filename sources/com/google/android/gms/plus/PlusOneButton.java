package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.fq;
import com.google.android.gms.internal.ft;
import com.google.android.gms.plus.internal.C0365g;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private View TT;
    private int TU;
    private int TV;
    private OnPlusOneClickListener TW;
    private int mSize;
    private String ro;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener TX;
        final /* synthetic */ PlusOneButton TY;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.TY = plusOneButton;
            this.TX = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.TY.TT.getTag();
            if (this.TX != null) {
                this.TX.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.TY.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.TY.TV);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.TU = getAnnotation(context, attrs);
        this.TV = -1;
        m1296v(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String a = ft.m994a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(a)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(a) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String a = ft.m994a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(a)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(a)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(a) ? 2 : 3;
    }

    /* renamed from: v */
    private void m1296v(Context context) {
        if (this.TT != null) {
            removeView(this.TT);
        }
        this.TT = C0365g.m1324a(context, this.mSize, this.TU, this.ro, this.TV);
        setOnPlusOneClickListener(this.TW);
        addView(this.TT);
    }

    public void initialize(String url, int activityRequestCode) {
        fq.m981a(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.ro = url;
        this.TV = activityRequestCode;
        m1296v(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.ro = url;
        this.TV = 0;
        m1296v(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.TT.layout(0, 0, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.TT;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setAnnotation(int annotation) {
        this.TU = annotation;
        m1296v(getContext());
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.TW = listener;
        this.TT.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        m1296v(getContext());
    }
}
