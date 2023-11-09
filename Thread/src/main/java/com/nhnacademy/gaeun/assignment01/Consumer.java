package com.nhnacademy.gaeun.assignment01;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private Mart store;
    private String name;
    private Random random;

    private static int count = 0;

    public Consumer(String name, Mart store) {
        this.store = store;
        addCount();
        this.name = name + this.count;
    }

    public String getName() {
        return name;
    }
    public void addCount() {
        this.count = count + 1;
    }

    @Override
    public void run() {
        try {
            store.enter(this);
            sellRandomTime();
            store.exit(this);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void sellRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrupted");
        }
        pickFoods();
    }

    public void pickFoods() {
        int productNum = randomProductNum();
        int amount = randomAmount();
        Store product = store.getFoodStand().getFoodsList().get(productNum);
        store.getFoodStand().sell(product, amount);
    }

    private int randomAmount() {
        random = new Random();
        return random.nextInt(10) + 1;
    }

    private int randomProductNum() {
        random = new Random();
        return random.nextInt(store.getFoodStand().getFoodsList().size());
    }

}
