package com.nhnacademy.yunhwa.Exercise3_6;

import java.util.ArrayList;
import java.util.List;

public class Exercise3_6 {
    // 1 ~ 10_000 사이의 정수 중 가장 많은 약수를 가진 정수들을 모두 출력하는 프로그램
    // 각 숫자의 약수 개수를 배열에 저장하고 최대 개수인 것 모두 출력 
    public static void main(String[] args) {
        int MAX_NUMBER = 10_000;
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

        System.out.format("1부터 %d 사이의 정수 중\n", MAX_NUMBER);
        System.out.format("최대 약수 수는 %d개입니다.\n", maxCount);
        System.out.format("약수가 많은 숫자는 다음과 같습니다.\n");

        // 인덱스 1 부터 10_000까지 돌면서 최대 개수이면 출력
        for (int i = 1; i < divisorCounts.size(); i++) {
            if (divisorCounts.get(i) == maxCount) {
                System.out.println("   " + i);
            }
        }

    }

    public static boolean isDivisor(int N, int d) {
        if (N % d == 0) {
            return true;
        }
        else {
            return false;
        }
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
