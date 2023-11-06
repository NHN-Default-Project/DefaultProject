package com.nhnacademy.yunhwa._7_thread_상태.exam03;

public class SharedCount {
    private int count = 0;

    public int getCount() {
        return this.count;
    }

    public synchronized void increment() { // 공유 자원인 count 를 변경 시 하나의 Thread 만 접근 가능하도록 처리
        count++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignore) {
        }
    }
}
