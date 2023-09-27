package com.nhnacademy.yunhwa.Exercise7_3;

public class TestingClaimThatArraysSortIsMuchFasterThanSelectionSort {
    TestingWithRealNumberArray testWithRealNumberArray;
    TestingWithStringArray testWithStringArray;

    public TestingClaimThatArraysSortIsMuchFasterThanSelectionSort() {
        this.testWithRealNumberArray = new TestingWithRealNumberArray();
        this.testWithStringArray = new TestingWithStringArray();
    }

    public void printReslut(boolean isCorrect) {
        if (isCorrect) {
            System.out.println(" Arrays.sort() 가 선택 정렬 보다 훨씬 빠르고 효율적이라는 주장이 맞았습니다 !!!");
        } else {
            System.out.println(" 이런! Arrays.sort() 가 선택 정렬 보다 훨씬 빠르고 효율적이라는 주장은 틀렸습니다 ...");
        }
    }

}




