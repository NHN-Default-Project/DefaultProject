package com.nhnacademy.jminsoo.excercise6;

public class Excercise3_6 {
    public static void main(String[] args) {

        final int N = 10000;
        MaxDivisor maxDivisor = new MaxDivisor(N);

        System.out.printf("1 ~ %d까지 가장 제수가 많은 숫자 : %d\n", N, maxDivisor.getMaxNum());
        System.out.printf("제수의 개수 : %d\n", maxDivisor.getMaxCount());
        maxDivisor.printMaxNumberList();
    }

}
