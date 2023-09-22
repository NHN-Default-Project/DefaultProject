package com.nhnacademy.yunhwa.Exercise4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise4_5 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);) {
            printBeforeInput();

            String[] tmpStrArr = sc.nextLine().replaceAll("[^0-9. ]", "").trim().split(" ");

            printResult(sc, makeDoubleArrayFromString(tmpStrArr));
        }
    }


    public static void printBeforeInput() {
        System.out.println("-------------------------------------------------");
        System.out.println("\n아래 입력 형식 예시들을 참고하여\n double 형 배열을 만들 double 값들을 입력해주세요.");
        System.out.println("-------------------------------------------------");
        System.out.println("참고) 입력 형식 예시 1: { 3.1, 4.6, 5.1, 6.9, 7.0 }");
        System.out.println("참고) 입력 형식 예시 2: { 3.1  4.6  5.1  6.9  7.0 }");
        System.out.println("참고) 입력 형식 예시 3:   3.1  4.6  5.1  6.9  7.0 ");
        System.out.println("참고) 입력 형식 예시 4:   3.1, 4.6, 5.1, 6.9, 7.0");
        System.out.println("이렇게 중괄호를 쓰시는 건 자유입니다. 다만 꼭 1개 이상의 공백 또는 ','로 구분해서 입력해주세요");
        System.out.print(": ");
    }

    public static void printResult(Scanner sc, double[] array) {
        System.out.println("-------  해당 배열의 연산 결과값들  --------");

        System.out.format("배열 요소들의 최댓값 : %.1f\n", ArrayProcessors.maximumOfArray.apply(array));
        System.out.format("배열 요소들의 최솟값 : %.1f\n", ArrayProcessors.minimumOfArray.apply(array));
        System.out.format("배열 요소들의 합 : %.1f\n", ArrayProcessors.sumOfArray.apply(array));
        System.out.format("배열 요소들의 평균 값 : %.2f\n", ArrayProcessors.averageOfArray.apply(array));

        System.out.print("배열 안에 몇 개가 있는지 궁금한 타겟 값(double)을 입력해주세요 : ");
        String tmpValue = sc.nextLine().trim();
        double value = Double.valueOf(tmpValue);

        System.out.format("배열에 존재하는 %.2f 값의 개수 : %.0f 개\n", value, ArrayProcessors.counter(value).apply(array));
    }

    public static double[] makeDoubleArrayFromString(String[] tmpStrArr) {

        List<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < tmpStrArr.length; i++) {
            if (! tmpStrArr[i].isEmpty()) {
                doubleList.add(Double.valueOf(tmpStrArr[i]));
            }
        }

        double[] doubleArr = new double[doubleList.size()];
        for (int i = 0; i < doubleArr.length; i++) {
            doubleArr[i] = doubleList.get(i);
        }

        return doubleArr;
    }

}