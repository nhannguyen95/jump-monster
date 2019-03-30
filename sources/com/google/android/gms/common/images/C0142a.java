package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.badlogic.gdx.Input.Keys;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.internal.ex;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fa.C0273a;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.images.a */
public abstract class C0142a {
    final C0141a Cm;
    protected int Cn = 0;
    protected int Co = 0;
    private boolean Cp = true;
    private boolean Cq = false;
    protected int Cr;

    /* renamed from: com.google.android.gms.common.images.a$a */
    static final class C0141a {
        public final Uri uri;

        public C0141a(Uri uri) {
            this.uri = uri;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0141a) {
                return this == obj ? true : fo.equal(((C0141a) obj).uri, this.uri);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return fo.hashCode(this.uri);
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$b */
    public static final class C0553b extends C0142a {
        private WeakReference<ImageView> Cs;

        public C0553b(ImageView imageView, int i) {
            super(null, i);
            fb.m921d(imageView);
            this.Cs = new WeakReference(imageView);
        }

        public C0553b(ImageView imageView, Uri uri) {
            super(uri, 0);
            fb.m921d(imageView);
            this.Cs = new WeakReference(imageView);
        }

        /* renamed from: a */
        private void m1691a(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            Object obj = (z2 || z3) ? null : 1;
            if (obj != null && (imageView instanceof ez)) {
                int eB = ((ez) imageView).eB();
                if (this.Co != 0 && eB == this.Co) {
                    return;
                }
            }
            boolean b = m168b(z, z2);
            Drawable a = b ? m163a(imageView.getDrawable(), drawable) : drawable;
            imageView.setImageDrawable(a);
            if (imageView instanceof ez) {
                ez ezVar = (ez) imageView;
                ezVar.m917e(z3 ? this.Cm.uri : null);
                ezVar.m916L(obj != null ? this.Co : 0);
            }
            if (b) {
                ((ex) a).startTransition(Keys.F7);
            }
        }

        /* renamed from: a */
        protected void mo1109a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.Cs.get();
            if (imageView != null) {
                m1691a(imageView, drawable, z, z2, z3);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0553b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.Cs.get();
            ImageView imageView2 = (ImageView) ((C0553b) obj).Cs.get();
            boolean z = (imageView2 == null || imageView == null || !fo.equal(imageView2, imageView)) ? false : true;
            return z;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.common.images.a$c */
    public static final class C0554c extends C0142a {
        private WeakReference<OnImageLoadedListener> Ct;

        public C0554c(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            fb.m921d(onImageLoadedListener);
            this.Ct = new WeakReference(onImageLoadedListener);
        }

        /* renamed from: a */
        protected void mo1109a(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ct.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.Cm.uri, drawable, z3);
                }
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0554c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0554c c0554c = (C0554c) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.Ct.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) c0554c.Ct.get();
            boolean z = onImageLoadedListener2 != null && onImageLoadedListener != null && fo.equal(onImageLoadedListener2, onImageLoadedListener) && fo.equal(c0554c.Cm, this.Cm);
            return z;
        }

        public int hashCode() {
            return fo.hashCode(this.Cm);
        }
    }

    public C0142a(Uri uri, int i) {
        this.Cm = new C0141a(uri);
        this.Co = i;
    }

    /* renamed from: a */
    private Drawable m160a(Context context, fa faVar, int i) {
        Resources resources = context.getResources();
        if (this.Cr <= 0) {
            return resources.getDrawable(i);
        }
        C0273a c0273a = new C0273a(i, this.Cr);
        Drawable drawable = (Drawable) faVar.get(c0273a);
        if (drawable != null) {
            return drawable;
        }
        drawable = resources.getDrawable(i);
        if ((this.Cr & 1) != 0) {
            drawable = m162a(resources, drawable);
        }
        faVar.put(c0273a, drawable);
        return drawable;
    }

    /* renamed from: J */
    public void m161J(int i) {
        this.Co = i;
    }

    /* renamed from: a */
    protected Drawable m162a(Resources resources, Drawable drawable) {
        return ey.m915a(resources, drawable);
    }

    /* renamed from: a */
    protected ex m163a(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof ex) {
            drawable = ((ex) drawable).ez();
        }
        return new ex(drawable, drawable2);
    }

    /* renamed from: a */
    void m164a(Context context, Bitmap bitmap, boolean z) {
        fb.m921d(bitmap);
        if ((this.Cr & 1) != 0) {
            bitmap = ey.m913a(bitmap);
        }
        mo1109a(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* renamed from: a */
    void m165a(Context context, fa faVar) {
        Drawable drawable = null;
        if (this.Cn != 0) {
            drawable = m160a(context, faVar, this.Cn);
        }
        mo1109a(drawable, false, true, false);
    }

    /* renamed from: a */
    void m166a(Context context, fa faVar, boolean z) {
        Drawable drawable = null;
        if (this.Co != 0) {
            drawable = m160a(context, faVar, this.Co);
        }
        mo1109a(drawable, z, false, false);
    }

    /* renamed from: a */
    protected abstract void mo1109a(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* renamed from: b */
    protected boolean m168b(boolean z, boolean z2) {
        return this.Cp && !z2 && (!z || this.Cq);
    }
}
