package com.nhnacademy.yunhwa._9_demon_thread;

public class RunnableCounter implements Runnable {

    private String name;
    private int count;
    private int maxCount;
    private Thread thread;

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
        this.thread = new Thread(this, name);
    }

    public Thread getThread() {
        return this.thread;
    }


    public void start() {
        this.thread.start();
    }

    public void setDemon(boolean flag) {
        this.thread.setDaemon(flag);
    }

    public void stop() {
        this.thread.interrupt();
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
