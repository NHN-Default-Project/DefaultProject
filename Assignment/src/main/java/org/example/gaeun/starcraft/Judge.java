package org.example.gaeun.starcraft;

import org.example.gaeun.starcraft.kinds.Kind;

public class Judge implements Runnable {
    private Kind winner;
    private boolean shouldRun = false;
    public synchronized void startRunning() {
        synchronized (this){
            shouldRun = true;
            notifyAll();
        }
    }
    public void stopRunning() {
        shouldRun = false;
    }
    public boolean judgeWinner(Kind user, Kind computer) {
        if(user.getUnits().isEmpty()) {
            winner = computer;
            return true;
        } else if(computer.getUnits().isEmpty()) {
            winner = user;
            return true;
        }
        return false;
    }
    public void printJudgement() {
        System.out.printf("%s이 승리했습니다!!", winner.getName());
    }

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                if (!shouldRun) {
                    try {
                        wait();
                    } catch (InterruptedException | IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (judgeWinner(Starcraft.userKind, Starcraft.computerKind)) {
                GameStart.setFinished();
                System.out.println("=============================================");
                System.out.println("게임이 종료되었습니다.");
                printJudgement();
                System.exit(0);
            }
            stopRunning();
        }
    }
}
