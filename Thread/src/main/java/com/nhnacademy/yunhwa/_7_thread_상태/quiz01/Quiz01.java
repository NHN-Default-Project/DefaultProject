package com.nhnacademy.yunhwa._7_thread_상태.quiz01;

public class Quiz01 {
    public static void main(String[] args) {
        Ticker ticker1 = new Ticker("10000n");
        Ticker ticker2 = new Ticker("20000");

        ticker1.start();
        ticker2.start();

        ticker1.interrupt();
    }
}
