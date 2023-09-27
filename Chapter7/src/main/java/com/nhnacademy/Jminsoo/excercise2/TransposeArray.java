package com.nhnacademy.Jminsoo.excercise2;

import java.util.Random;

public class TransposeArray {
    private int[][] originArray;
    private int[][] transposeArray;

    public int[][] getOriginArray() {
        return originArray;
    }

    public int[][] getTransposeArray() {
        return transposeArray;
    }

    public TransposeArray(int col, int row, int range) {
        this.originArray = makeArray(col, row, range);
        this.transposeArray = transposeArray(this.originArray);
    }

    public void printTransposeArray() {
        this.printArray(this.transposeArray);
    }

    public void printOriginArray() {
        this.printArray(this.originArray);
    }


    private int[][] makeArray(int col, int row, int range) {
        int[][] result = new int[col][row];
        Random random = new Random();

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = (random.nextInt(range) + 1);
            }
        }

        return result;
    }


    private int[][] transposeArray(int[][] originArray) {
        if (originArray.length == 0 || originArray[0].length == 0) {
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

    private void printArray(int[][] list) {
        for (int[] oneDimensionalArray : list) {
            for (int value : oneDimensionalArray) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
