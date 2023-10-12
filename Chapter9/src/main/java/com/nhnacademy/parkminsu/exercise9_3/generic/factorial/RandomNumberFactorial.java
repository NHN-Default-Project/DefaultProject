package com.nhnacademy.parkminsu.exercise9_3.generic.factorial;

import java.util.Random;
import java.util.function.Function;

public class RandomNumberFactorial {
    private RandomNumberFactorial() {

    }

    //    public static <T> T createRandomNumber(int minRange, int maxRange) {
//        var random = new Random();
//        int bound = 0; //
//        try {
//            bound = maxRange - minRange + 1;
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        return random.nextInt(bound) + minRange;
//    }
    public static <T> T createRandomData(Function<Random, T> randomTFunction) {
        Random rand = new Random();
        return randomTFunction.apply(rand);
    }
}
