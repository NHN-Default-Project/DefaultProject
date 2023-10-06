package com.nhnacademy.main.exercise7_2;

import org.w3c.dom.ranges.Range;

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

    // 예제 수행 프로그램 main 메서드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Matrix matrix = constructMatrix(sc); // 사용자 입력받은 것들을 파라미터로 받아 Matrix 생성
        matrix.setRandomElements(); // 랜덤 값으로 채우기
        printMatrix(matrix); // 전치 전 출력
        System.out.println("의 전치행렬은 다음과 같습니다.\n");
        printMatrix(transposeMatrix(matrix)); // 전치 후 출력

        sc.close();
    }



    /*
    * 사용자 에게 행의 길이와 열의 길이를 입력 받고 (내부 메서드)
    * 사용자 에게 랜덤 값을 만들 범위의 최솟값 최댓값 입력 받아 (내부 메서드)
    * Matrix 생성 하는 메서드
    * */
    public static Matrix constructMatrix(Scanner sc) {
        int[] rowsColumns = setRowsColumns(sc);
        int rows = rowsColumns[0];
        int columns = rowsColumns[1];

        int[] range = setRange(sc);
        int minRange = range[0];
        int maxRange = range[1];

        return new Matrix(rows, columns, minRange, maxRange);
    }



    // 사용자 에게 행의 길이와 열의 길이를 입력 받아 배열로 리턴 해주는 내부 메서드
    private static int[] setRowsColumns(Scanner sc) {
        int rows;
        int columns;
        while (true) {
            try {
                System.out.print("만들려고 하는 행렬의 행의 길이와 열의 길이를 공백으로 구분하여 입력해주세요 (int) : ");
                rows = sc.nextInt();
                columns = sc.nextInt();
                if (rows < 0 || columns < 0) {
                    System.out.println("만들려는 행의 길이나 열의 길이가 음수가 될 수 없습니다. 다시 입력해주세요");
                } else if (rows == 0 && columns == 0) {
                    System.out.println("만들려는 행의 길이와 열의 길이 둘 다 0이 될 수가 없습니다. 다시 입력해주세요");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("int 가 될 수 없는 값이 입력되었습니다. 다시 입력해주세요");
                sc.nextLine();
            }
        }
        return new int[]{rows, columns};
    }



    // 사용자 에게 랜덤 값을 만들 범위의 최솟값 최댓값 입력 받아 배열로 리턴 해주는 내부 메서드
    private static int[] setRange(Scanner sc) {
        int minRange;
        int maxRange;
        while (true) {
            try {
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
                sc.nextLine();
            }
        }
        return new int[]{minRange, maxRange};
    }


    // 행렬 받아서 전치 해서 전치 행렬 리턴 해주는 메서드
    public static Matrix transposeMatrix(Matrix matrix) {
        Matrix transPosedMatrix = new Matrix(matrix.getColumns(), matrix.getRows(), matrix.getMinRange(), matrix.getMaxRange());
        for (int i = 0; i < transPosedMatrix.getRows(); i++) {
            for (int j = 0; j < transPosedMatrix.getColumns(); j++) {
                transPosedMatrix.setElement(i, j, matrix.getData()[j][i]);
            }
        }
        return transPosedMatrix;
    }


    // 행렬 출력 해주는 메서드
    public static void printMatrix(Matrix matrix) {
        System.out.println(matrix.toString());
    }
}