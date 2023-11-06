package com.nhnacademy.yunhwa._5_thread_멈추기.quiz01;

public class RunnableCounter implements Runnable {

    private String name;
    private int count;
    private int maxCount;
    private boolean runningFlag;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
        this.runningFlag = false;
    }

    public void stop() {
        this.runningFlag = false;
    }

    @Override
    public void run() {
        this.runningFlag = true;

        while (this.count < this.maxCount) {
            if (this.runningFlag) {
                try {
                    this.count++;
                    System.out.println(this.name + "'s count : " + this.count);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                break;
            }
        }
    }
}
