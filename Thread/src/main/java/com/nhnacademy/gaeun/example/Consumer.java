package org.example.thread.example;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Store store;
    String name;
    public static int count = 0;

    public Consumer(String name, Store store) {
        this.store = store;
        this.name = name + count++;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        store.enter(this);
        sellRandomTime();
        store.exit(this);
    }

    private void sellRandomTime() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread Interrupted");
        }
        store.sell();
    }
}
