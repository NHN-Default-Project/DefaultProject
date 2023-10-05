package com.nhnacademy.Jminsoo.excercise2;

import java.math.BigInteger;
import java.util.Scanner;

public class CollatzApp {

    private Scanner scanner;
    private BigInteger result;

    public CollatzApp() {
        this.scanner = new Scanner(System.in);
        this.result = new BigInteger("0");
    }

    public void start() {
        while (true) {
            try {
                System.out.print("콜라츠 추측을 시행합니다. n을 입력하시오 : ");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                result = new BigInteger(input);
                result = collatzCalculate(result, 0);
                System.out.printf("값 : %s%n", result);

            } catch (NumberFormatException e) {
                System.out.println("유효한 입력값이 아닙니다!");
            }
        }
        this.scanner.close();
    }

    public BigInteger collatzCalculate(BigInteger bi, int count) {
        if (bi.signum() < 1) {
            throw new NumberFormatException();
        }
        System.out.println(bi);

        if (bi.equals(new BigInteger("1"))) {
            return new BigInteger(String.valueOf(count));
        }
        //홀수
        if (bi.testBit(0)) {
            return collatzCalculate((bi.multiply(new BigInteger("3")).add(new BigInteger("1"))), count + 1);
        } else {
            //짝수
            return collatzCalculate(bi.divide(new BigInteger("2")), count + 1);
        }


    }
}
