package com.nhnacademy.yunhwa._11_과제;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int STORE_COUNT = 3;
        final int CONSUMER_COUNT = 30;

        Mart mart = new Mart(STORE_COUNT); // 매장 3개인 마트

        Store[] stores = mart.getStores(); // 마트 내의 각 품목별 매장

        Thread producer = new Thread(new Producer(mart, STORE_COUNT), "producer"); // 생산자 1명
        Thread[] consumers = new Thread[CONSUMER_COUNT]; // 소비자 30명

        for (int i = 0; i < consumers.length; i++) {
            int randomIndex =  ThreadLocalRandom.current().nextInt(consumers.length);
            consumers[i] = new Thread(new Consumer("consumer" + i, stores[randomIndex % STORE_COUNT]), "consumer" + i);
        }

        producer.start();

        for (int i = 0; i < consumers.length; i++) {
            consumers[i].start();
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException ignore) {
            }
        }

        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException ignore) {
        }

//        producer.interrupt();
//        System.out.println(producer.getName() + " 이 interrupt 되었습니다.\n");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ignore) {
//        }

//        for(int i = 0; i < consumers.length; i++) {
//            consumers[i].interrupt();
//            System.out.println(consumers[i].getName() + " 이 interrupt 되었습니다.\n");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignore) {
//            }
//        }
    }
}
