package com.nhnacademy.yunhwa.Exercise7_3;

public class Main {
    public static void main(String[] args) {
        TestingClaimThatArraysSortIsMuchFasterThanSelectionSort testClaim = new TestingClaimThatArraysSortIsMuchFasterThanSelectionSort();

        testClaim.printReslut(testClaim.testWithRealNumberArray.isRealThisClaimWithRealNumbersArray());
        testClaim.printReslut(testClaim.testWithStringArray.isRealThisClaimWithStringsArray());

    }
}
