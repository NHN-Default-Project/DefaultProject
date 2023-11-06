package com.nhnacademy.yunhwa._2_runnable_interface.exam03;

import com.nhnacademy.thread.src.bootcamp._2_runnable_interface.quiz01.RunnableCounter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1); // ExecutorService 를 이용해 thread pool 을 생성한다. 이때, pool의 크기는 1로 한다.
        pool.execute(new RunnableCounter("counter1", 5)); // Thread pool 에 RunnableCounter instance 를 생성해 넘기고 실행하도록 한다.
        pool.execute(new RunnableCounter("counter2", 5));

        pool.shutdown();
        System.out.println("Shutdown called");
        while (! pool.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Not yet finished");
        }
        System.out.println("All service finished");
    }
}
