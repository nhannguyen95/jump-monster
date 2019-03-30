package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C0330p.C0760a;
import com.google.android.gms.maps.internal.C0331q.C0762a;
import com.google.android.gms.maps.internal.C0332r.C0764a;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate Sd;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.Sd = (IStreetViewPanoramaDelegate) fq.m986f(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.Sd.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.Sd.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.Sd.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IStreetViewPanoramaDelegate ir() {
        return this.Sd;
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.Sd.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.Sd.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.Sd.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.Sd.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            return (Point) C0926e.m2695d(this.Sd.orientationToPoint(orientation));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.Sd.pointToOrientation(C0926e.m2696h(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.Sd.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Sd.setOnStreetViewPanoramaCameraChangeListener(new C0760a(this) {
            final /* synthetic */ StreetViewPanorama Sf;

            public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
                listener.onStreetViewPanoramaCameraChange(camera);
            }
        });
    }

    public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.Sd.setOnStreetViewPanoramaChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Sd.setOnStreetViewPanoramaChangeListener(new C0762a(this) {
            final /* synthetic */ StreetViewPanorama Sf;

            public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
                listener.onStreetViewPanoramaChange(location);
            }
        });
    }

    public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.Sd.setOnStreetViewPanoramaClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Sd.setOnStreetViewPanoramaClickListener(new C0764a(this) {
            final /* synthetic */ StreetViewPanorama Sf;

            public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
                listener.onStreetViewPanoramaClick(orientation);
            }
        });
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.Sd.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.Sd.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.Sd.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.Sd.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.Sd.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.Sd.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.Sd.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
