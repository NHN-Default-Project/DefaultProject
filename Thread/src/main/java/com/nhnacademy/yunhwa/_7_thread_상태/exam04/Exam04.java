package com.nhnacademy.yunhwa._7_thread_상태.exam04;


public class Exam04 {
    public static void main(String[] args) {
        // thread class 를 이용해 1초에 1씩 증가하여 10까지 증가하는 counter object 를 생성한다.
        RunnableCounter counter = new RunnableCounter("counter", 10);

        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();
        System.out.println(state);

        while (waitingCounter.isAlive()) {
            if (state != waitingCounter.getThread().getState()) {
                state = waitingCounter.getThread().getState();
                System.out.println(state);
            }
        }
    }
}
