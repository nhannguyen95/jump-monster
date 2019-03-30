package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.fo;

public final class ExtendedPlayerEntity implements ExtendedPlayer {
    private final PlayerEntity LH;
    private final String LI;
    private final long LJ;
    private final Uri LK;

    public ExtendedPlayerEntity(ExtendedPlayer extendedPlayer) {
        Player player = extendedPlayer.getPlayer();
        this.LH = player == null ? null : new PlayerEntity(player);
        this.LI = extendedPlayer.hu();
        this.LJ = extendedPlayer.hv();
        this.LK = extendedPlayer.hw();
    }

    /* renamed from: a */
    static int m2864a(ExtendedPlayer extendedPlayer) {
        return fo.hashCode(extendedPlayer.getPlayer(), extendedPlayer.hu(), Long.valueOf(extendedPlayer.hv()), extendedPlayer.hw());
    }

    /* renamed from: a */
    static boolean m2865a(ExtendedPlayer extendedPlayer, Object obj) {
        if (!(obj instanceof ExtendedPlayer)) {
            return false;
        }
        if (extendedPlayer == obj) {
            return true;
        }
        ExtendedPlayer extendedPlayer2 = (ExtendedPlayer) obj;
        return fo.equal(extendedPlayer2.getPlayer(), extendedPlayer.getPlayer()) && fo.equal(extendedPlayer2.hu(), extendedPlayer.hu()) && fo.equal(Long.valueOf(extendedPlayer2.hv()), Long.valueOf(extendedPlayer.hv())) && fo.equal(extendedPlayer2.hw(), extendedPlayer.hw());
    }

    /* renamed from: b */
    static String m2866b(ExtendedPlayer extendedPlayer) {
        return fo.m977e(extendedPlayer).m976a("Player", extendedPlayer.getPlayer()).m976a("MostRecentGameId", extendedPlayer.hu()).m976a("MostRecentActivityTimestamp", Long.valueOf(extendedPlayer.hv())).m976a("MostRecentGameIconImageUri", extendedPlayer.hw()).toString();
    }

    public boolean equals(Object obj) {
        return m2865a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hy();
    }

    public /* synthetic */ Player getPlayer() {
        return hx();
    }

    public int hashCode() {
        return m2864a(this);
    }

    public String hu() {
        return this.LI;
    }

    public long hv() {
        return this.LJ;
    }

    public Uri hw() {
        return this.LK;
    }

    public PlayerEntity hx() {
        return this.LH;
    }

    public ExtendedPlayer hy() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m2866b(this);
    }
}
