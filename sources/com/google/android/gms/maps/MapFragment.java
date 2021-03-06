package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
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

public class MapFragment extends Fragment {
    private final C0700b RS = new C0700b(this);
    private GoogleMap RT;

    /* renamed from: com.google.android.gms.maps.MapFragment$a */
    static class C0699a implements LifecycleDelegate {
        private final Fragment Hv;
        private final IMapFragmentDelegate RU;

        public C0699a(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.RU = (IMapFragmentDelegate) fq.m986f(iMapFragmentDelegate);
            this.Hv = (Fragment) fq.m986f(fragment);
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
            Bundle arguments = this.Hv.getArguments();
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

    /* renamed from: com.google.android.gms.maps.MapFragment$b */
    static class C0700b extends C0188a<C0699a> {
        private final Fragment Hv;
        protected C0191f<C0699a> RV;
        private Activity nS;

        C0700b(Fragment fragment) {
            this.Hv = fragment;
        }

        private void setActivity(Activity activity) {
            this.nS = activity;
            ip();
        }

        /* renamed from: a */
        protected void mo1891a(C0191f<C0699a> c0191f) {
            this.RV = c0191f;
            ip();
        }

        public void ip() {
            if (this.nS != null && this.RV != null && fW() == null) {
                try {
                    MapsInitializer.initialize(this.nS);
                    this.RV.mo1162a(new C0699a(this.Hv, C0335u.m1248A(this.nS).mo2039h(C0926e.m2696h(this.nS))));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions options) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", options);
        mapFragment.setArguments(bundle);
        return mapFragment;
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
        this.RS.ip();
        return this.RS.fW() == null ? null : ((C0699a) this.RS.fW()).io();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.RS.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.RS.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.RS.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.RS.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.RS.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.RS.setActivity(activity);
        Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attrs);
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", createFromAttributes);
        this.RS.onInflate(activity, bundle, savedInstanceState);
    }

    public void onLowMemory() {
        this.RS.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.RS.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.RS.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.RS.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }
}
