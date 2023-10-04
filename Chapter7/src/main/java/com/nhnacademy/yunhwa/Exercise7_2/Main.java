package com.nhnacademy.yunhwa.Exercise7_2;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {11, 22, 33, 44},
                {55, 66, 77, 88},
                {99, 110, 121, 132}
        };

        Transposing2DIntArr transpose2DIntArr = new Transposing2DIntArr(matrix);
        transpose2DIntArr.print2DArrayOfIntegers();
    }
}