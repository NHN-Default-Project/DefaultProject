package org.example.parkminsu.Thread;

/**
 * Hello world!
 */
public class Main {// 우주선 한대로

    //
    public static void main(String[] args) {
        WaitingList waitingList = new WaitingList();
        CustomerFactory customerFactory = new CustomerFactory(waitingList);
        Thread thread = new Thread(new Desk(1, 1000, waitingList));
        Thread thread2 = new Thread(new Desk(2, 1500, waitingList));
        thread.start();
        thread2.start();
        customerFactory.start();

    }
}
