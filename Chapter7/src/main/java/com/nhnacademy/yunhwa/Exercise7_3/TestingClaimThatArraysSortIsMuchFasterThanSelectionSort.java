package com.nhnacademy.yunhwa.Exercise7_3;

public interface TestingClaimThatArraysSortIsMuchFasterThanSelectionSort {

    default public void printResult(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Arrays.sort() 가 선택 정렬 보다 훨씬 빠르고 효율적이라는 주장이 맞았습니다 !!!");
            System.out.println("-----------------------------------------------------------------");
        } else {
            System.out.println("이런! Arrays.sort() 가 선택 정렬 보다 훨씬 빠르고 효율적이라는 주장은 틀렸습니다 ...");
            System.out.println("-----------------------------------------------------------------");
        }
    }

}




