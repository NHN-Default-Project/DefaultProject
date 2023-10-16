package com.nhnacademy.parkminsu.exercise9_3.factorial;

import com.nhnacademy.parkminsu.exercise9_3.funcinterface.RandomNum;

import java.util.Random;
import java.util.function.Function;

public class RandomNumberFactorial {
    // 해당 구문 고치기
    private RandomNumberFactorial() {
    }

    public static <T> T createRandomData(Function<Random, T> randomFunction) {
        Random rand = new Random();
        return randomFunction.apply(rand);
    }

    public static <T> T createRandomData(RandomNum<Random, T> randomFunction) {
        Random rand = new Random();
        return randomFunction.apply(rand);
    }
}
