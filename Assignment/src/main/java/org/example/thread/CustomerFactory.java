package org.example.thread;

import java.util.Queue;

public class CustomerFactory extends Thread {
    private int customerNumber;
    private final int delay;
    private final Queue<Customer> queue;

    public CustomerFactory(int delay, Queue<Customer> queue) {
        this.queue = queue;
        this.customerNumber = 0;
        this.delay = delay;
    }

    public void addCustomerNumber() {
        this.customerNumber++;
    }


    public Customer makeCustomer() {
        addCustomerNumber();
        return new Customer(this.customerNumber);
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.queue) {
                    queue.add(makeCustomer());
                    System.out.printf("현재 대기 줄 : %d, %n", this.queue.size());
                }
                Thread.sleep(delay + (int) (Math.random() * 100));

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
