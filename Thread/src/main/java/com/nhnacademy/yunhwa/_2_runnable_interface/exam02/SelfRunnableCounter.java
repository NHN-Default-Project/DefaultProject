package com.nhnacademy.yunhwa._2_runnable_interface.exam02;

public class SelfRunnableCounter implements Runnable {
    private int count;
    private int maxCount;
    private Thread thread; // thread 필드 추가

    public SelfRunnableCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name); // constructor 에서 thread instance 를 생성하고, 인자로 자신을 넘긴다.
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        while (this.count < this.maxCount) {
            try {
                this.count++;
                System.out.println(this.thread.getName() + "'s count : " + this.count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
