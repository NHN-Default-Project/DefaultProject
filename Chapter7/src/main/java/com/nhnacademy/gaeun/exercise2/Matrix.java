package com.nhnacademy.gaeun.exercise2;

public class Matrix {

    private int[][] data;

    public Matrix(int rows, int columns) {
        this.data = new int[rows][columns];
    }
    public int[][] getData() {
        return data;
    }
    public void setElement(int row, int[] value) {
        data[row] = value;
    }
}
