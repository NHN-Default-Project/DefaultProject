package com.nhnacademy.Jminsoo.exceercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public final static int DICE_COUNT = 2;
    public final static int EYES = 6;

    public static void main(String[] args) {
        DiceApp diceApp = new DiceApp(DICE_COUNT, EYES);


        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("주사위의 합계를 입력해주세요 : ");
            int number = scanner.nextInt();
            System.out.printf("모두 %d 이(가) 나올 때까지 주사위를 굴린 횟수 : %d\n", number, diceApp.countCorrectNumber(number));
        } catch (InputMismatchException e) {
            System.out.println("숫자 입력값이 아닙니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

