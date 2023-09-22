package org.example.gaeun.design_programs;

public class Combination {


    public Integer[][] all(Integer[] array, int r) {
        Integer[][] twoArray = combination(array, r);

        return twoArray;
    }

    int[] array = {2, 4, 6, 7};

    public static Integer[][] combination(Integer[] array, int r) {
        int z = 0;
        Integer[][] twoArray = new Integer[combinationValue(array.length, r)][r];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                twoArray[z][0] = array[i];
                twoArray[z][1] = array[j];
                z++;
            }
        }
        return twoArray;
    }

    public static int combinationValue(int arrayLength, int r) {
        return factorial(arrayLength) / factorial(arrayLength - r) * factorial(r);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


}
