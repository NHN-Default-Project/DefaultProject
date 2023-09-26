package org.example.Jminsoo.thread;

public class CustomerFactory implements Runnable {
    private int customerNumber;
    private final int delay;
    private final CustomerQueue queue;

    public CustomerFactory(int delay, CustomerQueue queue) {
        this.queue = queue;
        this.customerNumber = 0;
        this.delay = delay;
    }

    public void addCustomerNumber() {
        if (this.customerNumber >= 1000) {
            System.out.println("1000명이 넘어 번호를 0으로 초기화합니다.");
            this.customerNumber = 0;
        } else {
            this.customerNumber++;
        }
    }


    public Customer makeCustomer() {
        addCustomerNumber();
        return new Customer(this.customerNumber);
    }

    @Override
    public void run() {
        while (true) {
            queue.add(makeCustomer());
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
