package com.nhnacademy.jaehyeon.practice;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    private static final int MAX_PRODUCT_COUNT = 10;
    private static final int MAX_PERSON_COUNT = 5;

    AtomicInteger consumerCount;
    AtomicInteger productCount;

    Semaphore semaphore;

    public Store() {
        this.consumerCount = new AtomicInteger(0);
        this.productCount = new AtomicInteger(0);
        semaphore = new Semaphore(MAX_PERSON_COUNT);
    }

    public void enter() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            //TODO
        }

        this.consumerCount.addAndGet(1);
        System.out.println("손님 입장");

    }

    public void exit() {
        this.consumerCount.addAndGet(-1);
        System.out.println("손님 퇴장");

        semaphore.release();
    }

    public synchronized void buy() {
        while (productCount.get() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                //TODO
            }
        }
        System.out.println("손님이 물건을 샀습니다.");
        productCount.addAndGet(-1);
        notifyAll();
    }

    public synchronized void sell() {
        while (productCount.get() >= MAX_PRODUCT_COUNT) {
            try {
                wait();
            } catch (InterruptedException e) {
                //TODO
            }
        }
        System.out.println("물건을 납품했습니다.");
        productCount.addAndGet(1);
        notifyAll();
    }
}