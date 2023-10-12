package org.example.Jminsoo.thread;

public class Main {
    //Runnable 사용
    //자료형 추상화
    //Queue

    public static void main(String[] args) {
        CustomerQueue waitingLine = new CustomerQueue();
        Thread customerFactory = new Thread(new CustomerFactory(500, waitingLine));
        Thread desk1 = new Thread(new Desk(1500, waitingLine));
        Thread desk2 = new Thread(new Desk(3000, waitingLine));

        Thread customer = new Thread(customerFactory);


        customer.start();
        desk1.start();
        desk2.start();
    }
}