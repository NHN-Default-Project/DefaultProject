package com.nhnacademy.yunhwa._6_thread_동기화.exam03;

public class SharedCounter extends Thread {
    private final SharedCount sharedCount;
    private int count;
    private final int maxCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        super.setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        this.count = 0;
    }

    @Override
    public void run() {
        while(count < maxCount) {
            count++;
            sharedCount.increment();
        }
    }
}
