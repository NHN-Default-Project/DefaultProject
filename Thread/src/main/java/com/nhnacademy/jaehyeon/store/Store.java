package com.nhnacademy.jaehyeon.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    volatile List<Product> productList;
    List<Consumer> consumerList;

    private static final int MAX_PRODUCT_COUNT = 10;
    private static final int MAX_CONSUMER_COUNT = 5;

    public Store() {
        this.productList = new ArrayList<>();
        this.consumerList = new ArrayList<>();
    }

    public synchronized void enter(Consumer consumer) {
        while (this.consumerList.size() >= MAX_CONSUMER_COUNT) {

                System.out.println("꽉찼습니다 기다려주세요");

        }
        this.consumerList.add(consumer);
        System.out.println(consumer + "이 들어왔습니다.");
    }

    public synchronized void exit(Consumer consumer) {
        System.out.println(consumer + "이 나갑니다");
        this.consumerList.remove(consumer);
        notifyAll();

    }

    public synchronized void buy(Product product) {
        while (this.productList.size() >= MAX_PRODUCT_COUNT) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("물건 샀습니다.");
        this.productList.add(product);
        notifyAll();
    }

    public synchronized void sell() {
        while (this.productList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("물건 팔았습니다");
        this.consumerList.remove(0);
        notifyAll();

    }
}