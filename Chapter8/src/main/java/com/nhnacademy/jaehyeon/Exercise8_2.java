package com.nhnacademy.jaehyeon;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise8_2 {

    public static void main(String[] args) {
        Exercise8_2 exercise8_2 = new Exercise8_2();
        String inputNumberN = exercise8_2.inputNumber();

        BigInteger N = new BigInteger(inputNumberN);
        System.out.println(exercise8_2.countSequenceCalculate(N));
    }

    private String inputNumber() {
        System.out.println("숫자 입력하세요");
        String inputNumber = "";
        try (Scanner scanner = new Scanner(System.in)) {
            inputNumber = scanner.nextLine();
            if (!isNumber(inputNumber)) {
                System.out.println("숫자만 입력하세요");
                inputNumber();
            }
        }
        return inputNumber;
    }

    private boolean isNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int countSequenceCalculate(BigInteger N) {
        int count = 0;
        BigInteger number = N;
        while (!number.equals(new BigInteger("1"))) {
            count += 1;
            if (!number.testBit(0)) {
                number = number.divide(new BigInteger("2"));
            } else {
                number = number.multiply(new BigInteger("3")).add(new BigInteger("1"));
            }
        }
        return count;
    }
}