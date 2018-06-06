package com.serhii.total.enums;

public enum RoundGroupStage {
    TOUR1("Тур 1", 1),
    TOUR2("Тур 2", 2),
    TOUR3("Тур 3", 3);

    RoundGroupStage(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
