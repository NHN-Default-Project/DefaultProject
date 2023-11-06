package com.nhnacademy.yunhwa._6_thread_동기화.exam05;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    Data data;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (String receivedMessage = data.receive(); !"End".equals(receivedMessage); receivedMessage = data.receive()) {

            System.out.println(receivedMessage);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
    }
}
