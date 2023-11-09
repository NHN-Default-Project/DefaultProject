package com.nhnacademy.gaeun.assignment01;
public class Store {

    private String name;
    private int amount;
    private static final int MAX_NUM = 30;

    public Store() {
        this.name = "";
        this.amount = 0;
    }
    public Store(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    public String getName() {
        return name;
    }

    public synchronized boolean isAbleBuy(int amount) {
        if (this.amount + amount > MAX_NUM) {
            System.out.println(this.name + "의 재고는 30개까지만 가능합니다.");
            return false;
        }
        return true;
    }

    public synchronized boolean isAbleSell(int amount) {
        return (this.amount - amount >= 0);
    }

    public synchronized void add(int amount) {
        if (isAbleBuy(amount)) {
            this.amount += amount;
            System.out.printf("%s %d개가 가판대에 추가 되었습니다.\n", this.name, amount);
            notifyAll();
        }
    }

    public synchronized void sell(int amount) { //상품 판매
        while (!isAbleSell(amount)) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if(isAbleSell(amount)) {
            this.amount -= amount;
            System.out.printf("%s %d개 구매 완료.\n", this.name, amount);
            System.out.printf("남은 %s의 수량: %d\n", this.name, this.amount);
            notifyAll();
        }
    }
}
