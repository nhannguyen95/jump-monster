package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0188a;
import com.google.android.gms.dynamic.C0191f;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C0335u;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class StreetViewPanoramaView extends FrameLayout {
    private StreetViewPanorama Sj;
    private final C0705a Ss;

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$a */
    static class C0705a extends C0188a<C0706b> {
        protected C0191f<C0706b> RV;
        private final ViewGroup Sa;
        private final StreetViewPanoramaOptions St;
        private final Context mContext;

        C0705a(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.Sa = viewGroup;
            this.mContext = context;
            this.St = streetViewPanoramaOptions;
        }

        /* renamed from: a */
        protected void mo1891a(C0191f<C0706b> c0191f) {
            this.RV = c0191f;
            ip();
        }

        public void ip() {
            if (this.RV != null && fW() == null) {
                try {
                    this.RV.mo1162a(new C0706b(this.Sa, C0335u.m1248A(this.mContext).mo2036a(C0926e.m2696h(this.mContext), this.St)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView$b */
    static class C0706b implements LifecycleDelegate {
        private final ViewGroup RX;
        private final IStreetViewPanoramaViewDelegate Su;
        private View Sv;

        public C0706b(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.Su = (IStreetViewPanoramaViewDelegate) fq.m986f(iStreetViewPanoramaViewDelegate);
            this.RX = (ViewGroup) fq.m986f(viewGroup);
        }

        public IStreetViewPanoramaViewDelegate iw() {
            return this.Su;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.Su.onCreate(savedInstanceState);
                this.Sv = (View) C0926e.m2695d(this.Su.getView());
                this.RX.removeAllViews();
                this.RX.addView(this.Sv);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.Su.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.Su.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.Su.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.Su.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.Su.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.Ss = new C0705a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.Ss = new C0705a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.Ss = new C0705a(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.Ss = new C0705a(this, context, options);
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.Sj != null) {
            return this.Sj;
        }
        this.Ss.ip();
        if (this.Ss.fW() == null) {
            return null;
        }
        try {
            this.Sj = new StreetViewPanorama(((C0706b) this.Ss.fW()).iw().getStreetViewPanorama());
            return this.Sj;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.Ss.onCreate(savedInstanceState);
        if (this.Ss.fW() == null) {
            C0705a c0705a = this.Ss;
            C0188a.m353b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.Ss.onDestroy();
    }

    public final void onLowMemory() {
        this.Ss.onLowMemory();
    }

    public final void onPause() {
        this.Ss.onPause();
    }

    public final void onResume() {
        this.Ss.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.Ss.onSaveInstanceState(outState);
    }
}
