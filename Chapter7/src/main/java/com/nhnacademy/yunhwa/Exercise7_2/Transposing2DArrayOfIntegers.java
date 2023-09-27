package com.nhnacademy.yunhwa.Exercise7_2;

public class Transposing2DArrayOfIntegers {


    public int[][] action(int[][] M) {
        int tRows = M[0].length;
        int tColumns = M.length;

        int[][] T = new int[tRows][tColumns];

        for (int i = 0; i < tRows; i++) {
            for (int j = 0; j < tColumns; j++) {
                T[i][j] = M[j][i];
            }
        }

        return T;
    }

    // 전치된 결과 배열을 예쁘게 출력해주는 메서드
    public void print2DArrayOfIntegers(int[][] T) {
        System.out.println();
        for (int i = 0; i < T.length; i++) {
            printRowsLine(T[0].length);
            for (int j = 0; j < T[0].length; j++) {
                System.out.printf("| %d ", T[i][j]);
            }
            System.out.printf("|%n");
        }
        printRowsLine(T[0].length);
    }

    // 열의 길이만큼 맞춰서 예쁘게 행의 라인을 그려주는 메서드
    public void printRowsLine(int columns) {
        for (int k = 0; k < columns; k++) {
            System.out.print(" ____");
        }
        System.out.printf("  %n");
    }
















}
