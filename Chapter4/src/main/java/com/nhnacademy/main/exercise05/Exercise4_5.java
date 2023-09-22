package com.nhnacademy.main.exercise05;

import static com.nhnacademy.main.exercise05.ArrayCalc.*;

/*
 *https://math.hws.edu/javanotes/c4/exercises.html
 * 실수값의 배열을 처리하는 ArrayProcessor유형의 정적 변수 4개를 정의하는 CalcArray클래스를 작성합니다.
 * 입력된 값의 최대값, 최소값, 합계, 평균, 5가 포함된 개수를 출력합니다.
 */
public class Exercise4_5 {
    public static void main(String[] args) {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.printf("max value is %.4f\n", max.apply(array));
        System.out.printf("min value is %.4f\n", min.apply(array));
        System.out.printf("sum is %.4f\n", sum.apply(array));
        System.out.printf("average value is %.4f\n", average.apply(array));
        System.out.printf("counter value is %.4f\n", counter(5.0).apply(array));
    }
}
