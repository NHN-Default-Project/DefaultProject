package com.nhnacademy.gaeun.assignment01;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodStand {
    private List<Product> productList;

    public FoodStand() {
        this.productList = new ArrayList<>();
    }


    public List<Product> getFoodsList() {
        return this.productList;
    }

    public void add(Product product, int amount) {
        if(productList.contains(product)) {
            product.add(amount);
        } else {
            productList.add(product);
        }
    }

    public void sell(Product product, int amount) { //상품 판매
        if(productList.contains(product)) {
            product.sell(amount);
        } else {
            throw new IllegalArgumentException("해당 상품이 존재하지 않습니다.");
        }
    }
}
