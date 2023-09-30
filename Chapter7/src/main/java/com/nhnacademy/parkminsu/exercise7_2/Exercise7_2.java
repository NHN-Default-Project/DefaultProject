package com.nhnacademy.parkminsu.exercise7_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise7_2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("row, col을 입력하세요");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row <= 0 || col <= 0) {
                throw new IllegalArgumentException("0이하의 숫자를 입력하셨습니다.");
            }
            int[][] matrix = createMatrixValue(row, col);
            int[][] transposeMatrix = transpose(row, col, matrix);
            printMatrix(matrix);
            printMatrix(transposeMatrix);
        } catch (InputMismatchException e) {
            throw new InputMismatchException("잘못 입력하셨습니다.");
        }
    }

    public static int[][] createMatrixValue(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (Math.random() * 10) + 1;
            }
        }
        return matrix;
    }

    public static int[][] transpose(int row, int col, int[][] valueMatrix) {
        int[][] matrix = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[j][i] = valueMatrix[i][j];
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

}