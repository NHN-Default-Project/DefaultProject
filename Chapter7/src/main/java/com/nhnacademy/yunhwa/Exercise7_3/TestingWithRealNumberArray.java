package com.nhnacademy.yunhwa.Exercise7_3;

import java.util.Arrays;

public class TestingWithRealNumberArray {
    public double[] createArrayFilledWithElements(double[] doubleArr) { // 빈 double 배열 받아서 처리

        double randomDoubleNum;
        for (int i = 0; i < doubleArr.length; i++) {
            randomDoubleNum = Math.random() * 10000 + 1; // 1 부터 10001 전까지
            doubleArr[i] = randomDoubleNum;
        }

        return doubleArr;
    }


    public double getProcessingTimeSortingByArraysSort(double[] doubleArr) {

        long startTime = System.nanoTime();
        Arrays.sort(doubleArr);
        long endTime = System.nanoTime();

        // printSortedArray(doubleArr);

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 배열 선택 정렬해서 정렬된 배열을 리턴하는 메서드
    public double[] selectionSort(double[] doubleArr) {
        // 선택 정렬 구현
        for (int lastPlace = doubleArr.length - 1; lastPlace > 0; lastPlace--) {
            int maxLocation = 0;

            for (int i = 0; i <= lastPlace; i++) {
                if (doubleArr[i] > doubleArr[maxLocation]) {
                    maxLocation = i;
                }
            }

            double temp = doubleArr[maxLocation]; // 실제 최댓값 임시로 저장해두고
            doubleArr[maxLocation] = doubleArr[lastPlace]; // 실제 최댓값 위치한 자리에 이전 최댓값을 넣어주고
            doubleArr[lastPlace] = temp; // 이전 최댓값 위치한 자리(마지막 위치)에 실제 최댓값 넣어주기
        }
        return doubleArr;
    }


    public double getProcessingTimeSortingBySelectionSort(double[] doubleArr) {

        long startTime = System.nanoTime();
        doubleArr = selectionSort(doubleArr);
        long endTime = System.nanoTime();

        // printSortedArray(doubleArr);

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 정렬된 배열의 결과를 출력하는 메서드 (정렬 결과 확인용)
    public void printSortedArray(double[] doubleArr) {
        for (int i = 0; i < doubleArr.length; i++) {
            System.out.printf(" %.3f", doubleArr[i]);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


    // 1. 실수 배열로 주장을 테스트해보고 주장이 맞는지 여부 리턴하는 메서드
    public boolean isRealThisClaimWithRealNumbersArray() {
        System.out.println("이 주장을 실수 배열로 테스트 해보겠습니다.");

        final int SIZE = 100_000;

        double[] doubleArr = new double[SIZE];
        doubleArr = createArrayFilledWithElements(doubleArr);

        double arraysSortSeconds = getProcessingTimeSortingByArraysSort(doubleArr);
        double selectionSortSeconds = getProcessingTimeSortingBySelectionSort(doubleArr);

        return selectionSortSeconds > arraysSortSeconds;
        // 선택 정렬 시간이 더 크다는 건 선택 정렬이 더 오래 걸린다는 의미!
        // 주장이 참 이라면 선택 정렬에 걸린 시간이 더 클 것!
    }
}