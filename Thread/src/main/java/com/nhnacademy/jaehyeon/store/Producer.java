package com.nhnacademy.jaehyeon.store;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    int count;
    Store store;

    public Producer(Store store) {
        this.store = store;
        count = 0;
    }

    public Product makeProduct() {
        count++;
        return new Product(count);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
                store.buy(makeProduct());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}