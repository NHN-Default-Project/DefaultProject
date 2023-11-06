package com.nhnacademy.parkminsu.exam;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 생산자는 매장에 물건이 부족하지 않도록 채워둠
 * 물건은 1~10초 간격으로 채움
 * Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()
 * 사용
 */
public class Proceducer implements Runnable {
    private final Store store;
    private Thread thread;

    public Proceducer(Store store) {
        this.store = store;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
                store.buy();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();

        }

    }
}
