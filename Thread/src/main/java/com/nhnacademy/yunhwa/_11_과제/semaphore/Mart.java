package com.nhnacademy.yunhwa._11_과제.semaphore;

public class Mart {
    Store[] stores;

    public Mart(int storeCount) { // storeCount == n
        this.stores = new Store[storeCount];

        for (int i = 0; i < storeCount; i++) {
            stores[i] = new Store("itemType" + i);
        }
    }

    public Store[] getStores() {
        return this.stores;
    }

}