package com.nhnacademy.gaeun.example;

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList;
    List<Consumer> people;

    public static final int MAX_NUM = 10;

    public static final int PEOPLE_NUM_LIMIT = 5;

    public synchronized boolean isAbleBuy() {
        return productList.size() < MAX_NUM;
    }

    public synchronized boolean isAbleSell() {
        return !productList.isEmpty();
    }

    public synchronized boolean isAbleEnter() {
        return people.size() < PEOPLE_NUM_LIMIT;
    }


    public Store() {
        productList = new ArrayList<>();
        people = new ArrayList<>();
    }

    public synchronized void enter(Consumer consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("consumer is null");
        }
        while (!isAbleEnter()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        people.add(consumer);
        System.out.println(consumer.getName() + " enter");
        notifyAll();
    }

    public synchronized void exit(Consumer consumer) {
        if (people.contains(consumer)) {
            people.remove(consumer);
            System.out.println(consumer.getName() + " exit");
            notifyAll();
        }
    }

    public synchronized void buy() { //상품 진열
        while (!isAbleBuy()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Product product = new Product();
        productList.add(product);
        System.out.println("product add");
        System.out.println(productList.size());
    }

    public synchronized void sell() { //상품 판매
        if (isAbleSell()) {
            productList.remove(0);
            System.out.println("product get");
            System.out.println(productList.size());
            notifyAll();
        }
    }
}
