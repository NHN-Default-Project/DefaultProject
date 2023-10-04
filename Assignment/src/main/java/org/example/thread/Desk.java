package org.example.thread;

import java.util.Queue;

public class Desk extends Thread {
    private int deskNumber;
    private final int delay;
    private static Queue<Customer> queue;
    static int count;


    public Desk(int delay, Queue<Customer> queue) {
        count++;
        get();
        this.delay = delay;
        this.queue = queue;

    }

    public void get() {
        this.deskNumber = count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (queue) {
                    if (!queue.isEmpty()) {
                        System.out.printf("%d번 창구에서 %d번 고객님이 처리되었습니다. %n", this.deskNumber,
                                this.queue.poll().getCustomerNumber());
                    }
                }
                Thread.sleep(delay);

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
    }


}
