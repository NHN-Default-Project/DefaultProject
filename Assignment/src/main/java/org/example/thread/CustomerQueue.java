package org.example.thread;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private final Queue<Customer> waitingLine;

    public CustomerQueue() {
        this.waitingLine = new LinkedList<>();
    }

    public synchronized void add(Customer customer) {
        System.out.printf("손님 입장. 현재 대기 줄 : %d %n", this.waitingLine.size());
        this.waitingLine.add(customer);
    }

    public synchronized Customer poll() {
        Customer customer = this.waitingLine.poll();
        if (customer == null) {
            throw new NullPointerException("null Check!");
        }
        return customer;
    }

}
