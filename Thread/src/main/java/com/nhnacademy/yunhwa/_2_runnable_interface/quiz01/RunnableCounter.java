package com.nhnacademy.yunhwa._2_runnable_interface.quiz01;

public class RunnableCounter implements Runnable {

    private String name;
    private int count;
    private int maxCount;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
    }

    @Override
    public void run() {
        while (this.count < this.maxCount) {
            try {
                Thread.sleep(1000);
                this.count++;
                System.out.println(this.name + "'s count : " + this.count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
