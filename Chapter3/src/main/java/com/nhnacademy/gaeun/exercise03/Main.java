
package com.nhnacademy.gaeun.exercise03;

import com.nhnacademy.gaeun.textio.TextIO;

public class Main {
    char operation;
    double first, second;

    public static void main(String[] args) {
        double large = TextIO.getDouble();
        char operation = TextIO.getChar();
        double small = TextIO.getDouble();

        System.out.println(calculate(large, operation, small));

    }

    public static double calculate(double large, char operation, double small) {
        double result = 0;
        switch (operation) {
            case '+':
                result = large + small;
                break;
            case '-':
                result = large - small;
                break;
            case '*':
                result = large * small;
                break;
            case '/':
                result = large / small;
                break;
        }
        return result;
    }
}
