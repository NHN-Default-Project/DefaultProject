package com.nhnacademy.gaeun.exercise2;

public class Matrix {

    private int[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }
    public int[][] getData() {
        return data;
    }
    public void setElement(int row, int[] value) {
        data[row] = value;
    }
}
