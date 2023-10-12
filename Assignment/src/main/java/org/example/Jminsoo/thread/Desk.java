package org.example.Jminsoo.thread;

public class Desk implements Runnable {
    private int deskNumber;
    private final int delay;
    private final CustomerQueue waitingLine;
    static int count;


    public Desk(int delay, CustomerQueue customerQueue) {
        count++;
        get();
        this.delay = delay;
        waitingLine = customerQueue;
    }

    public void get() {
        this.deskNumber = count;
    }


    @Override
    public void run() {
        while (true) {
            Customer customer = waitingLine.poll();
            if (customer != null) {
                System.out.printf("%d번 창구에서 %d번 고객님이 처리되었습니다.%n", this.deskNumber, customer.getCustomerNumber());
            }


            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

    }


}
