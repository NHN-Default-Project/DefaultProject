package com.nhnacademy.jaehyeon.practice;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    Mart mart;
    String name;
    int item;

    public Consumer(String name, Mart mart, int item) {
        this.name = name;
        this.mart = mart;
        this.item = item;
    }

    @Override
    public void run() {
        this.mart.getStore(this.item).enter();
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            this.mart.getStore(this.item).buy();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.mart.getStore(this.item).exit();
    }
}
