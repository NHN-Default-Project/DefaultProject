package com.nhnacademy.main.exercise7_2;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    static int minRange;
    static int maxRange;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Matrix matrix;

        while (true) {
            try {
                System.out.print("만들려고 하는 행렬의 행의 길이와 열의 길이를 공백으로 구분하여 입력해주세요 (int) : ");
                int rows = sc.nextInt();
                int columns = sc.nextInt();
                if (rows < 0 || columns < 0) {
                    System.out.println("만들려는 행의 길이나 열의 길이가 음수가 될 수 없습니다. 다시 입력해주세요");
                    continue;
                } else if (rows == 0 && columns == 0) {
                    System.out.println("만들려는 행의 길이와 열의 길이 둘 다 0이 될 수가 없습니다. 다시 입력해주세요");
                    continue;
                }

                matrix = new Matrix(rows, columns);

                System.out.print("행렬의 값들을 랜덤으로 넣어주려고 합니다. 랜덤 범위의 최솟값과 최댓값을 공백으로 구분하여 입력해주세요 (int) : ");
                minRange = sc.nextInt();
                maxRange = sc.nextInt();
                if (minRange > maxRange) {
                    System.out.println("최솟값은 최댓값보다 클 수 없습니다. 다시 입력해주세요");
                } else {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("int 가 될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
            }
        }

        matrix.setRandomElements(minRange, maxRange);
        printMatrix(matrix);
        System.out.println("의 전치행렬은 다음과 같습니다.\n");
        printMatrix(transposeMatrix(matrix));

        sc.close();
    }

    public static Matrix transposeMatrix(Matrix matrix) {

        Matrix transPosedMatrix = new Matrix(matrix.getColumns(), matrix.getRows());
        for (int i = 0; i < transPosedMatrix.getRows(); i++) {
            for (int j = 0; j < transPosedMatrix.getColumns(); j++) {
                transPosedMatrix.setElement(i, j, matrix.getData()[j][i]);
            }
        }
        return transPosedMatrix;
    }

    public static void printMatrix(Matrix matrix) {
        System.out.println(matrix.toString(minRange,maxRange));
    }
}
