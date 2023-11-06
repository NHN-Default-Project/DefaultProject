package com.nhnacademy.jaehyeon.practice;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        int storeNumber = 5;
        Mart mart = new Mart(storeNumber);

        for (int i = 0; i < storeNumber; i++) {
            Thread producerThread = new Thread(new Producer(mart, i));
            producerThread.start();
        }

        int count = 0;
        while (true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 1500));
            } catch (InterruptedException e) {

            }

            for (int i = 0; i < storeNumber; i++) {
                count++;
                Thread consumerThread = new Thread(new Consumer("Consumer " + count, mart, i));
                consumerThread.start();
            }


        }
    }
}
