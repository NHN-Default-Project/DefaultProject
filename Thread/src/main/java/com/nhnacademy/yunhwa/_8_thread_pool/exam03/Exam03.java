package com.nhnacademy.yunhwa._8_thread_pool.exam03;

public class Exam03 {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");

        RunnableCounter thread1 = new RunnableCounter(group, "worker1", 100);
        RunnableCounter thread2 = new RunnableCounter(group, "worker2", 100);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.interrupt();

    }
}
