package org.example.thread.assignment01;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private Store store;
    private String name;
    private Random random;
    public static int count = 0;

    public Consumer(String name, Store store) {
        this.store = store;
        this.name = name + ++count;
    }

    public String getName() {
        return name;
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
        Product product = store.getFoodStand().getFoodsList().get(productNum);
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
