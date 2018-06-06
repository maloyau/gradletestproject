package com.serhii.total;

public class Team {
    private final String country;
    private final String code;

    public Team(String country, String code) {
        this.country = country;
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

}
