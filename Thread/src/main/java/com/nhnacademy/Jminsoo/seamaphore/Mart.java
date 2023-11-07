package com.nhnacademy.Jminsoo.seamaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Mart {

    private List<Store> storeList;
    private final AtomicInteger martSize;


    public Mart() {
        this.martSize = new AtomicInteger(StoreType.values().length);
        this.storeList = new ArrayList<>();
        addStore();
    }

    private void addStore() {
        for (StoreType type : StoreType.values()) {
            this.storeList.add(new Store(type.name()));
        }
    }

    public void supply() {
        this.storeList.get(this.getRandNum(this.martSize.get())).buy();
    }


    public void enter() throws InterruptedException {
        Store tempStore = this.storeList.get(this.getRandNum(this.martSize.get()));
        tempStore.enter();
        tempStore.sell();
        tempStore.exit();
    }

    private int getRandNum(int bound) {
        return ThreadLocalRandom.current().nextInt(1, bound);
    }

    private enum StoreType {
        축산매장,
        수산매장,
        빵집,
        피자집,
        삼성스토어,
        애플스토어,
        당X치킨,
        일반과자집;


    }


}
