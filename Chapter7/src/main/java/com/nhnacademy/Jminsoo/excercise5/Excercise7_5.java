package com.nhnacademy.Jminsoo.excercise5;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Excercise7_5 {
    public static void main(String[] args) {
        double[] doubleArr = makeArray();
        Arrays.stream(doubleArr)
                .sorted()
                .forEach(System.out::println);
    }

    private static double[] makeArray() {
        double inputNum = 0;
        double[] doubleArray = new double[100];
        Scanner scanner = new Scanner(System.in);
        boolean isInputZero = false;
        int count = 0;


        while (count < 100 && !isInputZero) {
            try {
                System.out.print("값을 입력해주세요 : ");
                inputNum = scanner.nextDouble();
                System.out.println();
                if (inputNum == 0) {
                    isInputZero = true;
                } else if (inputNum < 0) {
                    System.out.println("양의 실수만 입력해주세요!");
                } else {
                    doubleArray[count] = inputNum;
                    count++;
                }

            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("실수 형태만 입력해주세요!");

            }
        }

        return doubleArray;
    }


}
