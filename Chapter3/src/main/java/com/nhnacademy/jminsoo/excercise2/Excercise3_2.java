package com.nhnacademy.jminsoo.excercise2;

public class Excercise3_2 {

    public static void main(String[] args) {

        final int N = 10000;
        calMaxDivisor(N);

    }

    public static void calMaxDivisor(int number) {
        int divisorCount = 0;

        int bigNum = 0;
        int bigDivisorNum = 0;

        for (int num = 1; num <= number; num++) {
            for (int divisor = 1; divisor * divisor <= num; divisor++) {
                if (divisor * divisor == num) {
                    divisorCount++;
                } else if (num % divisor == 0) {
                    divisorCount += 2;
                }
            }
            if (divisorCount >= bigDivisorNum) {
                bigNum = num;
                bigDivisorNum = divisorCount;
            }
            divisorCount = 0;

        }
        System.out.println("1~10000에서 가장 제수가 많은 숫자 : " + bigNum);
        System.out.println("제수의 개수 : " + bigDivisorNum);
    }
}