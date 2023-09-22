package com.nhnacademy.Jminsoo.excercise5;

public class DoubleSortCollection {

    public static void selectionSort(double[] doubleArray) {

        for (int lastPlace = doubleArray.length - 1; lastPlace > 0; lastPlace--) {

            int maxLoc = 0;

            for (int j = 1; j <= lastPlace; j++) {
                if (doubleArray[j] > doubleArray[maxLoc]) {

                    maxLoc = j;
                }
            }

            double temp = doubleArray[maxLoc];
            doubleArray[maxLoc] = doubleArray[lastPlace];
            doubleArray[lastPlace] = temp;

        }  // end of for loop
    }

    public static void bubbleSort(int[] array) {
        int temp;

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


}
