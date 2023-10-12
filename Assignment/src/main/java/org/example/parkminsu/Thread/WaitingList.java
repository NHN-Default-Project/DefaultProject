package org.example.parkminsu.Thread;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingList {
    private Queue<Customer> waiting;
    private int customerNum;

    public WaitingList() {
        this.waiting = new LinkedList<>();
        this.customerNum = 0;
    }

    public void addCustomerNum() {
        this.customerNum++;
    }

    public Queue<Customer> getWaiting() {
        return waiting;
    }

    public void add() {
        addCustomerNum();
        this.waiting.add(new Customer(this.customerNum));
    }

    public Customer poll() {
        return waiting.poll();
    }
}

