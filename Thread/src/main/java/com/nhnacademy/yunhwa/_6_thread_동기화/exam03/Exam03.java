package com.nhnacademy.yunhwa._6_thread_동기화.exam03;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCounter
                counter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter
                counter2 = new SharedCounter("counter2", 10000, sharedCount);

        counter1.start();
        counter2.start();

        System.out.println(counter1.getName() + ": started");
        System.out.println(counter2.getName() + ": started");

        counter1.join();
        counter2.join();

        System.out.println(counter1.getName() + ": terminated");
        System.out.println(counter2.getName() + ": terminated");

        System.out.println("sharedCount : " + SharedCount.getCount());
    }
}