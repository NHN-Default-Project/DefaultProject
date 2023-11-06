package com.nhnacademy.yunhwa._5_thread_멈추기.quiz02;

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
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("isinterrupted 가 참입니다. while 문 빠져나옵니다.");
                    break;
                }
                this.count++;
                System.out.println(this.name + "'s count : " + this.count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupt 메서드 호출하여 setting 하였습니다.");
            }
        }
    }
}
