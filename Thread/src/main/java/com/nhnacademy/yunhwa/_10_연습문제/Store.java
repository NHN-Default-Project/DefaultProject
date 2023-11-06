package com.nhnacademy.yunhwa._10_연습문제;

/*
 * Exam- 01. 마트 내에 위치한 매장(Store) 을 정의하라.
 * 매장은 물건을 납품 받아서 판매한다.
 * 매장에는 최대 10개의 물건만 전시할 수 있다.
 * 매장은 최대 5명까지만 동시 입장 가능하다.
 * 매장에서 물건 구매는 동시에 1명만 가능하다.
 * 매장에서 물건 판매 후 빈 공간이 생기면 생산자에게 알려준다.
 * 매장에서 물건 납품은 동시에 1명만 가능하다. v
 * 매장에서 물건이 들어오면 소비자에게 알려준다.
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Store { // 마트 내에 위치한 매장(Store)

    private List<Product> products;
    private final int DISPLAYABLE_CAPACITY;
    private final int ENTERABLE_CAPACITY;
    private int enteredPersonCount;
    private int producedCount;
    private Queue<Thread> waitingList;

    public Store() {
        this.products = new ArrayList<>();
        this.DISPLAYABLE_CAPACITY = 10; // 매장에는 최대 10개의 물건만 전시 가능
        this.ENTERABLE_CAPACITY = 5; // 매장은 최대 5명까지만 동시 입장 가능
        this.enteredPersonCount = 0; // 매장에 들어온 손님 수
        this.producedCount = 0;
        this.waitingList = new LinkedList<>();
    }

    public int getEnterableCapacity() {
        return this.ENTERABLE_CAPACITY;
    }

    public int getEnteredPersonCount() {
        return this.enteredPersonCount;
    }

    public int getDisplayableCapacity() {
        return this.DISPLAYABLE_CAPACITY;
    }


    public synchronized void enter() { // 매장 입장
        try {
            System.out.println("enter 메서드에 들어왔습니다 : " + Thread.currentThread().getName());

            while (enteredPersonCount == ENTERABLE_CAPACITY) {
                System.out.println(Thread.currentThread().getName() + "이 웨이팅 줄에서 사람이 빠지기를 기다립니다 : " + enteredPersonCount + " 명");
                waitingList.add(Thread.currentThread());
                wait(); // 인원 초과시 나가기를 기다린다.
            }

            if (waitingList.contains(Thread.currentThread())) {
                waitingList.remove(Thread.currentThread());
            }

            enteredPersonCount++;
            System.out.println(Thread.currentThread().getName() + " 입장 했습니다.");
            System.out.println("현재 까지 " + enteredPersonCount + " 명 입장해 있습니다.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 이 중지됩니다...");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void exit() { // 매장 퇴장
        enteredPersonCount--;
        if (! waitingList.isEmpty()) {
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " 가 퇴장했습니다.");
    }

    public synchronized void buy() { // 납품 받기 : 매장에서 물건 납품은 동시에 1명만 가능
        try {
            while (products.size() == DISPLAYABLE_CAPACITY) {
                System.out.println("재고가 꽉 차서 " + Thread.currentThread().getName() + " 이 납품을 한동안 중지합니다 : " + products.size() + " 개");
                wait();
            }

            producedCount++;
            Product product = new Product("product" + producedCount, 10000 + producedCount);
            products.add(product);
            System.out.println("store 에서 " + Thread.currentThread().getName() + " 으로 부터 " + product.getName() + " 를 납품 받았습니다.");
            notifyAll(); // 매장에서 물건이 들어오면 소비자에게 알려주기

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "이 중지됩니다...");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void sell() { // 판매 :  매장에서 물건 판매도 동시에 1명만 가능
        try {
            while (products.isEmpty()) { // 비어 있다면
                System.out.println("재고가 없어서 납품 받을 때까지 " +  Thread.currentThread().getName() + " 가 기다립니다.");
                wait(); // 물건이 채워질 때까지 소비자가 Producer 을 기다리기
            }
            products.remove(0);
            System.out.println("store 에서 " + Thread.currentThread().getName() + " 에게 물건을 판매 완료하였습니다.");
            notifyAll();
            // 매장에서 물건 판매 후 빈 공간이 생기면 생산자에게 알려주기

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " 이 중지됩니다...");
            Thread.currentThread().interrupt();
        }
    }
}
