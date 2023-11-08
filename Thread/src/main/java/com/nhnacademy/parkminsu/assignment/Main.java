package com.nhnacademy.parkminsu.assignment;


import com.nhnacademy.parkminsu.assignment.exception.NegativeNumException;

import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {
        try {
            Mart mart = new Mart(5);
            String name = "손님";
            int loop = 1;

            Producer producer = new Producer(mart);
            producer.start();

            while (true) {
                Consumer consumer = new Consumer(mart, name + loop);
                consumer.start();
                loop += 1;
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
            }
        } catch (NegativeNumException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
