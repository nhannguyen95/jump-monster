package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0190d;
import com.google.android.gms.dynamic.C0926e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0316b.C0732a;
import com.google.android.gms.maps.internal.C0318d.C0736a;
import com.google.android.gms.maps.internal.C0319e.C0738a;
import com.google.android.gms.maps.internal.C0320f.C0740a;
import com.google.android.gms.maps.internal.C0321g.C0742a;
import com.google.android.gms.maps.internal.C0322h;
import com.google.android.gms.maps.internal.C0323i.C0746a;
import com.google.android.gms.maps.internal.C0324j.C0748a;
import com.google.android.gms.maps.internal.C0325k.C0750a;
import com.google.android.gms.maps.internal.C0326l.C0752a;
import com.google.android.gms.maps.internal.C0327m.C0754a;
import com.google.android.gms.maps.internal.C0328n.C0756a;
import com.google.android.gms.maps.internal.C0329o.C0758a;
import com.google.android.gms.maps.internal.C0333s.C0766a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0716a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0348c;
import com.google.android.gms.maps.model.internal.C0349d;
import com.google.android.gms.maps.model.internal.C0351f;
import com.google.android.gms.maps.model.internal.C0353h;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate Rp;
    private UiSettings Rq;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap$a */
    private static final class C1008a extends C0732a {
        private final CancelableCallback RH;

        C1008a(CancelableCallback cancelableCallback) {
            this.RH = cancelableCallback;
        }

        public void onCancel() {
            this.RH.onCancel();
        }

        public void onFinish() {
            this.RH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.Rp = (IGoogleMapDelegate) fq.m986f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.Rp.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0348c addGroundOverlay = this.Rp.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0351f addMarker = this.Rp.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.Rp.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.Rp.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0353h addTileOverlay = this.Rp.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.Rp.animateCamera(update.id());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.Rp.animateCameraWithDurationAndCallback(update.id(), durationMs, callback == null ? null : new C1008a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.Rp.animateCameraWithCallback(update.id(), callback == null ? null : new C1008a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.Rp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.Rp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            C0349d focusedBuilding = this.Rp.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.Rp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.Rp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.Rp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.Rp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.Rp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.Rq == null) {
                this.Rq = new UiSettings(this.Rp.getUiSettings());
            }
            return this.Rq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: if */
    IGoogleMapDelegate m1224if() {
        return this.Rp;
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.Rp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.Rp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.Rp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.Rp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.Rp.moveCamera(update.id());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.Rp.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.Rp.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.Rp.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setInfoWindowAdapter(new C0736a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: f */
            public C0190d mo2043f(C0351f c0351f) {
                return C0926e.m2696h(adapter.getInfoWindow(new Marker(c0351f)));
            }

            /* renamed from: g */
            public C0190d mo2044g(C0351f c0351f) {
                return C0926e.m2696h(adapter.getInfoContents(new Marker(c0351f)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.Rp.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setLocationSource(new C0716a(this) {
            final /* synthetic */ GoogleMap Rs;

            public void activate(final C0322h listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ C10046 Rz;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.mo2049j(C0926e.m2696h(location));
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.Rp.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.Rp.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnCameraChangeListener(new C0738a(this) {
            final /* synthetic */ GoogleMap Rs;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnIndoorStateChangeListener(new C0740a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: a */
            public void mo2046a(C0349d c0349d) {
                listener.onIndoorLevelActivated(new IndoorBuilding(c0349d));
            }

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnInfoWindowClickListener(new C0742a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: e */
            public void mo2048e(C0351f c0351f) {
                listener.onInfoWindowClick(new Marker(c0351f));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapClickListener(new C0746a(this) {
            final /* synthetic */ GoogleMap Rs;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.Rp.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapLoadedCallback(new C0748a(this) {
            final /* synthetic */ GoogleMap Rs;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapLongClickListener(new C0750a(this) {
            final /* synthetic */ GoogleMap Rs;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMarkerClickListener(new C0752a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: a */
            public boolean mo2053a(C0351f c0351f) {
                return listener.onMarkerClick(new Marker(c0351f));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMarkerDragListener(new C0754a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: b */
            public void mo2054b(C0351f c0351f) {
                listener.onMarkerDragStart(new Marker(c0351f));
            }

            /* renamed from: c */
            public void mo2055c(C0351f c0351f) {
                listener.onMarkerDragEnd(new Marker(c0351f));
            }

            /* renamed from: d */
            public void mo2056d(C0351f c0351f) {
                listener.onMarkerDrag(new Marker(c0351f));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMyLocationButtonClickListener(new C0756a(this) {
            final /* synthetic */ GoogleMap Rs;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMyLocationChangeListener(new C0758a(this) {
            final /* synthetic */ GoogleMap Rs;

            /* renamed from: e */
            public void mo2058e(C0190d c0190d) {
                listener.onMyLocationChange((Location) C0926e.m2695d(c0190d));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.Rp.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.Rp.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.Rp.snapshot(new C0766a(this) {
                final /* synthetic */ GoogleMap Rs;

                /* renamed from: f */
                public void mo2062f(C0190d c0190d) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) C0926e.m2695d(c0190d));
                }

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }
            }, (C0926e) (bitmap != null ? C0926e.m2696h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.Rp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
