package com.nhnacademy.jminsoo.exercise3;

import com.nhnacademy.jminsoo.textio.TextIO;


public class Exercise3_3 {

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.print("간단한 표현식을 입력해주세요(*, -, +) : ");

                double num1 = TextIO.getDouble();

                if (num1 == 0) {
                    break;
                }

                char operator = TextIO.getChar();
                double num2 = TextIO.getDouble();
                System.out.printf("%.2f %c %.2f = ", num1, operator, num2);
                System.out.println(expression(num1, operator, num2));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    public static double expression(double num1, char operator, double num2) {
        double result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '-') {
            result = num1 - num2;

        } else if (operator == '*') {
            result = num1 * num2;
        } else {
            throw new IllegalArgumentException("연산자가 잘못되었습니다!");
        }

        return result;
    }

}