package com.nhnacademy.parkminsu.Exercise4_3;

import java.util.InputMismatchException;

public class DiceView {

    public void simulation(int targetSum, int loopBreakNum) {
        try {
            DiceController diceController = new DiceController();
            System.out.println(diceController.sumTargetNumDice(targetSum, loopBreakNum));
        } catch (InputMismatchException e) {
            throw new InputMismatchException("목표 합의 데이터를 잘못 입력하셨습니다");
        }
    }

    public void printDice(String str, int num) {
        System.out.println(str + num);
    }

    public void simulationAverage(DiceController diceController, int loopBreakNum) {
        System.out.println(diceController.executionDicetotalSum(loopBreakNum));
    }
}
