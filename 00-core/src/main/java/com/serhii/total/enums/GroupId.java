package com.serhii.total.enums;

public enum GroupId {
    A("A", 1),
    B("B", 2),
    C("C", 3),
    D("D", 4),
    E("E", 5),
    F("F", 6),
    G("G", 7),
    H("H", 8);

    private String name;
    private int id;

    GroupId(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
