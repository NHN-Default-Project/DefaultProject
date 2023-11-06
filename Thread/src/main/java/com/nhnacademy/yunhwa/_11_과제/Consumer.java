package com.nhnacademy.yunhwa._11_과제;


/*
 * Exam-03. 매장에 물건을 구매하는 소비자(Consumer)을 정의하라.
 * - 소비자는 매장에 입장 후 물건을 구매할 수 있다.
 * - 매장에는 입장 인원 제한이 있으므로, 인원 초과시 기다린다.
 * - 매장에 입장하면 물건을 구매하고, 퇴장한다.
 * - 1~10초 간격으로 구매한다.
 * */

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    String name;
    Store store; // 특정 품목의 매장

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
        store.enter(); // 매장에 입장

        // 물건을 1~10초 간격으로 구매 (store 입장에서는 판매)
        int randomInterval = ThreadLocalRandom.current().nextInt(10) + 1;
        try {
            Thread.sleep(randomInterval * 1000);
        } catch (InterruptedException e) {
            System.out.println("Consumer run() 에서 " + Thread.currentThread().getName() +
                    " 이 중지됩니다. ----------------------------------\n");
            Thread.currentThread().interrupt();
        }
        store.sell();

        store.exit(); // 퇴장
    }
}
