package com.nhnacademy.Jminsoo.exercise;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 매장은 물건을 납품 받아서 판매한다.
 * <p>
 * 매장에는 최대 10개의 물건만 전시할 수 있다. : 최대 물건 개수
 * <p>
 * 매장은 최대 5명까지만 동시 입장 가능하다. : Consumer의 최대 접근 개수
 * <p>
 * 매장에서 물건 구매는 동시에 1명만 가능하다. : Syncronized.
 * <p>
 * 매장에서 물건 판매 후 빈 공간에 생기면 생산자에게 알려 준다. : 생산자는 물건이 비면 깨어난다
 * <p>
 * 매장에서 물건 납품은 동시에 1명만 가능하다. : 납품 Syncronized
 * <p>
 * 매장에서 물건이 들어오면 소비자에게 알려 준다. : 빈 물건이 들어오면 깬다.
 */
public class Store {
    private final AtomicInteger maxGoodsCount;
    private AtomicInteger goodsCount;

    private final AtomicInteger maxConsumerCount;
    private AtomicInteger consumerCount;


    public Store() {
        this.maxGoodsCount = new AtomicInteger(10);
        this.maxConsumerCount = new AtomicInteger(5);
        this.goodsCount = new AtomicInteger(0);
        this.consumerCount = new AtomicInteger(0);

    }

    public void enter() throws InterruptedException {

        if (this.consumerCount.get() >= this.maxConsumerCount.get()) {
            wait();
        }
        this.consumerCount.addAndGet(1);
    }

    public void exit() {
        this.consumerCount.addAndGet(-1);
    }

    public synchronized void buy() throws InterruptedException {
        while (true) {
            if (this.goodsCount.get() >= this.maxGoodsCount.get()) {
                System.out.println("창고가 꽉 찼다! 대기!");
                wait();
            } else {
                this.goodsCount.addAndGet(1);
                notifyAll();
                break;
            }
        }

    }

    public synchronized void sell() throws InterruptedException {
        while (true) {
            if (this.goodsCount.get() <= 0) {
                wait();
            } else {
                this.goodsCount.addAndGet(-1);
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

