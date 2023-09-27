package com.nhnacademy.jaehyeon.exercise7_2;

import java.util.Scanner;

public class Exercise7_2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("행의 값을 입력 하세요");
            int r = scanner.nextInt();
            verifyInputNumber(r);
            System.out.println("열의 값을 입력 하세요");
            int c = scanner.nextInt();
            verifyInputNumber(c);

            Array targetArray = new Array(r, c);
            TransposeArray transposeArray = new TransposeArray(targetArray);

            printArray(targetArray.getArray());
            System.out.println("============");
            printArray(transposeArray.getResultArray());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void printArray(int[][] array) {
        for (int[] numbers : array) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void verifyInputNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("1이상의 값을 넣어 줘야 합니다.");
        }
    }
}
