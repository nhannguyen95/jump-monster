package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class SupportMapFragment extends Fragment {
    private GoogleMap RT;
    private final C0708b Sw = new C0708b(this);

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$a */
    static class C0707a implements LifecycleDelegate {
        private final Fragment Hz;
        private final IMapFragmentDelegate RU;

        public C0707a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.RU = (IMapFragmentDelegate) fq.m986f(iMapFragmentDelegate);
            this.Hz = (Fragment) fq.m986f(fragment);
        }

        public IMapFragmentDelegate io() {
            return this.RU;
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
            if (arguments != null && arguments.containsKey("MapOptions")) {
                C0334t.m1247a(savedInstanceState, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.RU.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) C0926e.m2695d(this.RU.onCreateView(C0926e.m2696h(inflater), C0926e.m2696h(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.RU.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.RU.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.RU.onInflate(C0926e.m2696h(activity), (GoogleMapOptions) attrs.getParcelable("MapOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.RU.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.RU.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.RU.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.RU.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.maps.SupportMapFragment$b */
    static class C0708b extends C0188a<C0707a> {
        private final Fragment Hz;
        protected C0191f<C0707a> RV;
        private Activity nS;

        C0708b(Fragment fragment) {
            this.Hz = fragment;
        }

        private void setActivity(Activity activity) {
            this.nS = activity;
            ip();
        }

        /* renamed from: a */
        protected void mo1891a(C0191f<C0707a> c0191f) {
            this.RV = c0191f;
            ip();
        }

        public void ip() {
            if (this.nS != null && this.RV != null && fW() == null) {
                try {
                    MapsInitializer.initialize(this.nS);
                    this.RV.mo1162a(new C0707a(this.Hz, C0335u.m1248A(this.nS).mo2039h(C0926e.m2696h(this.nS))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public final GoogleMap getMap() {
        IMapFragmentDelegate io = io();
        if (io == null) {
            return null;
        }
        try {
            IGoogleMapDelegate map = io.getMap();
            if (map == null) {
                return null;
            }
            if (this.RT == null || this.RT.m1224if().asBinder() != map.asBinder()) {
                this.RT = new GoogleMap(map);
            }
            return this.RT;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    protected IMapFragmentDelegate io() {
        this.Sw.ip();
        return this.Sw.fW() == null ? null : ((C0707a) this.Sw.fW()).io();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.Sw.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.Sw.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.Sw.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.Sw.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.Sw.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.Sw.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.Sw.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.Sw.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.Sw.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.Sw.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.Sw.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
