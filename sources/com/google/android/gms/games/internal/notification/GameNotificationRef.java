package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C0135b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.fo;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C0135b implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String hp() {
        return getString("notification_id");
    }

    public String hq() {
        return getString("ticker");
    }

    public String hr() {
        return getString("coalesced_text");
    }

    public boolean hs() {
        return getInteger("acknowledged") > 0;
    }

    public boolean ht() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return fo.m977e(this).m976a("Id", Long.valueOf(getId())).m976a("NotificationId", hp()).m976a("Type", Integer.valueOf(getType())).m976a("Title", getTitle()).m976a("Ticker", hq()).m976a("Text", getText()).m976a("CoalescedText", hr()).m976a("isAcknowledged", Boolean.valueOf(hs())).m976a("isSilent", Boolean.valueOf(ht())).toString();
    }
}
