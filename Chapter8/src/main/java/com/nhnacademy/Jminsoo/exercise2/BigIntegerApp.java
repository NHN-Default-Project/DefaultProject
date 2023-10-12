package com.nhnacademy.Jminsoo.exercise2;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BigIntegerApp {

    private Scanner scanner;
    private BigInteger value;

    public BigIntegerApp() {
        scanner = new Scanner(System.in);
        value = new BigInteger("0");
    }

    public void start() {
        while (true) {
            try {
                System.out.print("3n + 1 을 계산합니다. n을 입력하시오 : ");
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                value = new BigInteger(input);
                value = value.multiply(new BigInteger("3"));
                value = value.add(new BigInteger("1"));
                System.out.printf("값 : %s%n", value);

            } catch (NumberFormatException e) {
                System.out.println("유효한 입력값이 아닙니다!");
            } catch (NoSuchElementException | IllegalStateException e) {
                scanner = new Scanner(System.in);
            }
        }
        scanner.close();
    }
}
