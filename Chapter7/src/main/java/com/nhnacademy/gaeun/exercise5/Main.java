package com.nhnacademy.gaeun.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://math.hws.edu/javanotes/c7/exercises.html
 * Write a program that will read a sequence of positive real numbers entered by the user
 * and will print the same numbers in sorted order from smallest to largest
 * The user will input a zero to mark the end of the input
 * Assume that at most 100 positive numbers will be entered.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputArray = new ArrayList<>();
        int inputVal;
        int index = 0;
        System.out.println("Write a sequence of positive real numbers");
        System.out.println("If you want to stop, press the key '0'");
        while(true) {
            try {
                inputVal = scanner.nextInt();
                if(inputVal == 0) {
                    break;
                }
                if (index > 100) {
                    System.out.println("Array is full");
                    break;
                }
                inputArray.add(inputVal);
            } catch (IllegalArgumentException e) {

            }
        }
        int[] list = new int[inputArray.size()];
        for(int i = 0; i < inputArray.size(); i++) {
            list[i] = inputArray.get(i);
        }
        quickSort(list);
        printArray(list);
        scanner.close();
    }

    public static void quickSort(int[] inputArray) {
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    public static void quickSort(int[] inputArray, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && inputArray[left] <= inputArray[pivot]) {
                left++;
            }
            while (right > start && inputArray[right] >= inputArray[pivot]) {
                right--;
            }
            if (left > right) {
                swap(inputArray, right, pivot);
            } else {
                swap(inputArray, left, right);
            }
            quickSort(inputArray, start, right - 1);
            quickSort(inputArray, right + 1, end);
        }
    }

    public static void swap(int[] inputArray, int right, int pivot) {
        int tmp = inputArray[right];
        inputArray[right] = inputArray[pivot];
        inputArray[pivot] = tmp;
    }

    public static void printArray(int[] inputArray) {
        for (int val : inputArray) {
            System.out.printf("%d ", val);
        }
    }
}
