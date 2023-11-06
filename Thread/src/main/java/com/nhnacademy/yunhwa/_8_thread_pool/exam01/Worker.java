package com.nhnacademy.yunhwa._8_thread_pool.exam01;

public class Worker implements Runnable {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " finished");
    }
}
