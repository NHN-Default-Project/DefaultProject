package com.nhnacademy.parkminsu.Exercise3_1;

public class Exercise3_1 {

    public static void main(String[] args) {
        int num1;
        int num2;
        for (int i = 1; ; i++) {
            num1 = (int) (Math.random() * 6) + 1;
            num2 = (int) (Math.random() * 6) + 1;
            if (num1 == 1 && num1 == num2) {
                System.out.printf("num 1: %d, num2: %d\n", num1, num2);
                System.out.println(i);
                break;
            }
        }

    }
}