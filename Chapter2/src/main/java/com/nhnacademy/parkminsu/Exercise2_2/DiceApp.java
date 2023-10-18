package com.nhnacademy.parkminsu.Exercise2_2;

import java.util.ArrayList;
import java.util.List;

public class DiceApp {
    private final int diceNum;
    private final int diceEye;
    private int rollCnt;
    private List<Dice> eyeOfDiceList;

    public DiceApp(int diceEye, int diceNum) {
        this.rollCnt = 0;
        this.diceEye = diceEye;
        this.diceNum = diceNum;
        this.eyeOfDiceList = new ArrayList<>();
        this.createDice(); // 여기 있는게 맞나..?
    }

    public void createDice() { // 다이스 생성
        if (this.eyeOfDiceList.size() == this.diceNum) {
            return;
        }
        this.eyeOfDiceList.add(new Dice(this.diceEye));
        createDice();
    }

    public void rollDices() {
        int cnt = rollCnt;
        if (rollCnt == this.diceNum) {
            return;
        }
        rollCnt++;
        rollDices();
        this.eyeOfDiceList.get(cnt).roll();
    }

    public int sum() {
        return this.eyeOfDiceList.stream()
                .map(Dice::getRolledNum)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
