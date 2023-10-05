package com.nhnacademy.main.exercise7_2;

import org.w3c.dom.ranges.Range;

import java.util.Random;

public class Matrix {

    private int[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
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

    public void setRandomElements(int minRange, int maxRange) {
        Random random = new Random();

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {

                int randomInt;

                if (minRange < 0 && maxRange > 0) {
                    randomInt = random.nextInt(2);
                    if (randomInt == 0) {
                        this.data[i][j] = random.nextInt(maxRange + 1);
                    } else {
                        this.data[i][j] = random.nextInt((-1) * minRange + 1) * (-1);
                    }
                } else if (minRange < 0 && maxRange < 0) {
                    randomInt = random.nextInt(2);
                    if (randomInt == 0) {
                        this.data[i][j] = random.nextInt((-1) * maxRange + 1) * (-1);
                    } else {
                        this.data[i][j] = random.nextInt((-1) * minRange + 1) * (-1);
                    }
                } else {
                    this.data[i][j] = random.nextInt(maxRange - minRange + 1) + minRange;
                }
            }
        }
    }

    public void setElement(int i, int j, int value) {
        this.data[i][j] = value;
    }

    public String toString(int minRange, int maxRange) {
        int minRangeDigit = (int) (Math.log10(minRange) + 1);
        int maxRangeDigit = (int) (Math.log10(maxRange) + 1);

        int maxDigit = Math.max(minRangeDigit, maxRangeDigit);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {
            sb.append("{");
            for (int j = 0; j < this.columns; j++) {
                String format = "%" + maxDigit + "s";
                sb.append(String.format(format, String.valueOf(this.data[i][j])));
                if (j < this.columns - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            sb.append("\n");
        }

        return sb.toString();
    }




}