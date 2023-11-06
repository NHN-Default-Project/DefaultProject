package com.nhnacademy.parkminsu.assignment;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 마트에서는 N개의 품목 매장
 * 생산자가 품목을 납품하기 전까지 어떤 품목인지는 알 수 없음
 * 소비자는 품목별로 매장을 이용할 수 있음
 */
public class Store {

    private AtomicInteger items;
    private AtomicInteger currentPeople;
    private final String name;
    private final int storeMaxPeople = 5;

    private final Semaphore semaphore;

    public Store(String name) {
        this.name = name;
        this.items = new AtomicInteger(0);
        this.currentPeople = new AtomicInteger(0);
        this.semaphore = new Semaphore(storeMaxPeople);
    }

    /**
     * 매장에 사람이 들어오면 count + 1해줌
     */
    public void enter() {
        try {
            this.semaphore.acquire();// +1 5명 자동 lock
            System.out.println("\n" + this.name + " 매장에 손님이 들어왔습니다");
            this.currentPeople.addAndGet(1); // 손님이 들어오면 +1
            System.out.println(this.name + " 매장 손님의 수: " + currentPeople + "\n");

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public void exit() {
        semaphore.release();// -1
        currentPeople.addAndGet(-1);
        System.out.println();
        System.out.println(this.name + "매장에 손님이 나갔습니다");
        System.out.println();

    }

    public synchronized void buy() { // 공급자한테 마트가 삼
        while (items.get() > 10) {
            try {
                System.out.println();
                System.out.println(this.name + "매장에 물품이 많습니다");
                System.out.println();
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        if (items.get() <= 0) {
            notifyAll();
        }
        items.addAndGet(1);
        System.out.println();
        System.out.println(this.name + "매장에 물품을 추가했습니다");
        System.out.println(this.name + "매장 현재 물품 수: " + items.get());
        System.out.println();


    }

    public synchronized void sell() { // 소비자 파는거
        while (items.get() <= 0) {// 물품이 없을 때
            try {
                System.out.println();
                System.out.println(this.name + "매장에 물품이 없습니다");
                System.out.println();
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        notifyAll();
        items.addAndGet(-1); // -1
        System.out.println(this.name + "매장에 현재 남은 물품: " + items.get());
        System.out.println();
    }


}
