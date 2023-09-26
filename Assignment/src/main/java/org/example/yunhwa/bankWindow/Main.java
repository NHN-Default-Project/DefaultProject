package org.example.yunhwa.bankWindow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int deskCount = 5;

        List<Desk> desks = new ArrayList<>();
//        Queue<Customer> waitingList = new LinkedList<>();
        CustomerFactory customerFactory = new CustomerFactory((int) Duration.ofSeconds(7).toMillis());

        int[] choosenProcessingTimes = {700, 800, 1000, 1100, 1200, 1300, 1400, 1500};
        int randomIndex = (int) (Math.random() * 8);

        for (int i = 0; i < deskCount; i++) {
            desks.add(new Desk(choosenProcessingTimes[randomIndex], customerFactory.waitingList));
        }

        for (int i = 0; i < desks.size(); i++) {
            if (i == 1) {
                customerFactory.start();
            }
            desks.get(i).start();
        }
    }
}