package org.example.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Customer> waitingLine = new LinkedList<>();
        CustomerFactory customerFactory = new CustomerFactory(100, waitingLine);

        Desk desk1 = new Desk(2000, waitingLine);
        Desk desk2 = new Desk(2000, waitingLine);
        Desk desk3 = new Desk(1500, waitingLine);
        Desk desk4 = new Desk(1500, waitingLine);
        Desk desk5 = new Desk(1500, waitingLine);

        desk1.start();
        customerFactory.start();
        desk2.start();
        desk3.start();
        desk4.start();
        desk5.start();
    }
}