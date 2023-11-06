package com.nhnacademy.yunhwa._2_runnable_interface.exam02;

public class Exam02 {
    public static void main(String[] args) {
        SelfRunnableCounter selfRunnableCounter = new SelfRunnableCounter("counter", 5);

        selfRunnableCounter.start();
    }
}
