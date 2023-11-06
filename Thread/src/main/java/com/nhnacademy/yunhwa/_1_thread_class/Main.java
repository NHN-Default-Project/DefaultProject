package com.nhnacademy.yunhwa._1_thread_class;

public class Main {
    public static void main(String[] args) {
        // main 쓰레드에서 순차적으로 적용
//        Counter counter1 = new Counter("counter1", 10);
//        Counter counter2 = new Counter("counter2", 10);
//        counter1.run();
//        counter2.run();

//        ThreadCounter threadCounter1 = new ThreadCounter("threadCounter1", 10);
//        ThreadCounter threadCounter2 = new ThreadCounter("threadCounter2", 10);
//        threadCounter1.run();
//        threadCounter2.run();

        // 별도의 쓰레드에서 수행하도록 만들기
        ThreadCounter threadCounter3 = new ThreadCounter("threadCounter3", 10);
        ThreadCounter threadCounter4 = new ThreadCounter("threadCounter4", 10);
        threadCounter3.start();
        threadCounter4.start();
    }
}
