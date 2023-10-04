package org.example.Jminsoo;

import java.util.ArrayList;
import java.util.List;

public class lessonExample {
    private static double correct = 0;

    private static final int[] TEST_CASES_RESULTS = {
            1,
            10,
            100,
            // 10000,
            // 10000
    };

    private static final int[][] TEST_CASES = {
            {5, 7, 2},
            {10, 20, 30, 40},
            {100, 10, 10000},
            // { 10000, 100000 },
            // { 10000, 100000000, 10 }
    };

//    private static boolean test(int[] input, int result) {
//        if (solution(input) == (result)) {
//            correct++;
//            return true;
//        }
//
//        return false;
//    }

    public static void main(String[] args) {


//        for (int i = 0; i < TEST_CASES.length; i++) {
//            System.out.println("Test Case " + (i + 1) + " = " + test(TEST_CASES[i], TEST_CASES_RESULTS[i]));
//        }
//
//        System.out.printf("정답률 = %.3f%%\n", (correct / TEST_CASES.length * 100));
        // ...
    }

    //
    public static int[][] combination(int[] array, int k) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[k];

        int combinationNum = combinationNum(array.length, k);
        int[][] result = new int[combinationNum][k];

        boolean[] isVisit = new boolean[array.length];

        return result;
    }


    public static int combinationNum(int n, int k) {
        return factorial(n) / (factorial(n - k) * factorial(k));
    }

    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
