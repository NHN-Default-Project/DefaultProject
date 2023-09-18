package com.nhnacademy.parkminsu.Exercise2_5;

public class Egg {
    private int gross;
    private int dozen;
    private int num;

    public Egg(int num) {
        this.gross = num / 144;
        this.dozen = (num % 144) / 12;
        this.num = (num % 144) % 12;
    }

    public int getDozen() {
        return dozen;
    }

    public int getGross() {
        return gross;
    }

    public int getNum() {
        return num;
    }
}

