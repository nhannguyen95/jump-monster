package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    public void create(GoogleApiClient apiClient, RoomConfig config) {
        Games.m362c(apiClient).m2807a(config);
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m362c(apiClient).m2858m(invitationId, 0);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m362c(apiClient).m2856l(invitationId, 0);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m362c(apiClient).m2812b(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m362c(apiClient).m2812b(minPlayers, maxPlayers, allowAutomatch);
    }

    public RealTimeSocket getSocketForParticipant(GoogleApiClient apiClient, String roomId, String participantId) {
        return Games.m362c(apiClient).m2849i(roomId, participantId);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient apiClient, Room room, int minParticipantsToStart) {
        return Games.m362c(apiClient).m2775a(room, minParticipantsToStart);
    }

    public void join(GoogleApiClient apiClient, RoomConfig config) {
        Games.m362c(apiClient).m2825b(config);
    }

    public void leave(GoogleApiClient apiClient, RoomUpdateListener listener, String roomId) {
        Games.m362c(apiClient).m2808a(listener, roomId);
    }

    public int sendReliableMessage(GoogleApiClient apiClient, ReliableMessageSentCallback callback, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.m362c(apiClient).m2771a(callback, messageData, roomId, recipientParticipantId);
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.m362c(apiClient).m2772a(messageData, roomId, new String[]{recipientParticipantId});
    }

    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return Games.m362c(apiClient).m2772a(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    public int sendUnreliableMessageToOthers(GoogleApiClient apiClient, byte[] messageData, String roomId) {
        return Games.m362c(apiClient).m2836d(messageData, roomId);
    }
}
