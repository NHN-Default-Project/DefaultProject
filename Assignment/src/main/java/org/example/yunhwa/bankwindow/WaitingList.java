package org.example.yunhwa.bankwindow;

import java.util.LinkedList;
import java.util.Queue;

public class WaitingList {
    private Queue<Customer> list;

    public WaitingList() {
        this.list = new LinkedList<>();
    }

    public Queue<Customer> getList() {
        return this.list;
    }

    public void add(Customer customer) {
        this.list.add(customer);
    }

    public int getSize() {
        return this.list.size();
    }


}