package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private final AtomicInteger MAX_GOODS_COUNTS = new AtomicInteger(10);
    private final AtomicInteger MAX_CONSUMER_COUNTS = new AtomicInteger(5);
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
        this.consumerSemaphore.acquire();
        this.consumerCount.addAndGet(1);
        System.out.println("[구매자] " + this.name + " 입장! 현재 손님 수 : " + this.getConsumerCount());

    }

    public void exit() {
        System.out.println(
                "[구매자] " + this.name + " 퇴장! 현재 손님 수 : " + this.getConsumerCount());
        this.consumerCount.addAndGet(-1);
        this.consumerSemaphore.release();
    }


    public synchronized void buy() {
        System.out.println("[공급자] " + this.name + " 물건 공급 중!");
        if (this.getGoodsCount() >= this.getMaxGoodsCount()) {
            System.out.println("[공급자] " + this.name + " 창고가 꽉 찼다! 대기!");
        } else {
            this.goodsCount.addAndGet(1);
            System.out.println("[공급자] " + this.name + " 물건 공급 완료! 현재 물건 개수 : " + this.getGoodsCount());
            notifyAll();
        }
    }

    public synchronized void sell() throws InterruptedException {

        while (true) {
            if (this.getGoodsCount() > 0) {
                this.goodsCount.addAndGet(-1);
                System.out.println("[구매자] " + this.name + " 물건 판매! 현재 물건 개수 : " + this.getGoodsCount());
                notifyAll();
                break;
            } else {
                wait();
            }
        }
    }

    public synchronized int getGoodsCount() {
        return this.goodsCount.intValue();
    }

    public synchronized int getConsumerCount() {
        return this.consumerCount.intValue();
    }

    public synchronized int getMaxGoodsCount() {
        return this.MAX_GOODS_COUNTS.intValue();
    }

    public synchronized int getMaxConsumerCount() {
        return this.MAX_CONSUMER_COUNTS.intValue();
    }


}

