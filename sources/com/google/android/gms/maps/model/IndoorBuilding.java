package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.C0349d;
import com.google.android.gms.maps.model.internal.C0350e.C0779a;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final C0349d SY;

    public IndoorBuilding(C0349d delegate) {
        this.SY = (C0349d) fq.m986f(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.SY.mo2127b(((IndoorBuilding) other).SY);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.SY.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.SY.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.SY.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder aF : levels) {
                arrayList.add(new IndoorLevel(C0779a.aF(aF)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.SY.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.SY.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
