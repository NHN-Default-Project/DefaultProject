package com.nhnacademy.gaeun.exercise03;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(diceRoll(scanner.nextInt()));
        } catch (IllegalArgumentException e) {
            System.out.println("양의 정수를 입력해주세요!");
        } catch (InputMismatchException ime) {
            System.out.println("정수값을 입력해주세요!");
        }
        scanner.close();
    }

    public static int diceRoll(int goalValue) {
        int rollingNumber = 1;
        if (goalValue < 2 || goalValue > 12) {
            throw new IllegalArgumentException("가능한 합계가 아닙니다.");
        }
        while (dice() + dice() != goalValue) {
            rollingNumber++;
        }
        return rollingNumber;
    }

    public static int dice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}