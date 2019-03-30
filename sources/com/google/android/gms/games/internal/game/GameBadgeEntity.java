package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.fo;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private String EB;
    private String HD;
    private Uri HF;
    private int LF;
    private final int xH;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public GameBadgeEntity ar(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.m2861c(fe.eJ()) || fe.al(GameBadgeEntity.class.getCanonicalName())) {
                return super.ar(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return ar(x0);
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.xH = versionCode;
        this.LF = type;
        this.EB = title;
        this.HD = description;
        this.HF = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.xH = 1;
        this.LF = gameBadge.getType();
        this.EB = gameBadge.getTitle();
        this.HD = gameBadge.getDescription();
        this.HF = gameBadge.getIconImageUri();
    }

    /* renamed from: a */
    static int m3379a(GameBadge gameBadge) {
        return fo.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    /* renamed from: a */
    static boolean m3380a(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return fo.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && fo.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    /* renamed from: b */
    static String m3381b(GameBadge gameBadge) {
        return fo.m977e(gameBadge).m976a("Type", Integer.valueOf(gameBadge.getType())).m976a("Title", gameBadge.getTitle()).m976a("Description", gameBadge.getDescription()).m976a("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3380a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hh();
    }

    public String getDescription() {
        return this.HD;
    }

    public Uri getIconImageUri() {
        return this.HF;
    }

    public String getTitle() {
        return this.EB;
    }

    public int getType() {
        return this.LF;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return m3379a(this);
    }

    public GameBadge hh() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3381b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (eK()) {
            dest.writeInt(this.LF);
            dest.writeString(this.EB);
            dest.writeString(this.HD);
            dest.writeString(this.HF == null ? null : this.HF.toString());
            return;
        }
        GameBadgeEntityCreator.m570a(this, dest, flags);
    }
}
