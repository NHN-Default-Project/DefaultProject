package com.nhnacademy.yunhwa._5_thread_멈추기.quiz01;

public class Quiz01 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        Thread thread = new Thread(runnableCounter);
        thread.start();
        Thread.sleep(3000);
        runnableCounter.stop();
    }
}