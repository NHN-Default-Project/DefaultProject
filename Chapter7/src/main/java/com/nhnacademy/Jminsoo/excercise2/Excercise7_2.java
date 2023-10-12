package com.nhnacademy.Jminsoo.excercise2;

public class Excercise7_2 {

    public static void main(String[] args) {
        int[][] M = makeArray(2, 3, 10);
        int[][] T = makeTransposeArray(M);
        printArray(M);
        System.out.println();
        printArray(T);
    }

    public static int[][] makeArray(int col, int row, int range) {
        int[][] resultArray = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                resultArray[i][j] = ((int) (Math.random() * range) + 1);
            }
        }

        return resultArray;
    }

    public static int[][] makeTransposeArray(int[][] originArray) {
        if (originArray.length == 0) {
            throw new IllegalArgumentException("Array가 비어있습니다!");
        } else if (originArray[0].length == 0) {
            throw new IllegalArgumentException("Array가 비어있습니다!");
        }

        int[][] resultArray = new int[originArray[0].length][originArray.length];


        for (int i = 0; i < originArray[0].length; i++) {
            for (int j = 0; j < originArray.length; j++) {
                resultArray[i][j] = originArray[j][i];
            }
        }

        return resultArray;
    }

    public static void printArray(int[][] array) {
        for (int[] oneDimensionalArray : array) {
            for (int value : oneDimensionalArray) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }
}
