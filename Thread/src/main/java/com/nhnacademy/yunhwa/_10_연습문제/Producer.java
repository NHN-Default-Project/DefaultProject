package com.nhnacademy.yunhwa._10_연습문제;

/*
* Exam-02. 매장에 물건을 납품하는 생산자(Producer)을 정의하라.
* - 생산자는 매장에 물건이 부족하지 않도록 채워둔다.
* - 물건은 1~10초 간격으로 채운다.
* - Thread내에서 난수 생성을 위해서는 ThreadLocalRandom.current().nextInt()를 사용하면 된다.
* */

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable { // 매장에 물건을 납품하는 생산자(Producer)

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }


    @Override
    public void run() {
        while (! Thread.currentThread().isInterrupted()) {
            try {
                store.buy();
                System.out.println(Thread.currentThread().getName() + " 가 물건 납품을 완료했습니다.");
                int randomInterval = ThreadLocalRandom.current().nextInt(10) + 1;
                Thread.sleep(randomInterval * 1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 이 중지됩니다.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
