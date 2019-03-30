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
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class MapView extends FrameLayout {
    private GoogleMap RT;
    private final C0702b RW;

    /* renamed from: com.google.android.gms.maps.MapView$a */
    static class C0701a implements LifecycleDelegate {
        private final ViewGroup RX;
        private final IMapViewDelegate RY;
        private View RZ;

        public C0701a(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.RY = (IMapViewDelegate) fq.m986f(iMapViewDelegate);
            this.RX = (ViewGroup) fq.m986f(viewGroup);
        }

        public IMapViewDelegate iq() {
            return this.RY;
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.RY.onCreate(savedInstanceState);
                this.RZ = (View) C0926e.m2695d(this.RY.getView());
                this.RX.removeAllViews();
                this.RX.addView(this.RZ);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.RY.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.RY.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.RY.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.RY.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.RY.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.MapView$b */
    static class C0702b extends C0188a<C0701a> {
        protected C0191f<C0701a> RV;
        private final ViewGroup Sa;
        private final GoogleMapOptions Sb;
        private final Context mContext;

        C0702b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.Sa = viewGroup;
            this.mContext = context;
            this.Sb = googleMapOptions;
        }

        /* renamed from: a */
        protected void mo1891a(C0191f<C0701a> c0191f) {
            this.RV = c0191f;
            ip();
        }

        public void ip() {
            if (this.RV != null && fW() == null) {
                try {
                    this.RV.mo1162a(new C0701a(this.Sa, C0335u.m1248A(this.mContext).mo2035a(C0926e.m2696h(this.mContext), this.Sb)));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.RW = new C0702b(this, context, null);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.RW = new C0702b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.RW = new C0702b(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.RW = new C0702b(this, context, options);
    }

    public final GoogleMap getMap() {
        if (this.RT != null) {
            return this.RT;
        }
        this.RW.ip();
        if (this.RW.fW() == null) {
            return null;
        }
        try {
            this.RT = new GoogleMap(((C0701a) this.RW.fW()).iq().getMap());
            return this.RT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.RW.onCreate(savedInstanceState);
        if (this.RW.fW() == null) {
            C0702b c0702b = this.RW;
            C0188a.m353b((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.RW.onDestroy();
    }

    public final void onLowMemory() {
        this.RW.onLowMemory();
    }

    public final void onPause() {
        this.RW.onPause();
    }

    public final void onResume() {
        this.RW.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.RW.onSaveInstanceState(outState);
    }
}
