package com.nhnacademy.main.exercise5_5;


import java.util.InputMismatchException;

import static com.nhnacademy.main.exercise5_5.BlackjackGame.printGameResult;

public class JudgeThread extends Thread {
    int judgeResult = 0;

    @Override
    public void run() {
        System.out.println("thread start");
        while (judgeResult == 0) {
            judgeResult = BlackjackGame.judgeGame();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            if (judgeResult == -1) { //dealer win!
                printGameResult("DEALER");
                System.exit(0);
            }
            if (judgeResult == 1) { //user win!!
                printGameResult("USER");
                System.exit(0);
            }
        }
    }
}
