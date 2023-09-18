package com.nhnacademy.parkminsu.Exercise4_4;

import com.nhnacademy.parkminsu.Exercise4_3.DiceCollection;

public class Exercise4_4 {
    public static void main(String[] args) {
        DiceCollection diceCollection = new DiceCollection();
        simulation(diceCollection);
    }

    public static void simulation(DiceCollection diceCollection) {
        diceCollection.totalNumofDice();
        diceCollection.averageTotalDice();
        System.out.println("주사위 총합 \t평균 굴림 횟수");
        System.out.println("---------\t------------");
        for (int i : diceCollection.getAverageNumOfRoll().keySet()) {
            System.out.printf("\t%d\t\t%f\t\n", i, diceCollection.getAverageNumOfRoll().get(i));
        }
    }
}
