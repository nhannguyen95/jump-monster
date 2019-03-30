package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0336v;
import com.google.android.gms.maps.model.internal.C0354i;
import com.google.android.gms.maps.model.internal.C0354i.C0787a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float SN;
    private boolean SO;
    private C0354i Tt;
    private TileProvider Tu;
    private boolean Tv;
    private final int xH;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions$1 */
    class C07671 implements TileProvider {
        private final C0354i Tw = this.Tx.Tt;
        final /* synthetic */ TileOverlayOptions Tx;

        C07671(TileOverlayOptions tileOverlayOptions) {
            this.Tx = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.Tw.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.SO = true;
        this.Tv = true;
        this.xH = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.SO = true;
        this.Tv = true;
        this.xH = versionCode;
        this.Tt = C0787a.aK(delegate);
        this.Tu = this.Tt == null ? null : new C07671(this);
        this.SO = visible;
        this.SN = zIndex;
        this.Tv = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.Tv = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.Tv;
    }

    public TileProvider getTileProvider() {
        return this.Tu;
    }

    int getVersionCode() {
        return this.xH;
    }

    public float getZIndex() {
        return this.SN;
    }

    IBinder iG() {
        return this.Tt.asBinder();
    }

    public boolean isVisible() {
        return this.SO;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.Tu = tileProvider;
        this.Tt = this.Tu == null ? null : new C0787a(this) {
            final /* synthetic */ TileOverlayOptions Tx;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.SO = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0336v.iB()) {
            C0355j.m1291a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m1268a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.SN = zIndex;
        return this;
    }
}
