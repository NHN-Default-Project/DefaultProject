package com.nhnacademy.yunhwa._7_thread_상태.exam03;

public class SharedCounter extends Thread {
    private final SharedCount sharedCount;
    private int count;
    private final int maxCount;
    private long interval = 1000;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        super.setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        this.count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                count++;
                sharedCount.increment();
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
