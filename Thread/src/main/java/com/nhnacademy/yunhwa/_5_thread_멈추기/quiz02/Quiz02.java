package com.nhnacademy.yunhwa._5_thread_멈추기.quiz02;

public class Quiz02 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        Thread thread = new Thread(runnableCounter);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
