package com.nhnacademy.parkminsu.Exercise2_4;

public enum Money {
    QUATER(25),
    DIME(10),
    NICKEL(5),
    PENNY(1);

    private int money;

    Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

}