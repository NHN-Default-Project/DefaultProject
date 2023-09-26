package org.example.yunhwa.bankWindow;

import java.util.Queue;

public class CustomerFactory extends Thread {
    private int customerNumber;
    private final int entryInterval;
    public  WaitingList waitingList;

    public CustomerFactory(int entryInterval) {
        this.customerNumber = 0; // 지금까지 생성된 손님수
        this.entryInterval = entryInterval; // 손님이 들어오는 주기
        this.waitingList = new WaitingList(); // 손님 대기 리스트 초기화
    }

    // 손님 한 명 생성할 때마다 총 생성된 손님수 증가시키는 메서드
    public void addCustomerNumber() {
        this.customerNumber++;
    }

    // 손님 한 명 생성해서 손님 리턴하는 메서드
    public Customer makeCustomer() {
        addCustomerNumber();
        return new Customer(this.customerNumber);
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this.waitingList) {
                    if (waitingList.getSize()  <= 20) {
                        this.waitingList.add(makeCustomer());
                        System.out.printf("%d 번 고객님이 대기 리스트에 들어왔습니다. %n", this.customerNumber);
                        System.out.printf("현재 대기 고객수 : %d %n", waitingList.getSize());
                    }
                }
                Thread.sleep(entryInterval + (int) (Math.random() * 500));

            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}