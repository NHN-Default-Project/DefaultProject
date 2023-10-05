package com.nhnacademy.Jminsoo.exercise5;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise7_5 {
    public static void main(String[] args) {
        double[] doubleArr = makeArray();
        Arrays.stream(doubleArr)
                .sorted()
                .filter(x -> x > 0)
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
                    break;
                } else if (inputNum < 0) {
                    System.out.println("양의 실수만 입력해주세요!");
                } else {
                    doubleArray[count] = inputNum;
                    count++;
                }

            } catch (InputMismatchException e) {
                System.out.println("실수 형태만 입력해주세요!");
            }

        }
        return doubleArray;
    }

    private static boolean isInputZero(double input) {
        return input == 0;
    }


}
