package com.nhnacademy.yunhwa.Exercise3_3;

import java.util.Scanner;


// import java.util.Scanner;

public class Exercise3_3 {
    // 숫자1, 연산자, 숫자2 사용자에게 입력받고 결과값을 인쇄하자.
    // 표현식은 여러 개일 수 있다.
    // 입력 종료 조건은 "0" -> exit()

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);) {
            System.out.print("Enter a expression : ");

            BinaryOperator/*<Double>*/ binaryOperator;

            while (sc.hasNext()) {
                double num1 = sc.nextDouble();
                if (num1 == 0.0d) {
                    break;
                }
                char operator = sc.next().charAt(0);// +, -, *, /
                double num2 = sc.nextDouble();

                if (operator == '+') {
                    binaryOperator = new Plus();
                } else if (operator == '-') {
                    binaryOperator = new Subtract();
                } else if (operator == '*') {
                    binaryOperator = new Multiply();
                } else if (operator == '/') {
                    binaryOperator = new Divide();
                } else {
                    throw new IllegalArgumentException("잘못된 연산자가 들어왔습니다. +, -, *, / 중에서 하나를 입력해주세요.");
                }

                System.out.println("결과값 : " + binaryOperator.apply(num1, num2));
            }
        
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
