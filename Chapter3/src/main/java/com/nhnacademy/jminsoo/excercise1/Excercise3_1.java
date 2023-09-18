package com.nhnacademy.jminsoo.excercise1;

public class Excercise3_1 {

    final static int DICE_COUNT = 2;

    public static void main(String[] args) {
        int count = 0;
        boolean isOne = false;
        Dice[] dice = new Dice[DICE_COUNT];

        for (int i = 0; i < DICE_COUNT; i++) {
            dice[i] = new Dice();
        }

        while (true) {
            for (int i = 0; i < DICE_COUNT; i++) {
                System.out.println((i + 1) + "번째" + dice[i]);

                if (dice[i].getDiceNum() != 1) {
                    dice[i].diceRoll();
                    isOne = false;
                    break;
                } else {
                    isOne = true;
                }
            }
            count++;

            if (isOne) {
                break;
            }
        }

        System.out.println("모두 1이 나올 때까지 주사위를 굴린 횟수 : " + count);
    }
}

class Dice {
    private int diceNum;

    Dice() {
        this.diceNum = (int) (Math.random() * 6 + 1);
    }

    public void diceRoll() {
        this.diceNum = (int) (Math.random() * 6 + 1);
    }

    @Override
    public String toString() {
        return "Dice Number : " + this.diceNum;
    }

    public int getDiceNum() {
        return diceNum;
    }
}