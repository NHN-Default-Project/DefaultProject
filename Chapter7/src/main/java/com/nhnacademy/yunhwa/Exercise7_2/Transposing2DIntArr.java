package com.nhnacademy.yunhwa.Exercise7_2;

public class Transposing2DIntArr {
    int[][] transposedArr;

    public Transposing2DIntArr(int[][] arr) {
        int tRows = arr[0].length;
        int tColumns = arr.length;

        this.transposedArr = new int[tRows][tColumns];

        for (int i = 0; i < tRows; i++) {
            for (int j = 0; j < tColumns; j++) {
                this.transposedArr[i][j] = arr[j][i];
            }
        }

    }

    // 전치된 결과 배열을 예쁘게 출력해주는 메서드
    public void print2DArrayOfIntegers() {
        System.out.println();
        for (int i = 0; i < this.transposedArr.length; i++) {
            printRowsLine(this.transposedArr[0].length);
            for (int j = 0; j < this.transposedArr[0].length; j++) {
                System.out.printf("| %d ", this.transposedArr[i][j]);
            }
            System.out.printf("|%n");
        }
        printRowsLine(this.transposedArr[0].length);
    }

    // 열의 길이만큼 맞춰서 예쁘게 행의 라인을 그려주는 메서드
    public void printRowsLine(int columns) {
        for (int k = 0; k < columns; k++) {
            System.out.print(" ____");
        }
        System.out.printf("  %n");
    }
















}
