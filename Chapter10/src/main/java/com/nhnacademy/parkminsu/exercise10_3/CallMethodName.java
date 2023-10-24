package com.nhnacademy.parkminsu.exercise10_3;

public enum CallMethodName {
    END(0),
    GET(1),
    PUT(2),
    TABLELIST(3),
    REMOVE(4),
    CONTAINKEY(5),
    SIZE(6);
    private final int num;

    CallMethodName(int num) {
        this.num = num;
    }
}
