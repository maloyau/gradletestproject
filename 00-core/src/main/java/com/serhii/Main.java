package com.serhii;

import com.serhii.total.*;
import com.serhii.total.enums.GroupId;
import com.serhii.total.enums.RoundGroupStage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Team TEAM_A1 = new Team("Россия", "RUS");
    private static final Team TEAM_A2 = new Team("Саудовская Аравия", "SAU");
    private static final Team TEAM_A3 = new Team("Египет", "EGY");
    private static final Team TEAM_A4 = new Team("Уругвай", "URY");

    private static final Team TEAM_B1 = new Team("Португалия", "PRT");
    private static final Team TEAM_B2 = new Team("Испания", "ESP");
    private static final Team TEAM_B3 = new Team("Марокко", "MAR");
    private static final Team TEAM_B4 = new Team("Иран", "IRN");

    private static final Team TEAM_C1 = new Team("Франция", "FRA");
    private static final Team TEAM_C2 = new Team("Австралия", "AUS");
    private static final Team TEAM_C3 = new Team("Перу", "PER");
    private static final Team TEAM_C4 = new Team("Дания", "DNK");

    private static final Team TEAM_D1 = new Team("Аргентина", "ARG");
    private static final Team TEAM_D2 = new Team("Исландия", "ISL");
    private static final Team TEAM_D3 = new Team("Хорватия", "HRV");
    private static final Team TEAM_D4 = new Team("Нигерия", "NGA");

    private static final Team TEAM_E1 = new Team("Бразилия", "BRA");
    private static final Team TEAM_E2 = new Team("Швейцария", "CHE");
    private static final Team TEAM_E3 = new Team("Коста-Рика", "CRI");
    private static final Team TEAM_E4 = new Team("Сербия", "SRB");

    private static final Team TEAM_F1 = new Team("Германия", "DEU");
    private static final Team TEAM_F2 = new Team("Мексика", "MEX");
    private static final Team TEAM_F3 = new Team("Швеция", "SWE");
    private static final Team TEAM_F4 = new Team("Республика Корея", "KOR");

    private static final Team TEAM_G1 = new Team("Бельгия", "BEL");
    private static final Team TEAM_G2 = new Team("Панама", "PAN");
    private static final Team TEAM_G3 = new Team("Тунис", "TUN");
    private static final Team TEAM_G4 = new Team("Англия", "ENG");

    private static final Team TEAM_H1 = new Team("Польша", "POL");
    private static final Team TEAM_H2 = new Team("Сенегал", "SEN");
    private static final Team TEAM_H3 = new Team("Колумбия", "COL");
    private static final Team TEAM_H4 = new Team("Япония", "JPN");

    private static final Group GROUP_A = new Group(TEAM_A1, TEAM_A2, TEAM_A3, TEAM_A4, GroupId.A);
    private static final Group GROUP_B = new Group(TEAM_B1, TEAM_B2, TEAM_B3, TEAM_B4, GroupId.B);
    private static final Group GROUP_C = new Group(TEAM_C1, TEAM_C2, TEAM_C3, TEAM_C4, GroupId.C);
    private static final Group GROUP_D = new Group(TEAM_D1, TEAM_D2, TEAM_D3, TEAM_D4, GroupId.D);
    private static final Group GROUP_E = new Group(TEAM_E1, TEAM_E2, TEAM_E3, TEAM_E4, GroupId.E);
    private static final Group GROUP_F = new Group(TEAM_F1, TEAM_F2, TEAM_F3, TEAM_F4, GroupId.F);
    private static final Group GROUP_G = new Group(TEAM_G1, TEAM_G2, TEAM_G3, TEAM_G4, GroupId.G);
    private static final Group GROUP_H = new Group(TEAM_H1, TEAM_H2, TEAM_H3, TEAM_H4, GroupId.H);

    private final List<Group> groups = new ArrayList<>();

    private Main() {
        this.groups.add(GROUP_A);
        this.groups.add(GROUP_B);
        this.groups.add(GROUP_C);
        this.groups.add(GROUP_D);
        this.groups.add(GROUP_E);
        this.groups.add(GROUP_F);
        this.groups.add(GROUP_G);
        this.groups.add(GROUP_H);
    }

    public static void main(String[] args) {
        Main main = new Main();
        for (RoundGroupStage r : RoundGroupStage.values()) {
            for (Group g : main.groups) {
                for (Match m : g.getMatches()) {
                    if (r == m.getRoundGroupStage())
                        System.out.println(m.toString());
                }
            }
        }
    }
}

