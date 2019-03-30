package com.egovy.jumpmonster;

public interface ActionResolver {
    void getAchievementsGPGS();

    void getLeaderboardGPGS();

    boolean getSignedInGPGS();

    void loginGPGS();

    void submitScoreGPGS(int i);

    void unlockAchievementGPGS(String str);
}
