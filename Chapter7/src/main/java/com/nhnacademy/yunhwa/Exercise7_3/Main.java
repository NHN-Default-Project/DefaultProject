package com.nhnacademy.yunhwa.Exercise7_3;

public class Main {
    public static void main(String[] args) {
        TestingWithRealNumberArray testWithRealNumberArr = new TestingWithRealNumberArray();
        TestingWithStringArray testWithStringArr = new TestingWithStringArray(20);

        testWithRealNumberArr.printResult(testWithRealNumberArr.isRealThisClaimWithRealNumbersArray());
        testWithStringArr.printResult(testWithStringArr.isRealThisClaimWithStringsArray());

    }
}