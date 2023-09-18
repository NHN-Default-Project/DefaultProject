package com.nhnacademy.yunhwa.Exercise3_2;

import java.util.ArrayList;
import java.util.List;

public class Exercise3_2 {
    // 1 ~ 10_000 사이의 정수 중 가장 많은 약수를 가진 정수는 무엇이며, 해당 정수의 약수의 개수는 몇 개인가?
    // 답을 구하고 출력하는 프로그램
    // 약수의 개수가 가장 많은 정수는 2개 이상일 수도 있다.
    // 프로그램은 오직 그 중 하나만 출력해야 한다. -> 가장 많은 정수인 것을 처음으로 찾고 출력하고 그냥 끝내면 된다.

    static final int MAX_NUMBER = 10_000;

    public static void main(String[] args) {
        
        List<Integer> divisorCounts = new ArrayList<>(MAX_NUMBER +1);
        divisorCounts.add(0); // 인덱스 0은 무시하려고 하나 추가해주기.

        int maxCount = 0;

        // 인덱스 1부터 10_000까지 돌면서 약수 개수 구하고 최대면 대체
        for (int number = 1; number <= MAX_NUMBER; number++) {
            int thisNumberCount = howManyDivisors(number);
            divisorCounts.add(thisNumberCount);
            
            if (maxCount < thisNumberCount) {
                maxCount = thisNumberCount;
            }
        }

        System.out.println(divisorCounts.get(divisorCounts.indexOf(maxCount)));
    }

    public static boolean isDivisor(int N, int d) {
        return (N % d == 0);
    }

    public static int howManyDivisors(int number) {
        int divisorCount = 0;

        // 1부터 자기자신까지 돌면서 약수라면 개수 카운팅
        for (int i = 1; i <= number; i++) {
            if (isDivisor(number, i)) {
                divisorCount++;
            }
        }
        return divisorCount;

    }


}
