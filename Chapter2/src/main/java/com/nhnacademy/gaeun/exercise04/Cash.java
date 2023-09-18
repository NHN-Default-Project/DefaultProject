package com.nhnacademy.gaeun.exercise04;

public enum Cash {
    Penny(1, "페니"),
    Nickel(5, "니켈"),
    Dime(10, "다임"),
    Quarter(25, "쿼터");

    private final int cent;
    private final String name;

    Cash(int cent, String name) {
        this.cent = cent;
        this.name = name;
    }

    public int calc(int amount) {
        return this.cent * amount;
    }

    public String getName() {
        return name;
    }
    
}
