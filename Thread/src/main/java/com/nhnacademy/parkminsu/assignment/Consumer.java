package com.nhnacademy.parkminsu.assignment;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Consumer implements Runnable {
    private Mart mart;
    private Thread thread;
    private AtomicBoolean isCheck;

    private int buyItem;

    public Consumer(Mart mart, String name) {
        this.mart = mart;
        thread = new Thread(this, name);
        this.isCheck = new AtomicBoolean(false);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    public Thread getThread() {
        return thread;
    }


    @Override
    public void run() {
        getBuyItem();
        mart.enterStore(buyItem);
        while (!isCheck.get()) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
                mart.sellStoreItem(buyItem);
                System.out.println(thread.getName() + "가 구매했습니다");
                isCheck.set(true);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
        mart.exitStore(buyItem);
    }

    public void getBuyItem() {
        Random random = new Random();
        this.buyItem = random.nextInt(mart.getStore().length);
    }
}
