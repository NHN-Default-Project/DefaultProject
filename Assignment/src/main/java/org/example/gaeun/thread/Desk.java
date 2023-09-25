package org.example.gaeun.thread;

import java.util.Queue;
import java.util.Random;

public class Desk extends Thread {
    Queue<Integer> queue;
    Random random = new Random();
    static int count = 0;
    final int executeTime = 1000; //업무처리속도

    public Desk(String deskName, Queue<Integer> queue) {
        super(deskName);
        this.queue = queue;
    }

    public synchronized void run() {
        System.out.println("queue size: " + queue.size());
        while (true) {
            if (queue.size() == 0) {
                System.out.println(this.getName() + ": is waiting for customer");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                count++;
                System.out.printf("%s: starting service to customer No. %d\n", this.getName(), count);
                queue.poll();
                try {
                    Thread.sleep(executeTime + random.nextInt(100)); //왜 final로 안 하면 에러가 날까?
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s: finish server of customer No. %d\n", this.getName(), count);
                System.out.println(this.getName() + ": waiting for service...");
            }
        }
    }

}
