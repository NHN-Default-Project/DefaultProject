package com.nhnacademy.yunhwa._7_thread_상태.exam02;



public class Exam02 {
    public static void main(String[] args) {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        runnableCounter.start();

        System.out.println(runnableCounter.getThread().getState());
    }
}
