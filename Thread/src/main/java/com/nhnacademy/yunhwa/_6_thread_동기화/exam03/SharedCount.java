package com.nhnacademy.yunhwa._6_thread_동기화.exam03;

public class SharedCount {
    private static int count; // shared count 를 static variable 로 선언하여 instance 와 관계 없이 접근 가능하게 만듦.

    public static int getCount() {
        return count;
    }

    public static synchronized void increment() {
        count++; // shared count 를 수정할 수 있도록 increment() 도 static method 로 정의.
    }
}
