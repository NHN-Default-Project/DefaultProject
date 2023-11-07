package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private Thread thread;
    private Mart mart;

    private AtomicInteger randNum;


    public Producer(Mart mart) {
        this.thread = new Thread(this);
        this.mart = mart;
        this.randNum = new AtomicInteger();
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                this.randNum.set(ThreadLocalRandom.current().nextInt(1, 6));
                Thread.sleep(randNum.get() * 1_000L);
                this.mart.supply();
            }
        } catch (InterruptedException ignore) {
        }
    }
}
