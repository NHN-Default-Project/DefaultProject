package com.nhnacademy.main;

import com.nhnacademy.yunhwa.Exercise5_3.Range;

public class RollAPairOfDice {
    private PairOfDice pairOfDice;
    private int rollNumber; // 총 몇 번 돌릴지

    public RollAPairOfDice(PairOfDice pairOfDice, int rollNumber) {
        this.pairOfDice = pairOfDice;
        this.rollNumber = rollNumber;

    }

    public void rollNumber(StatCalc statCalc, int goalValue) {
        for (int i = 0; i < this.rollNumber; i++) {
            this.pairOfDice.roll();
            statCalc.enter(countRollForGoalV(goalValue));
        }
    }

    public int countRollForGoalV(int goalValue) {
        int rollingNumber = 1;

        Range validRange = new Range(2, 12);
        if (goalValue < validRange.getMinValue() || goalValue > validRange.getMaxValue()) {
            throw new IllegalArgumentException("가능한 합계가 아닙니다.");
        }

        while (this.pairOfDice.getSumValue() != goalValue) {
            this.pairOfDice.roll();
            rollingNumber++;
        }
        return rollingNumber;
    }
}
