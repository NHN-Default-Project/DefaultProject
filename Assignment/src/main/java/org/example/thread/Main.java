package org.example.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Customer> watingLine = new LinkedList<>();
        CustomerFactory customerFactory = new CustomerFactory(500, watingLine);

        Desk desk1 = new Desk(2000, watingLine);
        Desk desk2 = new Desk(2000, watingLine);
        Desk desk3 = new Desk(1500, watingLine);

        desk1.start();
        customerFactory.start();
        desk2.start();
        desk3.start();
    }
}