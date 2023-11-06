package com.nhnacademy.yunhwa._7_thread_상태.exam04;

public class RunnableCounter implements Runnable {
    private Thread thread;
    private int count = 0;
    private int maxCount;
    private long interval = 1000;


    public RunnableCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        this.thread = new Thread(this, name);
    }

    public int getCount() {
        return this.count;
    }

    public void increment() {
        this.count++;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    public Thread getThread() {
        return this.thread;
    }

    public void join() throws InterruptedException {
        this.thread.join();
    }

    @Override
    public void run() {
        try {
            while (count < maxCount) {
                increment();
                System.out.println(thread.getName() + " : " + getCount());
                Thread.sleep(interval);
            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
    }
}
