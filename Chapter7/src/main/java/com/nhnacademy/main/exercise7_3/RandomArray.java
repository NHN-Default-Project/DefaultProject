package com.nhnacademy.main.exercise7_3;

import java.util.Random;

public class RandomArray extends Array<Double> {

    private Double[] list;

    public RandomArray(int inputNum) {
        this.list = new Double[inputNum];
        randomDoubleSet(inputNum);
    }
    @Override
    public Double[] getList() {
        return list;
    }

    public void randomDoubleSet(int inputNum) {
        Random random = new Random();
        for (int i = 0; i < inputNum; i++) {
            list[i] = random.nextDouble() * 100 + 1;
        }
    }

    @Override
    public Double[] selectionSort() {
        Double[] newList = list;
        for (int i = 0; i < newList.length; i++) {
            int min = i;
            for (int j = i + 1; j < newList.length; j++) {
                if (newList[min] > newList[j]) {
                    min = j;
                }
            }
            double tmp = newList[i];
            newList[i] = newList[min];
            newList[min] = tmp;
        }
        return newList;
    }
}
