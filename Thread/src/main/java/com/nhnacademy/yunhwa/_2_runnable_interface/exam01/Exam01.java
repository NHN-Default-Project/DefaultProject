package com.nhnacademy.yunhwa._2_runnable_interface.exam01;

import com.nhnacademy.yunhwa._2_runnable_interface.quiz01.RunnableCounter;

public class Exam01 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        Thread thread = new Thread(runnableCounter);

        thread.start();
        thread.join();
        System.out.println("main 이 종료되었습니다.");
    }
}
