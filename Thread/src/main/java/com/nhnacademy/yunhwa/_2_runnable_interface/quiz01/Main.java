package com.nhnacademy.yunhwa._2_runnable_interface.quiz01;

public class Main {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("runnableCounter", 10);
        Thread thread = new Thread(runnableCounter);
        thread.start();
    }
}
