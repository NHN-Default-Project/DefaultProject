package org.example.parkminsu.Thread;

public class Desk implements Runnable {
    CustomerFactory customerFactory;
    private WaitingList waitingList;
    private int deskName;
    private int delay;

    public Desk(int deskName, int delay, WaitingList waitingList) {
        customerFactory = new CustomerFactory(waitingList);
        this.deskName = deskName;
        this.delay = delay;
        this.waitingList = waitingList;

    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!waitingList.getWaiting().isEmpty()) { /// 데이터가 없으면
                    System.out.printf("%d desk 운영중%n", this.deskName);
                    System.out.printf("처리한 손님 번호 %d ", this.waitingList.getWaiting().poll().getCustomer());
                    System.out.println();

                } else {
                    System.out.println("현재 손님 x");
                }
                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

