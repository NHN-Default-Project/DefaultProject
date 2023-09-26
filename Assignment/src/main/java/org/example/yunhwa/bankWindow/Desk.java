package org.example.yunhwa.bankWindow;

import java.util.Queue;

public class Desk extends Thread {
    private int deskNumber;
    private final int processingTime;
    private static WaitingList waitingList;
    static int count;

    public Desk(int processingTime, WaitingList waitingList) {
        count++;
        setDeskNumberByCount();
        this.processingTime = processingTime;
        this.waitingList = waitingList;
    }

    public void setDeskNumberByCount() {
        this.deskNumber = count;
    }

    public int getDeskNumber() {
        return this.deskNumber;
    }

    @Override
    public void run() {
        while (true) {
            try {
                boolean isWaiting = true;
                int currentCustomerNumber = -1;

                synchronized (waitingList) {

                    if (! waitingList.getList().isEmpty()) {
                        isWaiting = false;

                        currentCustomerNumber = waitingList.getList().poll().getCustomerNumber();
                        System.out.printf("%d 번 창구에서 %d 번 고객님의 업무를 처리하기 시작하였습니다. %n", this.deskNumber, currentCustomerNumber);
                    } else {
                        System.out.printf("%d 번 창구에서 고객님을 기다리는 중입니다... %n", this.deskNumber);
                    }
                }
                Thread.sleep(processingTime); // 고객님 응대 시간
                if (!isWaiting) {
                    System.out.printf("%d 번 창구에서 %d 번 고객님의 업무가 처리 완료되었습니다. %n", this.deskNumber, currentCustomerNumber);
                    System.out.printf("%d 번 창구에서 서비스 대기중 입니다... %n", this.deskNumber);
                }

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}