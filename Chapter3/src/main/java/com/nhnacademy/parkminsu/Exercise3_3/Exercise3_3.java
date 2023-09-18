package com.nhnacademy.parkminsu.Exercise3_3;

import com.nhnacademy.textio.TextIO;

public class Exercise3_3 {
    public static void main(String[] args) {
        double num1 = TextIO.getDouble();
        if (num1 == 0) {
            System.exit(0);
        }
        char operator = TextIO.getChar();
        double num2 = TextIO.getDouble();

        System.out.println("" + num1 + operator + num2 + " = " + calculator(num1, operator, num2));
    }

    public static double calculator(double num1, char operator, double num2) {
        if (operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 > num2 ? num1 - num2 : num2 - num1;
        } else if (operator == '*') {
            return num1 * num2;
        } else if (operator == '/') {
            return num2 != 0 ? num1 / num2 : 0;
        }

        return 0;
    }

}
