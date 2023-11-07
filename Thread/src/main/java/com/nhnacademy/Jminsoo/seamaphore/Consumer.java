package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private Mart mart;
    private String name;
    private Thread thread;


    public Consumer(String name, Mart mart) {
        this.name = name;
        this.mart = mart;
        this.thread = new Thread(this, name);
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            this.mart.enter();
            int randNum = ThreadLocalRandom.current().nextInt(1, 11);
            Thread.sleep(randNum * 1_000L);
        } catch (InterruptedException ignore) {
        }
        System.out.println(this.name + " 마트 탈출!");
    }
}
