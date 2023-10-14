package com.nhnacademy.parkminsu.exercise9_3.factorial;

import com.nhnacademy.parkminsu.exercise9_3.funcinterface.RandomNum;

import java.util.Random;
import java.util.function.Function;

public class RandomNumberFactorial {
    // 해당 구문 고치기
    //
    private RandomNumberFactorial() {

    }

//    public static <T> T createRandomNumber(Class<T> type) {
//        var random = new Random();
//        if (type.equals(Integer.class)) {
//            return (T) Integer.valueOf(random.nextInt());
//        } else if (type.equals(Double.class)) {
//            return (T) Double.valueOf(random.nextDouble());
//        } else if (type.equals(String.class)) {
//            int leftLimit = 97; // letter 'a'
//            int rightLimit = 122; // letter 'z'
//            int targetStringLength = 10;
//            String generatedString = random.ints(leftLimit, rightLimit + 1)
//                    .limit(targetStringLength)
//                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                    .toString();
//            return (T) generatedString.toString();
//        } else {
//            throw new IllegalArgumentException("Unsupported data type");
//        }
//    }

    public static <T> T createRandomData(Function<Random, T> randomFunction) {
        Random rand = new Random();
        return randomFunction.apply(rand);
    }

    public static <T> T createRandomData(RandomNum<Random, T> randomFunction) {
        Random rand = new Random();
        return randomFunction.apply(rand);
    }
}
