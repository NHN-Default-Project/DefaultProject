package com.nhnacademy.yunhwa.Exercise5_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise5_2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);) {
            StatCalc statCalc = new StatCalc();
            System.out.println();

            while (true) {
                System.out.print("데이터 세트에 double 값을 추가해주세요 : ");
                double inputNum = sc.nextDouble();

                if(inputNum == 0) {
                    System.out.println("\n-- 여기까지 추가하여 데이터 세트를 완성하였습니다! --\n");
                    break;
                }

                statCalc.enter(inputNum);
            }

            int count = statCalc.getCount();
            double sum = statCalc.getSum();
            double max = statCalc.getMax();
            double min = statCalc.getMin();
            double mean = statCalc.getMean();
            double standardDeviation = statCalc.getStandardDeviation();

            System.out.println("데이터 세트 항목수  : " + count);
            System.out.println("데이터 세트 총 합계 : " + sum);
            System.out.println("데이터 세트 최댓값  : " + max);
            System.out.println("데이터 세트 최솟값  : " + min);
            System.out.format("데이터 세트 평균값  : %.2f\n", mean);
            System.out.format("데이터 세트 표준편차: %.5f\n\n", standardDeviation);


        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
}
