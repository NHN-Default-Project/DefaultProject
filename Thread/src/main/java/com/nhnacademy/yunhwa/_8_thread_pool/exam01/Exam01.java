package com.nhnacademy.yunhwa._8_thread_pool.exam01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam01 {
    public static void main(String[] args) {
        // Thread pool 생성
        ExecutorService executor = Executors.newFixedThreadPool(5); // 크기는 생성될 thread 개수보다 적게 한다.

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker" + i)); // thread pool 에 Worker class 의 object 를 넣는다.
        }

        // 모든 작업이 완료될 때까지 대기
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("모든 작업이 완료되었습니다.");
    }
}
