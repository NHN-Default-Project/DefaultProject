package com.nhnacademy.parkminsu.exam;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store();
        String name = "손님";
        int loop = 1;
        Proceducer proceducer = new Proceducer(store);
        proceducer.start();

        while (true) {
            Consumer consumer = new Consumer(name + loop, store);


            consumer.start();
            loop += 1;
            Thread.sleep(1500);
            //Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));


        }
    }
}
