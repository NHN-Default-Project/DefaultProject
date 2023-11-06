package com.nhnacademy.yunhwa._1_thread_class;

public class Counter {
    private int count;
    private final String name;
    private final int maxCount;

    public Counter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count = 0;
    }

    /*
    * 시작 후 1초마다 횟수를 1씩 증가 시킨다.
    * 횟수가 변경될 때마다 이름과 횟수를 출력한다.
    * 주어진 최대 횟수에 도달하면, 동작을 종료한다.
    * */
    public void run() { // Thread 클래스에서 실행 코드는 run() 에 정의되어야 한다.
        while (count < this.maxCount) {
            try {
                Thread.sleep(1000);
                count++;
                System.out.println(this.name + "'s count : " + count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    } // run()
}
