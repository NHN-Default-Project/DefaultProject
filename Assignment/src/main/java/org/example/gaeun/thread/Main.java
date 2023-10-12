package org.example.gaeun.thread;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        CustomerFactory customerFactory = new CustomerFactory(queue);
        Desk desk1 = new Desk("desk1", queue);//desk1생성
        Desk desk2 = new Desk("desk2", queue);
        Desk desk3 = new Desk("desk3", queue);


        customerFactory.start();
        desk1.start();
        desk2.start();
        desk3.start();
    }
}
