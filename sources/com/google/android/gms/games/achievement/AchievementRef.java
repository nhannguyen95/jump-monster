package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.C0282a;
import com.google.android.gms.plus.PlusShare;

public final class AchievementRef extends C0135b implements Achievement {
    AchievementRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m143a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        m143a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        m143a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        m143a("name", dataOut);
    }

    public Player getPlayer() {
        return new PlayerRef(this.BB, this.BD);
    }

    public Uri getRevealedImageUri() {
        return ah("revealed_icon_image_uri");
    }

    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m922x(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return ah("unlocked_icon_image_uri");
    }

    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public String toString() {
        C0282a a = fo.m977e(this).m976a("AchievementId", getAchievementId()).m976a("Type", Integer.valueOf(getType())).m976a("Name", getName()).m976a("Description", getDescription()).m976a("UnlockedImageUri", getUnlockedImageUri()).m976a("UnlockedImageUrl", getUnlockedImageUrl()).m976a("RevealedImageUri", getRevealedImageUri()).m976a("RevealedImageUrl", getRevealedImageUrl()).m976a("Player", getPlayer()).m976a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
        if (getType() == 1) {
            a.m976a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
            a.m976a("TotalSteps", Integer.valueOf(getTotalSteps()));
        }
        return a.toString();
    }
}
