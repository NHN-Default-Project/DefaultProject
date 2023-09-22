package com.nhnacademy.gaeun.exercise06;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int max = 0;
        ArrayList<Integer> maxValues = new ArrayList<Integer>();
        for (int i = 1; i <= 10000; i++) {
            if (max < divisor(i)) {
                max = divisor(i);
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (max == divisor(i)) {
                maxValues.add(i);
            }
        }

        System.out.println("1부터 10000 사이의 정수 중");
        System.out.printf("최대 약수 수는 %d개 입니다.\n", max);
        System.out.println("약수가 많은 숫자는 다음과 같습니다: ");
        for (int i = 0; i < maxValues.size(); i++) {
            System.out.println(maxValues.get(i));
        }
    }

    public static int divisor(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

}