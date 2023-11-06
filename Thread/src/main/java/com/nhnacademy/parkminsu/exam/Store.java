package com.nhnacademy.parkminsu.exam;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 물건을 납품 받아서 판매
 * 10개의 물건만 전시
 * 매장은 최대 5명까지만 동시 입장
 * 물건 구매는 동시에 1명만 가능
 * 물건 판매 후 빈 공간에 생기면 생산자에게 알려줌
 * 물건 납품은 동시에 1명만 가능
 * 매장에서 물건이 들어오면 소비자에게 알려줌
 */
public class Store {
    AtomicInteger consumerCount;
    AtomicInteger thingsCount;
    Semaphore semaphore;

    public Store() {
        semaphore = new Semaphore(5);
        consumerCount = new AtomicInteger(0);
        thingsCount = new AtomicInteger(0);
    }

    /**
     * 손님이 들어오면 count가 1 증가
     */
    public void enter() {
        try {
            semaphore.acquire();
            consumerCount.addAndGet(1); // +1
            System.out.println();
            System.out.println("입장했습니다");
            System.out.println("사람 수: " + consumerCount.get());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 손님이 나가면 count를 1 감소
     */
    public void exit() {
        consumerCount.addAndGet(-1);
        System.out.println("손님이 나갔습니다");
        System.out.println();
        semaphore.release();
    }


    public synchronized void buy() { // 공급자한테 마트가 삼
        while (thingsCount.get() > 10) {
            try {
                System.out.println("물품이 많습니다");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        thingsCount.addAndGet(1);
        System.out.println();
        System.out.println("물품을 추가했습니다");
        System.out.println("현재 물품 수: " + thingsCount.get());
        System.out.println();

        notifyAll();
    }

    public synchronized void sell() { // 소비자 파는거
        while (thingsCount.get() <= 0) {// 물품이 없을 때
            try {
                System.out.println("물품이 없습니다");
                System.out.println();
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        notifyAll();
        thingsCount.addAndGet(-1); // -1
        System.out.println("상품을 판매했습니다");
        System.out.println("현재 남은 물품: " + thingsCount.get());
        System.out.println();


    }
}
