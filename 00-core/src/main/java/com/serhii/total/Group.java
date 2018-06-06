package com.serhii.total;

import com.serhii.total.enums.GroupId;
import com.serhii.total.enums.RoundGroupStage;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final Team TEAM1;
    private final Team TEAM2;
    private final Team TEAM3;
    private final Team TEAM4;

    private final List<Match> matches;
    private final GroupId groupId;

    public Group(Team team1, Team team2, Team team3, Team team4, GroupId groupId) {
        this.TEAM1 = team1;
        this.TEAM2 = team2;
        this.TEAM3 = team3;
        this.TEAM4 = team4;
        this.groupId = groupId;
        this.matches = groupMatchGenerator();
    }

    public List<Match> getMatches() {
        return matches;
    }

    private ArrayList<Match> groupMatchGenerator() {
        ArrayList<Match> matches = new ArrayList<>();
        matches.add(new Match(TEAM1, TEAM2, RoundGroupStage.TOUR1, (groupId.getId() + groupId.getId()-1)));
        matches.add(new Match(TEAM3, TEAM4, RoundGroupStage.TOUR1, (groupId.getId() + groupId.getId())));
        matches.add(new Match(TEAM1, TEAM3, RoundGroupStage.TOUR2, (groupId.getId() + 16 + groupId.getId()-1)));
        matches.add(new Match(TEAM4, TEAM2, RoundGroupStage.TOUR2, (groupId.getId() + 16 + groupId.getId())));
        matches.add(new Match(TEAM4, TEAM1, RoundGroupStage.TOUR3, (groupId.getId() + 32 + groupId.getId()-1)));
        matches.add(new Match(TEAM2, TEAM3, RoundGroupStage.TOUR3, (groupId.getId() + 32 + groupId.getId())));
        return matches;
    }
}
