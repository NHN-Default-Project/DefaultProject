package com.nhnacademy.yunhwa._7_thread_상태.exam03;


public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter counter1 = new SharedCounter("counter1", 5, sharedCount);
        SharedCounter counter2 = new SharedCounter("counter2", 5, sharedCount);

        counter1.start();
        counter2.start();

        Thread.State state1 = counter1.getState();
        Thread.State state2 = counter2.getState();
        System.out.println("T1 : " + state1 + ", T2 : " + state2);

        while (counter1.isAlive() || counter2.isAlive()) {
            if ((counter1.getState() != state1) ||
                    (counter2.getState() != state2)) {
                state1 = counter1.getState();
                state2 = counter2.getState();
                System.out.println("T1 : " + state1 + ", T2 : " + state2);
            }
            Thread.sleep(10);
        }
    }
}
