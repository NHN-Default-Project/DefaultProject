package org.example.parkminsu.Thread;

public class CustomerFactory extends Thread {

    private WaitingList waitingList;

    public CustomerFactory(WaitingList waitingList) {
        this.waitingList = waitingList;
    }


    // 피보나치 알고림즘 계산
    // 피보나치 60 70번으로 끝
    // 자료구조
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            while (true) {
                if (waitingList.getWaiting().size() <= 50) { // 동기화가 되는 queue
                    synchronized (waitingList.getWaiting()) {
                        waitingList.add();
                        System.out.println("대기 손님" + waitingList.getWaiting().size());

                    }
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
