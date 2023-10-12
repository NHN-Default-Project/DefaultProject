package com.nhnacademy.Jminsoo.exercise1;

public class RandomArray {

    private int[] array;

    public RandomArray(int number, int max) {
        this.array = makeArray(number, max);
    }

    public int[] makeArray(int number, int range) {
        int[] resultList = new int[number];

        for (int i = 0; i < number; i++) {
            resultList[i] = ((int) (Math.random() * range) + 1);
        }

        return resultList;
    }

    public void printArray() {
        for (int value : this.array) {
            System.out.println(value);
        }
    }
}
