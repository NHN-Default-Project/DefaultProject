package parkminsu.privatestudy.thread.assignment;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * N개의 품목을 납품할 수 있음
 */
public class Producer implements Runnable {
    private Mart mart;
    Thread thread;
    private int productItem;

    public Producer(Mart mart) {
        this.mart = mart;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                produceGood();
                Thread.sleep(ThreadLocalRandom.current().nextInt(1_000, 10_000));
                mart.buyStore(productItem);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }

    public void produceGood() {
        Random random = new Random();
        this.productItem = random.nextInt(mart.getStore().length);
    }
}
