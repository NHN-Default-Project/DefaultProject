package org.example.parkminsu;

import java.util.Scanner;

public class Gcd {
    // 1. 조합으로 받긴함
    // 2. 메소드 이름을 다시 짜야할듯
    private static int COUNT = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("배열의 크기를 입력");
        int[] array = inputDataArray(scanner.nextInt(), scanner); // 값을 입력 받음

        System.out.println("조합할 수를 입력");
        int combinationNum = scanner.nextInt();
        int[][] combinationArray = crerateCombinationArray(findSizeOfCombination(array.length, combinationNum), combinationNum);
        boolean[] visited = new boolean[combinationArray.length];
        combinationArray = combination(combinationArray, array, visited, 0, array.length, combinationNum);

        int max = findMaxGcdCombination(combinationArray);
        for (int i = 0; i < combinationArray.length; i++) { // print 메소드로 따로 빼기
            for (int j = 0; j < combinationArray[i].length; j++) {
                System.out.printf("%d ", combinationArray[i][j]);
            }
            System.out.println();
        }
        System.out.printf("조합의 최대 공약수의 최대값: %d", max);
    }

    public static int[] inputDataArray(int arraySize, Scanner scanner) {
        if (arraySize < 0) { // 입력 받을 배열의 크기는 존재 해야함. 0 보다 작으면 안됨
            throw new IllegalArgumentException("입력한 배열의 길이가 잘못됐습니다.");
        }
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[][] crerateCombinationArray(int arraySize, int combinationNum) {
        if (arraySize * combinationNum > Integer.MAX_VALUE) {
            throw new StackOverflowError("Array의 size가 Integer의 사이즈를 넘겼습니다");
        }
        return new int[arraySize][combinationNum];
    } // 이걸 사용안하고 2차원 배열 만드는 방법은 없나..?

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }

    public static int findSizeOfCombination(int arraySize, int combinationNum) {
        if (arraySize < combinationNum) {
            throw new IllegalArgumentException("잘못된 값입니다.");
        }
        return factorial(arraySize) / (factorial(combinationNum) * factorial(arraySize - combinationNum));
    }

    public static int[][] combination(int[][] combinationArr, int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            combinationArr = storeNumOfCombination(combinationArr, COUNT, arr, visited, n);
            return combinationArr;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(combinationArr, arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
        return combinationArr;
    }


    public static int[][] storeNumOfCombination(int[][] array, int combinationArrIdx, int[] arr, boolean[] visited, int n) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                array[combinationArrIdx][idx] = arr[i];
                idx++;
            }
        }
        COUNT++;
        return array;
    }

    public static int findGcdArray(int[] combinationArray) {
        int result = 0;
        for (int i = 0; i < combinationArray.length; i++) {
            result = gcd(combinationArray[i], result);
        }
        return result;
    }

    public static int[] storeGcdOfCombination(int[][] combinationAry) {
        int[] gcdArray = new int[combinationAry.length];
        for (int i = 0; i < combinationAry.length; i++) {
            gcdArray[i] = findGcdArray(combinationAry[i]);
        }
        return gcdArray;
    }

    public static int maxGcd(int[] gcdAry) {
        int max = gcdAry[0];
        for (int i = 1; i < gcdAry.length; i++) {
            if (max < gcdAry[i]) {
                max = gcdAry[i];
            }
        }
        return max;
    }

    public static int findMaxGcdCombination(int[][] combinaitonArray) {
        return maxGcd(storeGcdOfCombination(combinaitonArray));
    }


}
