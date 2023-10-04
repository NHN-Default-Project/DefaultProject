package com.nhnacademy.yunhwa.Exercise7_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortingPositiveRealNumbersByAsc {

    public double[] returnDoubleArrayFromuserInputBeforeAction() {
        List<Double> doubleList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("\n정렬을 해보기 위해 양의 실수 배열 하나를 만들어보려고 합니다.");
            while (true) {
                if (doubleList.size() > 100) {
                    System.out.println("너무 많은 수가 입력되었습니다. 입력을 종료합니다.");
                    break;
                }
                System.out.print("정렬하려는 양의 실수 배열의 값을 추가해주세요 (0이 들어오면 입력 종료) : ");
                double currentDouble = sc.nextDouble();
                if (currentDouble == 0.0) {
                    break;
                } else if (currentDouble < 0) {
                    System.out.println("양의 실수가 아니라, 음수가 들어왔습니다!! 값을 다시 입력해주세요!");
                    continue;
                }
                doubleList.add(currentDouble);
            }
            System.out.println();
        }

        double[] doubleArr = new double[doubleList.size()];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = doubleList.get(i);
        }

        return doubleArr;
    }


    // 삽입 정렬한 배열을 리턴하는 메서드
    public double[] action(double[] doubleArr) {
        int tgi, left;

        for (tgi = 1; tgi < doubleArr.length; tgi++) {
            double target = doubleArr[tgi];

            for (left = tgi - 1; left >= 0 && doubleArr[left] > target; left--) {
                doubleArr[left + 1] = doubleArr[left];
            }
            doubleArr[left + 1] = target;
        }

        return doubleArr;
    }


    public void printSortedArray(double[] doubleArr) {
        for (int i = 0; i < doubleArr.length; i++) {
            System.out.printf(" %.2f", doubleArr[i]);
        }
        System.out.println();
    }


}
