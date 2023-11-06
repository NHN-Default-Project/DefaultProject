package com.nhnacademy.Jminsoo.one;

import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private final AtomicInteger maxGoodsCount;
    private AtomicInteger goodsCount;

    private final AtomicInteger maxConsumerCount;
    private AtomicInteger consumerCount;

    private String name;


    public Store(String name) {
        this.maxGoodsCount = new AtomicInteger(10);
        this.maxConsumerCount = new AtomicInteger(5);
        this.goodsCount = new AtomicInteger(0);
        this.consumerCount = new AtomicInteger(0);
        this.name = name;
    }

    public void enter() {
        while (true) {
            try {
                if (this.getConsumerCount() < this.getMaxConsumerCount()) {
                    this.consumerCount.addAndGet(1);
                    System.out.println("[구매자] " + this.name + " 입장! 현재 손님 수 : " + this.getConsumerCount());
                    break;
                } else {
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void exit() {
        System.out.println(
                "[구매자] " + this.name + " 퇴장! 현재 손님 수 : " + this.getConsumerCount());
        this.consumerCount.addAndGet(-1);
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
            if (this.goodsCount.get() <= 0) {
                System.out.println("[구매자] " + this.name + " 구매자 물건 없어서 대기!");
                wait();
            } else {
                this.goodsCount.addAndGet(-1);
                System.out.println("[구매자] " + this.name + " 물건 판매! 현재 물건 개수 : " + this.getGoodsCount());
                notifyAll();
                break;
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

