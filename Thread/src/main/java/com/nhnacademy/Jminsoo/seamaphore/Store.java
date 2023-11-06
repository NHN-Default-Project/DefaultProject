package com.nhnacademy.Jminsoo.seamaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private final AtomicInteger maxGoodsCount;
    private AtomicInteger goodsCount;

    private final AtomicInteger maxConsumerCount;
    private AtomicInteger consumerCount;

    private String name;

    private final Semaphore enterSemaphore;
    private final Semaphore sellSemaphore;


    public Store(String name) {
        this.maxGoodsCount = new AtomicInteger(10);
        this.maxConsumerCount = new AtomicInteger(5);
        this.goodsCount = new AtomicInteger(0);
        this.consumerCount = new AtomicInteger(0);
        this.name = name;
        this.enterSemaphore = new Semaphore(5, true);
        this.sellSemaphore = new Semaphore(10, true);
    }

    public void enter() throws InterruptedException {
        this.enterSemaphore.acquire();
        this.consumerCount.addAndGet(1);
        System.out.println("[구매자] " + this.name + " 입장! 현재 손님 수 : " + this.getConsumerCount());
        this.enterSemaphore.release();

    }

    public void exit() {
        System.out.println(
                "[구매자] " + this.name + " 퇴장! 현재 손님 수 : " + this.getConsumerCount());
        this.consumerCount.addAndGet(-1);
    }

    public synchronized void buy() throws InterruptedException {
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
        this.sellSemaphore.acquire();

        while (true) {
            if (this.getGoodsCount() > 0) {
                this.sellSemaphore.release();
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
        return this.maxGoodsCount.intValue();
    }

    public synchronized int getMaxConsumerCount() {
        return this.maxConsumerCount.intValue();
    }


}

