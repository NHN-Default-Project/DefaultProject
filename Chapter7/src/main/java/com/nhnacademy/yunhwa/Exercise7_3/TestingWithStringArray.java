package com.nhnacademy.yunhwa.Exercise7_3;

import java.util.Arrays;

public class TestingWithStringArray implements TestingClaimThatArraysSortIsMuchFasterThanSelectionSort {
    String[] stringArr;
    final int ARR_SIZE = 100_000;


    public TestingWithStringArray(int strLengthLimit) {
        this.stringArr = new String[ARR_SIZE];

        // 하나의 문자열을 만들어 문자열 배열 각각에 대입
        int stringLength;
        for (int i = 0; i < stringArr.length; i++) {
            stringLength = (int) (Math.random() * strLengthLimit) + 1; // 문자열 길이는 1부터 strLengthLimit까지 랜덤으로 받기
            this.stringArr[i] = makeRandomString(stringLength);
        } // 랜덤 문자열 배열 완성
    }


    // 메서드 내부에서 사용되는 메서드 : 만들고자 하는 문자열 길이만큼 문자를 랜덤으로 받아서 String빌더에 넣어주고 완성된 문자열을 리턴
    public String makeRandomString(int length) {
        final int ASCII_UPPER_A = 65;
        final int ASCII_UPPER_Z = 90;
        final int ASCII_LOWER_A = 97;
        final int ASCII_LOWER_Z = 122;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomUpperLower = (int) (Math.random() * 2);
            int randomAscii = -1;
            switch (randomUpperLower) {
                case 0:
                    randomAscii = (int) (Math.random() * (ASCII_UPPER_Z - ASCII_UPPER_A + 1)) + ASCII_UPPER_A;
                    break;
                case 1:
                    randomAscii = (int) (Math.random() * (ASCII_LOWER_Z - ASCII_LOWER_A + 1)) + ASCII_LOWER_A;
                    break;
            }
            sb.append((char) randomAscii);
        }
        return sb.toString();
    }


    public double getProcessingTimeSortingByArraysSort() {

        long startTime = System.nanoTime();

        String[] arraysSortedArray = this.stringArr; // 복제
        Arrays.sort(arraysSortedArray);

        long endTime = System.nanoTime();

//        System.out.println("---------------------------");
//        printSortedArray(arraysSortedArray);
//        System.out.println("---------------------------");

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 배열 선택 정렬하기
    public String[] selectionSort(String[] stringArr) {
        // 선택 정렬 구현
        for (int lastPlace = stringArr.length - 1; lastPlace > 0; lastPlace--) {
            int maxLocation = 0;

            for (int i = 0; i <= lastPlace; i++) {
                if (stringArr[i].compareTo(stringArr[maxLocation]) > 0) {
                    maxLocation = i;
                }
            }

            String temp = stringArr[maxLocation]; // 실제 최댓값 임시로 저장해두고
            stringArr[maxLocation] = stringArr[lastPlace]; // 실제 최댓값 위치한 자리에 이전 최댓값을 넣어주고
            stringArr[lastPlace] = temp; // 이전 최댓값 위치한 자리(마지막 위치)에 실제 최댓값 넣어주기
        }

        return stringArr;
    }


    public double getProcessingTimeSortingBySelectionSort() {

        long startTime = System.nanoTime();
        String[] selectionSortedArray = selectionSort(this.stringArr);
        long endTime = System.nanoTime();

//        System.out.println("---------------------------");
//        printSortedArray(selectionSortedArray);
//        System.out.println("---------------------------");

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 정렬된 배열의 결과를 출력하는 메서드 (정렬 결과 확인용)
    public void printSortedArray(String[] sortedArr) {
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i]);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }


    // 2. 문자열 배열로 주장을 테스트해보고 주장이 맞는지 여부 리턴하는 메서드
    public boolean isRealThisClaimWithStringsArray() {
        System.out.println("이 주장을 문자열 배열로 테스트 해보겠습니다.");

        double arraysSortSeconds = getProcessingTimeSortingByArraysSort();
        double selectionSortSeconds = getProcessingTimeSortingBySelectionSort();

        return selectionSortSeconds > arraysSortSeconds;
        // 선택 정렬 시간이 더 크다는 건 선택 정렬이 더 오래 걸린다는 의미!
        // 주장이 참 이라면 선택 정렬에 걸린 시간이 더 클 것!
    }
}