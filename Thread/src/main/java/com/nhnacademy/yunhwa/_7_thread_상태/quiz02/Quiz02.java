package com.nhnacademy.yunhwa._7_thread_상태.quiz02;

public class Quiz02 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter1 = new RunnableCounter("counter1", 10);
        RunnableCounter runnableCounter2 = new RunnableCounter("counter2", 10);
        RunnableCounter runnableCounter3 = new RunnableCounter("counter3", 10);

        runnableCounter1.start();
        runnableCounter2.start();
        runnableCounter3.start();

        runnableCounter2.getThread().interrupt();
        runnableCounter1.getThread().interrupt();

        runnableCounter2.join();
        runnableCounter3.join();
        runnableCounter1.join();

        System.out.println("All threads stopped");
    }
}
