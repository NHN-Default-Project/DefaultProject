package com.nhnacademy.gaeun.exercise2;

import java.util.ArrayList;
import java.util.Arrays;

/*
* https://math.hws.edu/javanotes/c7/exercises.html
* M은 2차원 배열, R개의 행과 C개의 열을 가짐
* M의 전치 -> 배열 T (C개의 행과 R개의 열을 가짐)
* <서브루틴 1>
* parameter: 행렬 A: int[][]
* return: A의 전치행렬: int[][]
* <서브루틴 2>
* 행렬 프린트
 */
public class Exercise7_2 {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);
        matrix.setElement(0, new int[]{ 10, 11, 12 });
        matrix.setElement(0, new int[]{ 20, 21, 22 });

        printArray(matrix.getData());
        System.out.println("의 전치행렬은 다음과 같습니다.");
        System.out.println();
        printArray(transposeArray(matrix.getData()));
    }
    public static int[][] transposeArray(int[][] array) {
        int[][] newArray = new int[array[0].length][array.length];
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                newArray[j][i] = array[i][j];
            }
        }
        return newArray;
    }

    public static void printArray(int[][] newArray) {
        for(int[] row : newArray) {
            for(int col : row) {
                System.out.printf("%d ", col);
            }
            System.out.println();
        }
    }
}
