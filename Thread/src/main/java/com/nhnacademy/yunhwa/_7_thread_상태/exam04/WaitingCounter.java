package com.nhnacademy.yunhwa._7_thread_상태.exam04;

public class WaitingCounter implements Runnable {
    private Thread thread;
    RunnableCounter counter;

    public WaitingCounter(RunnableCounter counter) {
        this.thread = new Thread(this);
        this.counter = counter;
    }

    public Thread getThread() {
        return this.thread;
    }

    public void start() {
        this.thread.start();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
    public void run() {
        try {
            counter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
