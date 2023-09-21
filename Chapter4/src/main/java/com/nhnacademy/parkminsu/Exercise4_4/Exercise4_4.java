package com.nhnacademy.parkminsu.Exercise4_4;

import com.nhnacademy.parkminsu.Exercise4_3.DiceController;
import com.nhnacademy.parkminsu.Exercise4_3.DiceView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise4_4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);) {
            DiceView diceView = new DiceView();
            System.out.println("반복할 횟수를 입력하세요");
            diceView.simulationAverage(new DiceController(), scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new InputMismatchException("잘못된 데이터 값을 넣었습니다");
        }
    }

}
