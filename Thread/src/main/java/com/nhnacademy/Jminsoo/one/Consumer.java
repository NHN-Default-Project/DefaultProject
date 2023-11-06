package com.nhnacademy.Jminsoo.one;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    Mart mart;
    String name;
    Thread thread;
    int randNum;


    public Consumer(String name, Mart mart) {
        this.name = name;
        this.mart = mart;
        this.thread = new Thread(this, name);
        this.randNum = 0;
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            this.mart.enter();
            int randNum = ThreadLocalRandom.current().nextInt(1, 11);
            Thread.sleep(randNum * 1000);
        } catch (InterruptedException ignore) {
        }
        System.out.println(this.name + " 마트 탈출!");
    }
}
