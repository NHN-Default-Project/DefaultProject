package com.nhnacademy.parkminsu.exercise9_3.solution.factorial;

import java.util.Random;

public class RandomNumberFactorial {
    private RandomNumberFactorial() {

    }

    public static int createRandomNumber(int minRange, int maxRange) {
        var random = new Random();
        int bound = 0; //
        try {
            bound = maxRange - minRange + 1;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return random.nextInt(bound) + minRange;
    }


}
