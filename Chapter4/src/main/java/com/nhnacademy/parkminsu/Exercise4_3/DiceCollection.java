package com.nhnacademy.parkminsu.Exercise4_3;

import java.util.HashMap;
import java.util.Map;

public class DiceCollection {
    private final Dice firstDice;
    private final Dice secondDice;
    private int numOfDiceRolled;
    private final int endDiceRolled = 10000;
    private Map<Integer, Double> averageNumOfRoll;
    private final int totalBeginRange = 2;
    private final int totalEndRange = 12;


    public DiceCollection() {
        this.firstDice = new Dice();
        this.secondDice = new Dice();
        this.numOfDiceRolled = 0;
        this.averageNumOfRoll = new HashMap<>();
        averageNumOfRollInit();
    }

    public void rollOfDice() {
        this.firstDice.setDiceEye((int) (Math.random() * 6) + 1);
        this.secondDice.setDiceEye((int) (Math.random() * 6) + 1);
        this.checkTotalRange();
        this.numOfDiceRolled++;
    }

    public void averageNumOfRollInit() {
        for (int i = this.totalBeginRange; i <= this.totalEndRange; i++) {
            this.averageNumOfRoll.put(i, 0.0);
        }
    }

    public boolean checkSumOfTheDice(int total) {
        return this.firstDice.getDiceEye() + this.secondDice.getDiceEye() == total;
    }

    public void checkTotalRange() {
        if (this.getFirstDice().getDiceEye() + this.getSecondDice().getDiceEye() > 12) {
            throw new IllegalArgumentException("totalNum >12");
        }
    }

    public void totalNumofDice() {
        for (int start = 0; start < this.endDiceRolled; start++) {
            rollOfDice();
            for (int i = this.totalBeginRange; i <= totalEndRange; i++) {
                if (checkSumOfTheDice(i)) {
                    this.averageNumOfRoll.put(i, this.averageNumOfRoll.get(i) + 1.0);
                }
            }
        }
    }

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
