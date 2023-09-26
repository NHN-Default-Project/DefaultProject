package org.example.gaeun.thread;

import java.util.Queue;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Desk implements Runnable {
    Queue<Integer> queue;
    Thread thread;
    Random random = new Random();
    static int count = 0;
    final int executeTime = 1000; //업무처리속도

    public String getDeskName() {
        return deskName;
    }

    final String deskName;

    public Desk(String deskName, Queue<Integer> queue) {
        this.deskName = deskName;
        this.queue = queue;
    }

    public synchronized void run() {
        System.out.println("queue size: " + queue.size());
        while (true) {
            if (queue.size() == 0) {
                System.out.println(getDeskName() + ": is waiting for customer");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                count++;
                System.out.printf("%s: starting service to customer No. %d\n", getDeskName(), count);
                queue.poll();
                try {
                    sleep(executeTime + random.nextInt(100)); //왜 final로 안 하면 에러가 날까?
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s: finish server of customer No. %d\n", getDeskName(), count);
                System.out.println(getDeskName() + ": waiting for service...");
            }
        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }
}
