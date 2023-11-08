package com.nhnacademy.parkminsu.exam;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 소비자는 매장에 입장 후 물건을 구매
 * 매장에는 입장 인원 제한이 있으므로 인원 초과시 기다림
 * 매장에 입장하면 물거은 구매하고 퇴장
 * 1~10초 간격으로 구매
 */
public class Consumer implements Runnable {
    private Store store;
    private Thread thread;
    private AtomicBoolean isCheck;


    public Consumer(String name, Store store) {
        this.thread = new Thread(this, name);
        this.store = store;
        this.isCheck = new AtomicBoolean(false);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }


    @Override
    public void run() {
        store.enter();
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            store.sell();
            System.out.println(thread.getName() + "가 구매했습니다");
            isCheck.set(true);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }

        store.exit();
    }
}
