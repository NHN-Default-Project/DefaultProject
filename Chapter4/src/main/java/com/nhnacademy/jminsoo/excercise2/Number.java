package com.nhnacademy.jminsoo.excercise2;

public class Number {
    public static int hexValue(char hexNum) {
        //check
        if (!isHex(hexNum)) {
            throw new IllegalArgumentException("16진수가 아닌 값을 보냈습니다!");
        }

        return Character.getNumericValue(hexNum);
    }

    public static boolean isHex(char c) {
        int numericValue =Character.getNumericValue(c);
        return numericValue >= 0 && numericValue <= 16;
    }
}
