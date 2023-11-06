package com.nhnacademy.jaehyeon.store;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    Store store;
    String name;
    static int count = 0;

    public Consumer(Store store) {
        this.store = store;
        this.name = "Consumer" + count++;
    }




    @Override
    public void run() {
        try {
            store.enter(this);
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            store.sell();
            store.exit(this);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }

    @Override
    public String toString() {
        return name;
    }
}
