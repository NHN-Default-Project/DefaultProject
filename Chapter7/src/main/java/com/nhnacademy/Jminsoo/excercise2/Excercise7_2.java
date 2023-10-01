package com.nhnacademy.Jminsoo.excercise2;

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
public class Excercise7_2 {

    public static void main(String[] args) {
        TransposeArray transposeArray = new TransposeArray(2, 3, 10);
        transposeArray.printOriginArray();
        transposeArray.printTransposeArray();

    }


}
