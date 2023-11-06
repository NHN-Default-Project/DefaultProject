package com.nhnacademy.yunhwa._9_demon_thread;


public class Exam01 {
    public static void main(String[] args) {
        RunnableCounter counter1 = new RunnableCounter("counter1", 100);
        RunnableCounter counter2 = new RunnableCounter("counter2", 100);

        counter2.setDemon(true);

        counter1.start();
        counter2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counter1.stop();

        System.out.println("Main Thread terminated");
    }
}
