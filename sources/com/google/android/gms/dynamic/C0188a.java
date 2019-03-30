package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C0188a<T extends LifecycleDelegate> {
    private T Hj;
    private Bundle Hk;
    private LinkedList<C0187a> Hl;
    private final C0191f<T> Hm = new C05661(this);

    /* renamed from: com.google.android.gms.dynamic.a$a */
    private interface C0187a {
        /* renamed from: b */
        void mo1163b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a$1 */
    class C05661 implements C0191f<T> {
        final /* synthetic */ C0188a Hn;

        C05661(C0188a c0188a) {
            this.Hn = c0188a;
        }

        /* renamed from: a */
        public void mo1162a(T t) {
            this.Hn.Hj = t;
            Iterator it = this.Hn.Hl.iterator();
            while (it.hasNext()) {
                ((C0187a) it.next()).mo1163b(this.Hn.Hj);
            }
            this.Hn.Hl.clear();
            this.Hn.Hk = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a$6 */
    class C05706 implements C0187a {
        final /* synthetic */ C0188a Hn;

        C05706(C0188a c0188a) {
            this.Hn = c0188a;
        }

        /* renamed from: b */
        public void mo1163b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a$7 */
    class C05717 implements C0187a {
        final /* synthetic */ C0188a Hn;

        C05717(C0188a c0188a) {
            this.Hn = c0188a;
        }

        /* renamed from: b */
        public void mo1163b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    /* renamed from: a */
    private void m351a(Bundle bundle, C0187a c0187a) {
        if (this.Hj != null) {
            c0187a.mo1163b(this.Hj);
            return;
        }
        if (this.Hl == null) {
            this.Hl = new LinkedList();
        }
        this.Hl.add(c0187a);
        if (bundle != null) {
            if (this.Hk == null) {
                this.Hk = (Bundle) bundle.clone();
            } else {
                this.Hk.putAll(bundle);
            }
        }
        mo1891a(this.Hm);
    }

    private void aR(int i) {
        while (!this.Hl.isEmpty() && ((C0187a) this.Hl.getLast()).getState() >= i) {
            this.Hl.removeLast();
        }
    }

    /* renamed from: b */
    public static void m353b(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence c = GooglePlayServicesUtil.m114c(context, isGooglePlayServicesAvailable);
        CharSequence d = GooglePlayServicesUtil.m116d(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(c);
        linearLayout.addView(textView);
        if (d != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(d);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.m110b(context, isGooglePlayServicesAvailable));
                }
            });
        }
    }

    /* renamed from: a */
    protected void mo2307a(FrameLayout frameLayout) {
        C0188a.m353b(frameLayout);
    }

    /* renamed from: a */
    protected abstract void mo1891a(C0191f<T> c0191f);

    public T fW() {
        return this.Hj;
    }

    public void onCreate(final Bundle savedInstanceState) {
        m351a(savedInstanceState, new C0187a(this) {
            final /* synthetic */ C0188a Hn;

            /* renamed from: b */
            public void mo1163b(LifecycleDelegate lifecycleDelegate) {
                this.Hn.Hj.onCreate(savedInstanceState);
            }

            public int getState() {
                return 1;
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        m351a(savedInstanceState, new C0187a(this) {
            final /* synthetic */ C0188a Hn;

            /* renamed from: b */
            public void mo1163b(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(this.Hn.Hj.onCreateView(layoutInflater, viewGroup, bundle));
            }

            public int getState() {
                return 2;
            }
        });
        if (this.Hj == null) {
            mo2307a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Hj != null) {
            this.Hj.onDestroy();
        } else {
            aR(1);
        }
    }

    public void onDestroyView() {
        if (this.Hj != null) {
            this.Hj.onDestroyView();
        } else {
            aR(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        m351a(savedInstanceState, new C0187a(this) {
            final /* synthetic */ C0188a Hn;

            /* renamed from: b */
            public void mo1163b(LifecycleDelegate lifecycleDelegate) {
                this.Hn.Hj.onInflate(activity, attrs, savedInstanceState);
            }

            public int getState() {
                return 0;
            }
        });
    }

    public void onLowMemory() {
        if (this.Hj != null) {
            this.Hj.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Hj != null) {
            this.Hj.onPause();
        } else {
            aR(5);
        }
    }

    public void onResume() {
        m351a(null, new C05717(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Hj != null) {
            this.Hj.onSaveInstanceState(outState);
        } else if (this.Hk != null) {
            outState.putAll(this.Hk);
        }
    }

    public void onStart() {
        m351a(null, new C05706(this));
    }

    public void onStop() {
        if (this.Hj != null) {
            this.Hj.onStop();
        } else {
            aR(4);
        }
    }
}
