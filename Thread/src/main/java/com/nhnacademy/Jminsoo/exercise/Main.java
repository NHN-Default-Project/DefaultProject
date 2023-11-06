package com.nhnacademy.Jminsoo.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Producer producer = new Producer(store);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        producer.start();
        int index = 0;
        while (true) {
            if (store.getConsumerCount() < store.getMaxConsumerCount()) {
                index++;
                executorService.submit(new Consumer("손님" + index, store));
                int randNum = ThreadLocalRandom.current().nextInt(1, 11);
                Thread.sleep(randNum * 1_000L);
            }
        }

    }
}

