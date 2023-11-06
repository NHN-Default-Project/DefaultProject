package com.nhnacademy.gaeun.assignment01;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private List<Consumer> people;

    private FoodStand foodStand;

    public static final int PEOPLE_NUM_LIMIT = 5;

    public Store() {
        people = new ArrayList<>();
        foodStand = new FoodStand();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    public synchronized boolean isAbleEnter() {
        return people.size() < PEOPLE_NUM_LIMIT;
    }

    public synchronized void enter(Consumer consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("consumer is null");
        }
        while (!isAbleEnter()) {
            try {
                System.out.println("대기중입니다 ...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        people.add(consumer);
        System.out.println(consumer.getName() + " enter");
    }

    public synchronized void exit(Consumer consumer) {
        if (people.contains(consumer)) {
            people.remove(consumer);
            System.out.println(consumer.getName() + " exit");
            notifyAll();
        }
    }
}
