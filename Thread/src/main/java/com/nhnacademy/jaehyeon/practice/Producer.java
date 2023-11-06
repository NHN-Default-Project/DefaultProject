package com.nhnacademy.jaehyeon.practice;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Mart mart;
    int item;

    public Producer(Mart mart, int item) {
        this.mart = mart;
        this.item = item;
    }

    @Override
    public void run() {
        while (true) {
            this.mart.getStore(item).sell();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
