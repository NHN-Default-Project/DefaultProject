package com.nhnacademy.gaeun.assignment01;
import java.util.ArrayList;
import java.util.List;

public class FoodStand {
    private List<Store> productList;

    public FoodStand() {
        this.productList = new ArrayList<>();
    }


    public List<Store> getFoodsList() {
        return this.productList;
    }

    public void add(Store product, int amount) {
        if(productList.contains(product)) {
            product.add(amount);
        } else {
            productList.add(product);
        }
    }

    public void sell(Store product, int amount) { //상품 판매
        if(productList.contains(product)) {
            product.sell(amount);
        } else {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }
    }
}
