package com.nhnacademy.Jminsoo.exercise5;

public class BlackjackPrint {

    public void printGameEnd(int gamesPlayed, double averageScore, int sumBet, int money) {
        System.out.println();
        System.out.println("게임 횟수 :  " + gamesPlayed + " games.");
        System.out.printf("승률 : %1.3f.\n", averageScore);
        System.out.printf("플레이어가 건 베팅 :%d\n", sumBet);
        System.out.printf("플레이어의 돈 : %d\n", money);
    }
}
