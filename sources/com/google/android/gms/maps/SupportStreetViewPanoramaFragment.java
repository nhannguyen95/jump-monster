package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.C0188a;
import com.google.android.gms.dynamic.C0191f;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C0334t;
import com.google.android.gms.maps.internal.C0335u;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private StreetViewPanorama Sj;
    private final C0710b Sx = new C0710b(this);

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment$a */
    static class C0709a implements LifecycleDelegate {
        private final Fragment Hz;
        private final IStreetViewPanoramaFragmentDelegate Sk;

        public C0709a(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.Sk = (IStreetViewPanoramaFragmentDelegate) fq.m986f(iStreetViewPanoramaFragmentDelegate);
            this.Hz = (Fragment) fq.m986f(fragment);
        }

        public IStreetViewPanoramaFragmentDelegate is() {
            return this.Sk;
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.Hz.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                C0334t.m1247a(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.Sk.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0926e.m2695d(this.Sk.onCreateView(C0926e.m2696h(inflater), C0926e.m2696h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.Sk.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.Sk.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.Sk.onInflate(C0926e.m2696h(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.Sk.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.Sk.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.Sk.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.Sk.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportStreetViewPanoramaFragment$b */
    static class C0710b extends C0188a<C0709a> {
        private final Fragment Hz;
        protected C0191f<C0709a> RV;
        private Activity nS;

        C0710b(Fragment fragment) {
            this.Hz = fragment;
        }

        private void setActivity(Activity activity) {
            this.nS = activity;
            ip();
        }

        /* renamed from: a */
        protected void mo1891a(C0191f<C0709a> c0191f) {
            this.RV = c0191f;
            ip();
        }

        public void ip() {
            if (this.nS != null && this.RV != null && fW() == null) {
                try {
                    MapsInitializer.initialize(this.nS);
                    this.RV.mo1162a(new C0709a(this.Hz, C0335u.m1248A(this.nS).mo2040i(C0926e.m2696h(this.nS))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate is = is();
        if (is == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = is.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.Sj == null || this.Sj.ir().asBinder() != streetViewPanorama.asBinder()) {
                this.Sj = new StreetViewPanorama(streetViewPanorama);
            }
            return this.Sj;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IStreetViewPanoramaFragmentDelegate is() {
        this.Sx.ip();
        return this.Sx.fW() == null ? null : ((C0709a) this.Sx.fW()).is();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Sx.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.Sx.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.Sx.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.Sx.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Sx.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.Sx.setActivity(activity);
        this.Sx.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.Sx.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Sx.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Sx.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.Sx.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
