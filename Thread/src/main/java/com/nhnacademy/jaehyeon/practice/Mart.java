package com.nhnacademy.jaehyeon.practice;

import java.util.ArrayList;
import java.util.List;

public class Mart {
    List<Store> storeList;
    int storeNumber;

    public Mart(int storeNumber) {
        this.storeList = new ArrayList<>();
        this.storeNumber = storeNumber;

        for (int i = 0; i < storeNumber; i++) {
            this.storeList.add(new Store());
        }
    }

    public Store getStore(int item) {
        if (item >= 0 && item < storeNumber) {
            return this.storeList.get(item);
        } else {
            return null;
        }
    }
}
