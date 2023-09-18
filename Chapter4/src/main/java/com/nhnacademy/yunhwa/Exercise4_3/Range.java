package com.nhnacademy.yunhwa.Exercise4_3;

public class Range { // 범위
    private int minValue;
    private int maxValue;

    public Range(int x, int y) {
        if (x >= y) {
            this.maxValue = x;
            this.minValue = y;
        } else {
            this.maxValue = y;
            this.minValue = x;
        }
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

}
