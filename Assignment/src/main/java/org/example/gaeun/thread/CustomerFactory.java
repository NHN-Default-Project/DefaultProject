package org.example.gaeun.thread;

import java.util.Queue;
import java.util.Random;

public class CustomerFactory implements Runnable {
    Queue<Integer> queue;
    Thread thread;
    Random random = new Random();
    final int addCustomerTime = 600;

    public int getAddCustomerTime() {
        return addCustomerTime;
    }

    CustomerFactory(Queue<Integer> queue) {
        this.queue = queue;
        queue.add(count++);
        queue.add(count++);
        queue.add(count++);
    }

    int count = 0;

    @Override
    public void run() {
        while (true) {
            queue.add(count);
            System.out.printf("%d Customer is into waiting list\n", count++);
            System.out.printf("Customer count: %d\n", queue.size());
            try {
                Thread.sleep(addCustomerTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }
}
