package com.nhnacademy.Jminsoo.exercise;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 소비자는 매장에 입장 후 물건을 구매할 수 있다.
 * <p>
 * 매장에는 입장 인원 제한이 있으므로, 인원 초과시 기다린다.
 * <p>
 * 매장에 입장하면 물건을 구매하고, 퇴장한다.
 * <p>
 * 1~10초 간격으로 구매한다.
 */
public class Consumer implements Runnable {

    private Store store;
    private String name;
    private Thread thread;


    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
        this.thread = new Thread(this, name);
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            this.store.enter();
            System.out.println(this.name + " 입장! 현재 손님 수 : " + this.store.getConsumerCount());
            int randNum = ThreadLocalRandom.current().nextInt(1, 11);
            Thread.sleep(randNum * 1_000L);
            this.store.sell();
            System.out.println(this.name + " 구매! 현재 물건 개수 : " + this.store.getGoodsCount());
            this.store.exit();
            System.out.println(
                    this.name + " 퇴장! 현재 손님 수 : " + this.store.getConsumerCount());

        } catch (InterruptedException ignore) {

        }
    }
}
