package com.nhnacademy.gaeun.exercise3;
import java.util.Random;

public class RandomArrayList {
    public double[] getList() {
        return list;
    }

    double[] list;
    RandomArrayList(int inputNum) {
        randomInput(inputNum);
    }
    public void randomInput(int inputNum) {
        list = new double[inputNum];
        Random random = new Random();
        for(int i = 0; i < inputNum; i++) {
            list[i] = random.nextDouble() * 100 + 1;
        }
    }

    public void selectionSort() {
        for(int i = 0; i < list.length; i++) {
            int min = i;
            for(int j = i+1; j < list.length; j++) {
                if(list[min] > list[j]) {
                    min = j;
                }
            }
            double tmp = list[i];
            list[i] = list[min];
            list[min] = tmp;
        }
    }
    public void printArray() {
        for(double val : list) {
            System.out.printf("%.4f ", val);
        }
    }
}
