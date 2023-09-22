package com.nhnacademy.parkminsu.Exercise4_3;

import java.util.ArrayList;
import java.util.List;

public class DiceController {
    private final int beginRange = 2;
    private final int endRange = 12;
    private final PairOfDice pairOfDice = new PairOfDice();
    private final DiceView diceView = new DiceView();

    public boolean checkSumOfTheDice(PairOfDice pairOfDice, int total) {
        return pairOfDice.getDiceEye1() + pairOfDice.getDiceEye2() == total;
    }

    public void checkTotalRange(int targerSumValue) {
        if (this.beginRange < targerSumValue || targerSumValue < this.endRange) {
            throw new IllegalArgumentException("targetNum < 2 or target >12 ");
        }
    }

    public int sumTargetNumDice(int targetSum, int loopBreakNum) {
        this.pairOfDice.clearRollCount();
        int loopCount = 0;
        while (loopCount != loopBreakNum) {  //
            this.pairOfDice.diceRoll();
            if (checkSumOfTheDice(pairOfDice, targetSum)) { // 목표 값과 다이스 굴린 값이 같은
                loopCount++; //
            }
        }
        return pairOfDice.getRollCount();
    }

    public double averageDiceSum(int targetSum, int loopBreak) {
        return sumTargetNumDice(targetSum, loopBreak) / loopBreak;
    }

    public String executionDicetotalSum(int loopBreakNum) {
        List<String> result = new ArrayList<>();

        for (int i = this.beginRange; i <= this.endRange; i++) {
            result.add(i + " : " + averageDiceSum(i, loopBreakNum));
        }
        return result.toString();
    }


}
