package com.nhnacademy.yunhwa.Exercise7_1;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateArrayListOfRandomNumsOfSpecifiedRange { // 7_1 예제
    // 1 부터 지정된 최댓값 까지의 범위의 각각 다른 랜덤 정수를 포함하는 ArrayList() 생성
    // 리스트의 길이(정수의 개수) 와 정수에 허용되는 최댓값은 파라미터로 받기
    // 해당 메서드를 테스트하는 건 main() 에서 하기

    private List<Integer> intList;
    private int intCount;
    private int maxIntNum;

    public CreateArrayListOfRandomNumsOfSpecifiedRange() {
        intList = new ArrayList<>();
    }

    public void userInputBeforeAction() {
        try (Scanner sc = new Scanner(System.in);) {
            System.out.print("\n만들려는 ArrayList에 넣을 정수의 개수 : ");
            this.intCount = sc.nextInt();
            System.out.print("\n넣으려는 정수들의 랜덤 범위의 최댓값 : ");
            this.maxIntNum = sc.nextInt();
        }
    }

    public int getIntCount() {
        return this.intCount;
    }

    public int getMaxIntNum() {
        return this.maxIntNum;
    }

    // 문제 요구 조건에 따라 필드 사용 바로하면 되지만, 파라미터로 받게 설정.
    public void action(int intCount, int maxIntNum) {
        int randomNum;

        for (int i = 0; i < intCount; i++) { // 정수의 개수 만큼 넣어주기
            randomNum = (int) (Math.random() * (maxIntNum + 1)); // 1 ~ maxNum 중 랜덤 숫자
            intList.add(randomNum);
        }
    }

    public List<Integer> getIntList() {
        return this.intList;
    }

    public void printConstructedArrayList() {
        System.out.println();
        for (int i = 0; i < this.getIntList().size(); i++) {
            System.out.printf("%d ", this.getIntList().get(i));
        }
        System.out.println();
    }

}