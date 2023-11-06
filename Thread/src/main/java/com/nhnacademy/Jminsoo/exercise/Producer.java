package com.nhnacademy.Jminsoo.exercise;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 생산자는 매장에 물건이 부족하지 않도록 채워둔다.
 * <p>
 * 물건은 1~10초 간격으로 채운다.
 * <p>
 * Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()를 사용하면 된다
 */
public class Producer implements Runnable {
    Thread thread;
    Store store;
    int randNum;

    public Producer(Store store) {
        this.thread = new Thread(this);
        this.store = store;
        this.randNum = 0;
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("물건 공급 중!");
                int randNum = ThreadLocalRandom.current().nextInt(1, 11);
                Thread.sleep(randNum * 1_000L);
                this.store.buy();
                System.out.println("물건 공급 완료! 현재 물건 개수 : " + this.store.getGoodsCount());
            }
        } catch (InterruptedException ignore) {
        }
    }
}
