package com.nhnacademy.parkminsu.exercise10_4;

import java.util.Random;

public class RandomIntegerValueFactorial {
    private int startRange;
    private int endRange;

    public RandomIntegerValueFactorial(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
        classInvariant();
    }

    private void classInvariant() {
        if (max() < min()) {
            throw new IllegalArgumentException("Range: " + this.min() + " > " + this.max());
        }
    }

    public int createRandomValue() {
        Random random = new Random();
        return random.nextInt(endRange - startRange) + startRange;
    }

    public int min() {
        return startRange;
    }

    public int max() {
        return Math.subtractExact(endRange, 1);
    }

}
