package com.nhnacademy.jaehyeon.exercise8_4;

import java.util.Scanner;

public class Exercise8_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("입력하세요");
                String inputString = scanner.nextLine();
                Expr expr = new Expr(inputString);
                double inputNumber = Double.parseDouble(inputString);
            } catch (NumberFormatException n) {
                System.out.println("double Error");
            } catch (IllegalArgumentException e) {
                System.out.println("Error");
            }
        }

    }
}

