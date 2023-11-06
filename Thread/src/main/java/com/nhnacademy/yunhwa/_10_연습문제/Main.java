package com.nhnacademy.yunhwa._10_연습문제;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Thread producer1 = new Thread(new Producer(store), "producer1");
        Thread producer2 = new Thread(new Producer(store), "producer2");
        Thread producer3 = new Thread(new Producer(store), "producer3");
        Thread producer4 = new Thread(new Producer(store), "producer4");
        Thread producer5 = new Thread(new Producer(store), "producer5");
        Thread producer6 = new Thread(new Producer(store), "producer6");
        Thread producer7 = new Thread(new Producer(store), "producer7");

        Thread consumer1 = new Thread(new Consumer("consumer1", store), "consumer1");
        Thread consumer2 = new Thread(new Consumer("consumer2", store), "consumer2");
        Thread consumer3 = new Thread(new Consumer("consumer3", store), "consumer3");
        Thread consumer4 = new Thread(new Consumer("consumer4", store), "consumer4");
        Thread consumer5 = new Thread(new Consumer("consumer5", store), "consumer5");
        Thread consumer6 = new Thread(new Consumer("consumer6", store), "consumer6");
        Thread consumer7 = new Thread(new Consumer("consumer7", store), "consumer7");
        Thread consumer8 = new Thread(new Consumer("consumer8", store), "consumer8");


        producer1.start();
        consumer1.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        producer2.start();
        consumer2.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        consumer3.start();
        producer3.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        producer4.start();
        consumer4.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        consumer5.start();
        producer5.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        producer6.start();
        consumer6.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        consumer7.start();
        producer7.start();

        try {
            Thread.sleep(1000 * 2);
        } catch (InterruptedException ignore) {
        }

        consumer8.start();





        System.out.println("메인 쓰레드에서 10초 대기 들어갑니다.");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException ignore) {
        }

        consumer1.interrupt();
        producer1.interrupt();

        System.out.println("메인 쓰레드에서 3초 대기 들어갑니다.");
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException ignore) {
        }

        consumer2.interrupt();
        producer4.interrupt();
        consumer3.interrupt();
        producer2.interrupt();

        System.out.println("메인 쓰레드에서 10초 대기 들어갑니다.");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException ignore) {
        }

        consumer4.interrupt();
        producer3.interrupt();

        System.out.println("메인 쓰레드에서 10초 대기 들어갑니다.");
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException ignore) {
        }
        consumer5.interrupt();
        producer5.interrupt();

        consumer6.interrupt();
        producer6.interrupt();

        producer7.interrupt();
        consumer7.interrupt();
        consumer8.interrupt();
    }
}
