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
                Customer customer = waitingList.poll();
                if (customer != null) {
                    System.out.printf("%d desk 운영중%n", this.deskName);
                    System.out.printf("처리한 손님 번호 %d ", customer.getCustomer());
                    System.out.println();
                    System.out.println("대기 손님 " + waitingList.getWaiting().size()); // queue.size
                }

                Thread.sleep(this.delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

