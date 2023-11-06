package com.nhnacademy.jaehyeon.store;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Thread consumer = new Thread(new Consumer(store));
        Thread producer = new Thread(new Producer(store));

        consumer.start();
        producer.start();
        while (true) {
            try {
                Thread thread = new Thread(new Consumer(store));
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                thread.start();
            } catch (InterruptedException e) {

            }

        }

    }


}
