package com.nhnacademy.yunhwa._7_thread_상태.quiz01;


public class Ticker extends Thread {

    private long interval;

    public Ticker(String intervalTmp) {
        if (intervalTmp.substring(intervalTmp.length() -1).equals("n")) {
            this.interval = Long.parseLong(intervalTmp.substring(0, intervalTmp.length() -1)) / 1000000; // nanoseconds to milliseconds
        } else {
            this.interval = Long.parseLong(intervalTmp);
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("tick");
            Thread.sleep(interval);
            System.out.println("tick end");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
