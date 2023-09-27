package com.nhnacademy.yunhwa.Exercise7_2;

public class Main {
    public static void main(String[] args) {
        int[][] M = {
                {11, 22, 33, 44},
                {55, 66, 77, 88},
                {99, 110, 121, 132}
        };

        Transposing2DArrayOfIntegers transpose2DArrayOfIntegers = new Transposing2DArrayOfIntegers();
        int[][] T = transpose2DArrayOfIntegers.action(M);
        transpose2DArrayOfIntegers.print2DArrayOfIntegers(T);
    }
}
