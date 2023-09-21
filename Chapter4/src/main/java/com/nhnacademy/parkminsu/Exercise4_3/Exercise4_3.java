package com.nhnacademy.parkminsu.Exercise4_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise4_3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("구하고 싶은 합을 입력하세요(2 ~ 12): ");
            DiceView diceView = new DiceView();
            diceView.simulation(scanner.nextInt(), 1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }


}

