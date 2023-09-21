package com.nhnacademy.yunhwa.Exercise5_5;


import java.util.Scanner;

public class Exercise5_5 {

    public static void main(String[] args) {

        BlackjackGame blackjackGame = new BlackjackGame();
        boolean isUserWin = blackjackGame.playGameByUser();
        blackjackGame.printGameResult(isUserWin);
    }

    






    
}