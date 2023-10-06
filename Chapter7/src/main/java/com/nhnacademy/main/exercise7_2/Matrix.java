package com.nhnacademy.main.exercise7_2;

import org.w3c.dom.ranges.Range;

import java.util.Random;

public class Matrix {

    private int[][] data;
    private final int rows;
    private final int columns;
    private final int minRange;
    private final int maxRange;

    public Matrix(int rows, int columns, int minRange, int maxRange) {
        this.rows = rows;
        this.columns = columns;
        this.minRange = minRange;
        this.maxRange = maxRange;
        setData();
    }

    public void setData(){
        this.data = new int[rows][columns];
    }

    public int[][] getData() {
        return this.data;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
    public int getMinRange() {
        return this.minRange;
    }

    public int getMaxRange() {
        return this.maxRange;
    }

    // 행렬의 한 항의 값을 넣어주는 메서드
    public void setElement(int i, int j, int value) {
        this.data[i][j] = value;
    }

    // 행렬의 값들을 랜덤으로 넣어주는 메서드
    public void setRandomElements() {
        Random random = new Random();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {

                int randomInt = random.nextInt(this.maxRange - this.minRange + 1) + this.minRange;
                setElement(i, j, randomInt);
            }
        }
    }

    // 행렬 형식에 맞게 문자열 만들어 리턴 해주는 메서드
    public String toString() {
        String format = "%" + maxDigitForToString() + "s";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {
            sb.append("{ ");
            for (int j = 0; j < this.columns; j++) {
                sb.append(String.format(format, String.valueOf(this.data[i][j])));
                if (j < this.columns - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            sb.append("\n");
        }

        return sb.toString();
    }

    // toString() 에서 자릿수 맞추기 위한 최대 자릿수 정의해 리턴 해주는 메서드
    private int maxDigitForToString() {
        int minRangeDigit = (int) (Math.log10(this.minRange) + 1);
        int maxRangeDigit = (int) (Math.log10(this.maxRange) + 1);

        if (this.minRange < 0) {
            minRangeDigit = (int) (Math.log10(this.minRange * (-1)) + 1);
        }

        if (this.maxRange < 0) {
            maxRangeDigit = (int) (Math.log10(this.maxRange * (-1)) + 1);
        }

        int maxDigit; // - 부호 자릿수 처리
        if (minRange < 0 && maxRange > 0) { // 음 양
            maxDigit = Math.max(minRangeDigit + 1, maxRangeDigit);
        } else if (minRange > 0 && maxRange < 0) { // 양 음
            maxDigit = Math.max(minRangeDigit, maxRangeDigit + 1);
        } else if (minRange < 0 && maxRange < 0) { // 음 음
            maxDigit = Math.max(minRangeDigit + 1, maxRangeDigit + 1);
        } else { // 양 양
            maxDigit = Math.max(minRangeDigit, maxRangeDigit);
        }
        return maxDigit;
    }


}