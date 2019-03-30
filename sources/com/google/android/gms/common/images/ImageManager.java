package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C0142a.C0141a;
import com.google.android.gms.common.images.C0142a.C0553b;
import com.google.android.gms.common.images.C0142a.C0554c;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.gr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object BY = new Object();
    private static HashSet<Uri> BZ = new HashSet();
    private static ImageManager Ca;
    private static ImageManager Cb;
    private final ExecutorService Cc = Executors.newFixedThreadPool(4);
    private final C0552b Cd;
    private final fa Ce;
    private final Map<C0142a, ImageReceiver> Cf;
    private final Map<Uri, ImageReceiver> Cg;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList<C0142a> Ch = new ArrayList();
        final /* synthetic */ ImageManager Ci;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.Ci = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        /* renamed from: b */
        public void m145b(C0142a c0142a) {
            fb.aj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Ch.add(c0142a);
        }

        /* renamed from: c */
        public void m146c(C0142a c0142a) {
            fb.aj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Ch.remove(c0142a);
        }

        public void ey() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.Ci.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.Ci.Cc.execute(new C0137c(this.Ci, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$a */
    private static final class C0136a {
        /* renamed from: a */
        static int m147a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$c */
    private final class C0137c implements Runnable {
        final /* synthetic */ ImageManager Ci;
        private final ParcelFileDescriptor Cj;
        private final Uri mUri;

        public C0137c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.Ci = imageManager;
            this.mUri = uri;
            this.Cj = parcelFileDescriptor;
        }

        public void run() {
            fb.ak("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.Cj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.Cj.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.Cj.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.Ci.mHandler.post(new C0140f(this.Ci, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$d */
    private final class C0138d implements Runnable {
        final /* synthetic */ ImageManager Ci;
        private final C0142a Ck;

        public C0138d(ImageManager imageManager, C0142a c0142a) {
            this.Ci = imageManager;
            this.Ck = c0142a;
        }

        public void run() {
            fb.aj("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.Ci.Cf.get(this.Ck);
            if (imageReceiver != null) {
                this.Ci.Cf.remove(this.Ck);
                imageReceiver.m146c(this.Ck);
            }
            C0141a c0141a = this.Ck.Cm;
            if (c0141a.uri == null) {
                this.Ck.m166a(this.Ci.mContext, this.Ci.Ce, true);
                return;
            }
            Bitmap a = this.Ci.m150a(c0141a);
            if (a != null) {
                this.Ck.m164a(this.Ci.mContext, a, true);
                return;
            }
            this.Ck.m165a(this.Ci.mContext, this.Ci.Ce);
            imageReceiver = (ImageReceiver) this.Ci.Cg.get(c0141a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.Ci, c0141a.uri);
                this.Ci.Cg.put(c0141a.uri, imageReceiver);
            }
            imageReceiver.m145b(this.Ck);
            if (!(this.Ck instanceof C0554c)) {
                this.Ci.Cf.put(this.Ck, imageReceiver);
            }
            synchronized (ImageManager.BY) {
                if (!ImageManager.BZ.contains(c0141a.uri)) {
                    ImageManager.BZ.add(c0141a.uri);
                    imageReceiver.ey();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$e */
    private static final class C0139e implements ComponentCallbacks2 {
        private final C0552b Cd;

        public C0139e(C0552b c0552b) {
            this.Cd = c0552b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Cd.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Cd.evictAll();
            } else if (level >= 20) {
                this.Cd.trimToSize(this.Cd.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$f */
    private final class C0140f implements Runnable {
        private final CountDownLatch AD;
        final /* synthetic */ ImageManager Ci;
        private boolean Cl;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public C0140f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.Ci = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.Cl = z;
            this.AD = countDownLatch;
        }

        /* renamed from: a */
        private void m148a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.Ch;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C0142a c0142a = (C0142a) a.get(i);
                if (z) {
                    c0142a.m164a(this.Ci.mContext, this.mBitmap, false);
                } else {
                    c0142a.m166a(this.Ci.mContext, this.Ci.Ce, false);
                }
                if (!(c0142a instanceof C0554c)) {
                    this.Ci.Cf.remove(c0142a);
                }
            }
        }

        public void run() {
            fb.aj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.Ci.Cd != null) {
                if (this.Cl) {
                    this.Ci.Cd.evictAll();
                    System.gc();
                    this.Cl = false;
                    this.Ci.mHandler.post(this);
                    return;
                } else if (z) {
                    this.Ci.Cd.put(new C0141a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.Ci.Cg.remove(this.mUri);
            if (imageReceiver != null) {
                m148a(imageReceiver, z);
            }
            this.AD.countDown();
            synchronized (ImageManager.BY) {
                ImageManager.BZ.remove(this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager$b */
    private static final class C0552b extends fu<C0141a, Bitmap> {
        public C0552b(Context context) {
            super(C0552b.m1687w(context));
        }

        /* renamed from: w */
        private static int m1687w(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0 ? 1 : null) == null || !gr.fu()) ? activityManager.getMemoryClass() : C0136a.m147a(activityManager);
            return (int) (((float) (memoryClass * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* renamed from: a */
        protected int m1688a(C0141a c0141a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* renamed from: a */
        protected void m1689a(boolean z, C0141a c0141a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c0141a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m1689a(x0, (C0141a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m1688a((C0141a) x0, (Bitmap) x1);
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.Cd = new C0552b(this.mContext);
            if (gr.fx()) {
                ev();
            }
        } else {
            this.Cd = null;
        }
        this.Ce = new fa();
        this.Cf = new HashMap();
        this.Cg = new HashMap();
    }

    /* renamed from: a */
    private Bitmap m150a(C0141a c0141a) {
        return this.Cd == null ? null : (Bitmap) this.Cd.get(c0141a);
    }

    /* renamed from: a */
    public static ImageManager m151a(Context context, boolean z) {
        if (z) {
            if (Cb == null) {
                Cb = new ImageManager(context, true);
            }
            return Cb;
        }
        if (Ca == null) {
            Ca = new ImageManager(context, false);
        }
        return Ca;
    }

    public static ImageManager create(Context context) {
        return m151a(context, false);
    }

    private void ev() {
        this.mContext.registerComponentCallbacks(new C0139e(this.Cd));
    }

    /* renamed from: a */
    public void m159a(C0142a c0142a) {
        fb.aj("ImageManager.loadImage() must be called in the main thread");
        new C0138d(this, c0142a).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        m159a(new C0553b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        m159a(new C0553b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C0142a c0553b = new C0553b(imageView, uri);
        c0553b.m161J(defaultResId);
        m159a(c0553b);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        m159a(new C0554c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C0142a c0554c = new C0554c(listener, uri);
        c0554c.m161J(defaultResId);
        m159a(c0554c);
    }
}
