package com.serhii.total;

import com.serhii.total.enums.RoundGroupStage;

import java.util.Date;

public class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private final RoundGroupStage roundGroupStage;
    private final int matchIndex;
    private final Date matchDate;
    private final Date matchDate;

    public Match(Team homeTeam, Team awayTeam, RoundGroupStage roundGroupStage, int matchIndex) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.roundGroupStage = roundGroupStage;
        this.matchIndex = matchIndex;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getMatchIndex() {
        return matchIndex;
    }

    public RoundGroupStage getRoundGroupStage() {
        return roundGroupStage;
    }

    @Override
    public String toString() {
        return matchIndex + " " + roundGroupStage.getName() + ": " + homeTeam.getCountry() + " - " +
                awayTeam.getCountry();
    }
}
