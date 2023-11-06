package com.nhnacademy.yunhwa._11_과제;

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
    private String itemTypeName; // 해당 매장에서 취급하는 품목 이름
    private List<Product> products;
    private final int DISPLAYABLE_CAPACITY;
    private final int ENTERABLE_CAPACITY;
    private int enteredPersonCount;
    private int producedCount;
    private Queue<String> waitingList;

    public Store(String itemTypeName) {
        this.itemTypeName = itemTypeName; // 품목 이름 파라미터 받아서 할당
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


    public synchronized void enter() { // 소비자 매장 입장
        try {
            System.out.println("[" + itemTypeName + "] store 으로 <" + Thread.currentThread().getName() + "> 님이 입장 예정입니다.");

            while (enteredPersonCount == ENTERABLE_CAPACITY) {
                if (! waitingList.contains(Thread.currentThread().getName())) {
                    waitingList.add(Thread.currentThread().getName());
                    System.out.println("[" + itemTypeName + "] store 으로 들어가기 위해 <<" + Thread.currentThread().getName() + ">> 님이 웨이팅 줄에서 사람이 빠지기를 기다립니다 / 대기줄 명수: " + this.waitingList.size() +  " / 현재 매장에 들어가있는 고객 수 : " + enteredPersonCount + " 명");
                }
                wait(); // 인원 초과시 나가기를 기다린다.
            }

            if (waitingList.contains(Thread.currentThread().getName())) {

                System.out.println("[" + itemTypeName + "] store 의 대기줄에서 기다리던 고객이 들어갈 차례! 대기줄에서 빠지기 전 대기줄 명수 : " + waitingList.size());
                System.out.println("(귓속말) <<" + Thread.currentThread().getName() + ">> 님은 여태 [" + itemTypeName + "] store 의 대기줄에 있다 들어갈 고객입니다. 신경써서 판매 부탁드립니다.");
                waitingList.remove(Thread.currentThread().getName());
                System.out.println("[" + itemTypeName + "] store 의 대기줄에서 기다리던 고객이 들어갈 차례! 대기줄에서 빠진 후 대기줄 명수 : " + waitingList.size());
            }

            enteredPersonCount++;
            System.out.println("-> " + "[" + itemTypeName + "] store 으로 <" + Thread.currentThread().getName() + "> 님 입장 했습니다.");
            System.out.println("====   [" + itemTypeName + "] store" + " 에 현재 까지 " + enteredPersonCount + " 명 입장해 있습니다.   ====");
        } catch (InterruptedException e) {
            System.out.println("[" + itemTypeName + "] store 에서 <" + Thread.currentThread().getName() + "> 님이 중지됩니다... ---------------------------------- Store enter() 메서드");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void exit() { // 매장 퇴장
        enteredPersonCount--;
        System.out.println("<- " + "[" + itemTypeName + "] store 에서 <" + Thread.currentThread().getName() + "> 님이 퇴장했습니다.");
        if (! waitingList.isEmpty()) {
            notifyAll();
        }
    }

    public synchronized void buy() { // 납품 받기 : 매장에서 물건 납품은 동시에 1명만 가능  - 생산자
        try {
            boolean isStillWait = false;
            while (products.size() == DISPLAYABLE_CAPACITY) {
                if (! isStillWait) {
                    isStillWait = true;
                    System.out.println("[" + itemTypeName + "] store 의 재고가 꽉 차서 (" + Thread.currentThread().getName() + ") 이 납품을 한동안 중지합니다. / 현재 [" + itemTypeName + "] store 재고량 : " + products.size() + " 개");
                }
                wait();
            }

            producedCount++;
            Product product = new Product("product" + producedCount, 10000 + producedCount);
            products.add(product);

            System.out.println("[" + itemTypeName + "] store 에서 (" + Thread.currentThread().getName() + ") 으로 부터 |" + product.getName() + "| 를 납품 받았습니다. 현재 [" + itemTypeName + "] store 재고량 : " + products.size() + " 개");
            notifyAll(); // 매장에서 물건이 들어오면 소비자에게 알려주기

        } catch (InterruptedException e) {
            System.out.println("[" + itemTypeName + "] store 에서 (" + Thread.currentThread().getName() + ") 이 중지됩니다... ---------------------------------- Store buy() 메서드");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void sell() { // 판매 :  매장에서 물건 판매도 동시에 1명만 가능
        try {
            while (products.isEmpty()) { // 비어 있다면
                System.out.println("[" + itemTypeName + "] store 에 " + "재고가 없어서 납품 받을 때까지 <" +  Thread.currentThread().getName() + "> 가 기다립니다.");
                wait(); // 물건이 채워질 때까지 소비자가 Producer 을 기다리기
            }
            products.remove(0);
            System.out.println("[" + itemTypeName + "] store 에서 <" + Thread.currentThread().getName() + "> 님에게 물건을 판매 완료하였습니다.");
            notifyAll();
            // 매장에서 물건 판매 후 빈 공간이 생기면 생산자에게 알려주기

        } catch (InterruptedException e) {
            System.out.println("[" + itemTypeName + "] store 에서 <" + Thread.currentThread().getName() + "> 이 중지됩니다... ---------------------------------- Store sell() 메서드");
            Thread.currentThread().interrupt();
        }
    }
}
