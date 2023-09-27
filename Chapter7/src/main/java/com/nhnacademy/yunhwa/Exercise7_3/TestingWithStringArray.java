package com.nhnacademy.yunhwa.Exercise7_3;

import java.util.Arrays;

public class TestingWithStringArray {

    public String[] createArrayFilledWithElements(String[] stringArr) { // 빈 String 배열 받아서 처리

        // 하나의 문자열을 만들어 문자열 배열 각각에 대입
        int stringLength;
        for (int i = 0; i < stringArr.length; i++) {
            stringLength = (int) Math.random() * 20 + 1; // 문자열 길이는 1부터 20까지 랜덤으로 받기
            stringArr[i] = makeRandomString(stringLength);
        } // 랜덤 문자열 배열 완성시켜 리턴
        return stringArr;
    }


    // 메서드 내부에서 사용되는 메서드 : 만들고자 하는 문자열 길이만큼 문자를 랜덤으로 받아서 String빌더에 넣어주고 완성된 문자열을 리턴
    public String makeRandomString(int length) {
        final int ASCII_MAX_DECIMAL = 128;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomAscii = (int) Math.random() * ASCII_MAX_DECIMAL;
            sb.append((char) randomAscii);
        }

        return sb.toString();
    }


    public double getProcessingTimeSortingByArraysSort(String[] stringArr) {

        long startTime = System.nanoTime();
        Arrays.sort(stringArr);
        long endTime = System.nanoTime();

        // printSortedArray(doubleArr);

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 배열 선택 정렬해서 정렬된 배열을 리턴하는 메서드
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



    public double getProcessingTimeSortingBySelectionSort(String[] stringArr) {

        long startTime = System.nanoTime();
        stringArr = selectionSort(stringArr);
        long endTime = System.nanoTime();

        // printSortedArray(doubleArr);

        return (endTime - startTime) / 1000000000.0;
    }


    // 메서드 내부에서 정렬된 배열의 결과를 출력하는 메서드 (정렬 결과 확인용)
    public void printSortedArray(String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            System.out.print(stringArr[i]);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }



    // 2. 문자열 배열로 주장을 테스트해보고 주장이 맞는지 여부 리턴하는 메서드
    public boolean isRealThisClaimWithStringsArray() {
        System.out.println("이 주장을 문자열 배열로 테스트 해보겠습니다.");

        final int SIZE = 100_000;

        String[] stringArr = new String[SIZE];
        stringArr = createArrayFilledWithElements(stringArr);

        double arraysSortSeconds = getProcessingTimeSortingByArraysSort(stringArr);
        double selectionSortSeconds = getProcessingTimeSortingBySelectionSort(stringArr);

        return selectionSortSeconds > arraysSortSeconds;
        // 선택 정렬 시간이 더 크다는 건 선택 정렬이 더 오래 걸린다는 의미!
        // 주장이 참 이라면 선택 정렬에 걸린 시간이 더 클 것!
    }
}