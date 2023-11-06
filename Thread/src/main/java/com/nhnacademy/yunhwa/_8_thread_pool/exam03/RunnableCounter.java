package com.nhnacademy.yunhwa._8_thread_pool.exam03;

public class RunnableCounter implements Runnable {
    private Thread thread;
    private int count = 0;
    private int maxCount;
    private long interval = 1000;


    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        this.maxCount = maxCount;
        this.thread = new Thread(group, this, name);
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
            System.out.println(this.thread.getName() + " end");
        } catch (InterruptedException ignore) {
            System.out.println(" stopped");
            this.thread.interrupt();
        }
    }
}
