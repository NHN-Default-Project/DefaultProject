package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Mart mart = new Mart();
        Producer producer = new Producer(mart);
        producer.start();


        int index = 0;
        while (true) {
            index++;
            new Consumer("손님" + index, mart).start();
            int randNum = ThreadLocalRandom.current().nextInt(1, 6);
            Thread.sleep(randNum * 1_000L);
        }
    }
}
