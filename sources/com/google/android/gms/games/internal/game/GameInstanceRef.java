package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.fo;

public final class GameInstanceRef extends C0135b implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public boolean hi() {
        return getInteger("real_time_support") > 0;
    }

    public boolean hj() {
        return getInteger("turn_based_support") > 0;
    }

    public int hk() {
        return getInteger("platform_type");
    }

    public boolean hl() {
        return getInteger("piracy_check") > 0;
    }

    public boolean hm() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return fo.m977e(this).m976a("ApplicationId", getApplicationId()).m976a("DisplayName", getDisplayName()).m976a("SupportsRealTime", Boolean.valueOf(hi())).m976a("SupportsTurnBased", Boolean.valueOf(hj())).m976a("PlatformType", PlatformType.bd(hk())).m976a("PackageName", getPackageName()).m976a("PiracyCheckEnabled", Boolean.valueOf(hl())).m976a("Installed", Boolean.valueOf(hm())).toString();
    }
}
