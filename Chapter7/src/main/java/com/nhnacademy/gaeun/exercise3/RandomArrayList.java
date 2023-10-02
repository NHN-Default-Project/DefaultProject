package com.nhnacademy.gaeun.exercise3;
import java.util.Random;

public class RandomArrayList {
    public double[] getList() {
        return list;
    }

    private double[] list;
    public RandomArrayList(int inputNum) {
        this.list = new double[inputNum];
        randomInput(inputNum);
    }
    public void randomInput(int inputNum) {
        Random random = new Random();
        for(int i = 0; i < inputNum; i++) {
            list[i] = random.nextDouble() * 100 + 1;
        }
    }

    public void selectionSort() {
        for(int i = 0; i < this.list.length; i++) {
            int min = i;
            for(int j = i+1; j < this.list.length; j++) {
                if(this.list[min] > this.list[j]) {
                    min = j;
                }
            }
            double tmp = this.list[i];
            this.list[i] = this.list[min];
            this.list[min] = tmp;
        }
    }
    public void printArray() {
        for(double val : list) {
            System.out.printf("%.4f ", val);
        }
    }
}
