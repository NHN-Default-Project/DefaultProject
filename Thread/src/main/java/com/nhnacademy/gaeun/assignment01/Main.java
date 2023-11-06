package org.example.thread.assignment01;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        Producer producer = new Producer(store);
        Thread producerThread = new Thread(producer);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        Runnable consumerTask = () -> {
            Consumer consumer = new Consumer("Consumer", store);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        };
        executorService.scheduleAtFixedRate(consumerTask, 0, 5, TimeUnit.SECONDS);
        producerThread.start();
    }
}
