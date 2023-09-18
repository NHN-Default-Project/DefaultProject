package com.nhnacademy.parkminsu.Exercise4_3;

public class Exercise4_3 {
    private static final int SNAKEEYE = 2;

    public static void main(String[] args) {
        try {
            DiceCollection dice = new DiceCollection();

            simulation(dice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void simulation(DiceCollection dice) {
        while (true) {
            dice.rollOfDice();
            if (dice.checkSumOfTheDice(SNAKEEYE)) {
                break;
            }

            System.out.printf("굴린 횟수: %d\n주사위1 눈: %d\n주사위2 눈: %d\n\n",
                    dice.getNumOfDiceRolled(), dice.getFirstDice().getDiceEye(), dice.getSecondDice().getDiceEye());
        }
        System.out.printf("최종 굴린 횟수: %d\n주사위1 눈: %d\n주사위2 눈: %d\n\n",
                dice.getNumOfDiceRolled(), dice.getFirstDice().getDiceEye(), dice.getSecondDice().getDiceEye());

    }
}

