package com.nhnacademy.gaeun.assignment02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Store {
    private List<Consumer> people;

    private FoodStand foodStand;
    private Semaphore semaphore;

    public static final int PEOPLE_NUM_LIMIT = 5;

    public Store() {
        this.people = new ArrayList<>();
        this.foodStand = new FoodStand();
        this.semaphore = new Semaphore(PEOPLE_NUM_LIMIT);
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    public void enter(Consumer consumer) {
        if (consumer == null) {
            throw new IllegalArgumentException("consumer is null");
        }
        try {
            semaphore.acquire();
            people.add(consumer);
            System.out.println(consumer.getName() + " enter");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void exit(Consumer consumer) {
        if (people.contains(consumer)) {
            people.remove(consumer);
            System.out.println(consumer.getName() + " exit");
            semaphore.release();
        }
    }
}
