package com.nhnacademy.gaeun.exercise05;


import static com.nhnacademy.gaeun.exercise05.BlackjackGame.isStandCall;
import static com.nhnacademy.gaeun.exercise05.BlackjackGame.printGameResult;

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
