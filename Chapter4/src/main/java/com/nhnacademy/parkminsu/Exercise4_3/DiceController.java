package com.nhnacademy.parkminsu.Exercise4_3;

import java.util.HashMap;
import java.util.Map;

public class DiceCollection {
    private final Dice firstDice;
    private final Dice secondDice;
    private int numOfDiceRolled;
    private int targetLoop;
    private Map<Integer, Double> averageNumOfRoll;
    private final int totalBeginRange = 2;
    private final int totalEndRange = 12;

    private int targerSumValue;

    public DiceCollection() {
        this.firstDice = new Dice();
        this.secondDice = new Dice();
        this.numOfDiceRolled = 0;
        this.averageNumOfRoll = new HashMap<>();
        this.targerSumValue = targerSumValue;
        averageNumOfRollInit();
    }

    public int getTargerSumValue() { // 목표 반복문
        return targerSumValue;
    }



    public int rollCount(int count){
        return count++;
    }

    public void getLoop(int numOfDiceRolled) {
        this.targetLoop = numOfDiceRolled;
    }

    public void averageNumOfRollInit() {
        for (int i = this.totalBeginRange; i <= this.totalEndRange; i++) {
            this.averageNumOfRoll.put(i, 0.0);
        }
    }

    public boolean checkSumOfTheDice(int total) {
        return this.firstDice.getDiceEye() + this.secondDice.getDiceEye() == total;
    }

    public void checkTotalRange(int targerSumValue) {
        if (targerSumValue > totalEndRange || targerSumValue < totalBeginRange) {
            throw new IllegalArgumentException("targetNum < 2 or target >12 ");
        }
    }

    public void rollTargetSum(int num) {
        int cnt = 0;
        while (true) {
            if (cnt == endDiceRolled) {
                break;
            }
            rollOfDice();
            cnt++;

            if (checkSumOfTheDice(num)) {
                this.averageNumOfRoll.put(num, this.averageNumOfRoll.get(num) + cnt);
            }

        }
    }

    public void

    public void findAverageTotalDice() {
        for (int i = this.totalBeginRange; i <= this.totalEndRange; i++) {
            this.averageNumOfRoll.put(i, (this.averageNumOfRoll.get(i) / this.endDiceRolled) * this.endDiceRolled);
        }
    }

    public Map<Integer, Double> getAverageNumOfRoll() {
        return averageNumOfRoll;
    }

    public Dice getFirstDice() {
        return firstDice;
    }

    public Dice getSecondDice() {
        return secondDice;
    }

    public int getNumOfDiceRolled() {
        return numOfDiceRolled;
    }

    public int getTotalEndRange() {
        return totalEndRange;
    }
}
