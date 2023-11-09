package com.nhnacademy.gaeun.assignment01;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.nhnacademy.gaeun.assignment01.product.*;

public class Producer implements Runnable {
    private Mart store;
    private List<Store> itemList;
    private Random random;

    public Producer(Mart store) {
        this.store = store;
        this.itemList = new ArrayList<>();
        this.random = new Random();
        initialSetting();
    }

    private void initialSetting() {
        itemList.add(new Vegetable("야채", 30));
        itemList.add(new ProcessedFood("조리 식품", 30));
        itemList.add(new DriedSeafood("건어물", 30));
        itemList.add(new CannedFoods("기호 식품", 30));
        itemList.add(new OtherItems("기타", 30));
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }

            randomDelivery();
        }
    }

    private void randomDelivery() {
        int deliveryNum = randomDeliveryNum();
        int amount = randomAmount();
        Store product = bringProduct(deliveryNum);
        this.store.addFoodStand(product, amount);

    }
    private int randomAmount() {
        return this.random.nextInt(10) + 1;
    }

    private int randomDeliveryNum() {
        return this.random.nextInt(itemList.size());
    }

    private Store bringProduct(int deliveryNum) {
        return this.itemList.get(deliveryNum);
    }
}