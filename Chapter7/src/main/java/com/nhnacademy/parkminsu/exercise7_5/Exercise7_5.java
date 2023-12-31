package com.nhnacademy.parkminsu.exercise7_5;

import java.util.*;

public class Exercise7_5 {
    public static void main(String[] args) {
        double inputDouble = 0.0;
        List<Double> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                inputDouble = scanner.nextDouble();
                if (inputDouble == 0.0) {
                    break;
                }
                list.add(inputDouble);
            } catch (InputMismatchException e) {
                System.out.println("데이터를 잘못 입력하셨습니다.");
            }
        }
        System.out.println(selectionSort(list));
        scanner.close();
    }

    public static List<Double> selectionSort(List<Double> list) {

        int minIndex = 0;
        Iterator<Double> iterator = list.stream().iterator();
        Iterator<Double> iterator1 = list.stream().iterator();
        while (iterator.hasNext()) {
            while (iterator1.hasNext()) {
                if (iterator.next() > iterator1.next()) {
                    int index = list.indexOf(iterator);
                }
            }
        }


        for (int i = 0; i < list.size(); i++) {
            double min = Double.MAX_VALUE;
            for (int j = i; j < list.size(); j++) {
                if (min > list.get(j)) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            double tmp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, tmp);
        }
        return list;
    }
}
