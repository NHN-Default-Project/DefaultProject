package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private final AtomicInteger MAX_GOODS_COUNTS = new AtomicInteger(10);
    private AtomicInteger goodsCount;

    private AtomicInteger consumerCount;

    private String name;

    private final Semaphore consumerSemaphore;


    public Store(String name) {
        this.goodsCount = new AtomicInteger(0);
        this.consumerCount = new AtomicInteger(0);
        this.name = name;
        this.consumerSemaphore = new Semaphore(5, true);
    }

    public void enter() throws InterruptedException {
        System.out.println(
                "[구매자] " + this.name + " 입장! 현재 손님 수 : " + this.consumerCount.get());
        this.consumerSemaphore.acquire();
        this.consumerCount.addAndGet(1);

    }

    public void exit() {
        System.out.println(
                "[구매자] " + this.name + " 퇴장! 현재 손님 수 : " + this.consumerCount.get());
        this.consumerCount.addAndGet(-1);
        this.consumerSemaphore.release();
    }


    public synchronized void buy() {
        System.out.println("[공급자] " + this.name + " 물건 공급 중!");
        if (this.goodsCount.get() >= this.MAX_GOODS_COUNTS.get()) {
            System.out.println("[공급자] " + this.name + " 창고가 꽉 찼다! 대기!");
        } else {
            this.goodsCount.addAndGet(1);
            System.out.println("[공급자] " + this.name + " 물건 공급 완료! 현재 물건 개수 : " + this.goodsCount.get());
            notifyAll();
        }
    }

    public synchronized void sell() throws InterruptedException {
        while (this.goodsCount.get() <= 0) {
            wait();
        }
        this.goodsCount.addAndGet(-1);
        System.out.println("[구매자] " + this.name + " 물건 판매! 현재 물건 개수 : " + this.goodsCount.get());
        notifyAll();
    }
}

