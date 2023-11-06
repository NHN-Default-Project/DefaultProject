package com.nhnacademy.yunhwa._6_thread_동기화.exam01;

public class SharedCount {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        setCount(getCount() + 1);
    }
}
