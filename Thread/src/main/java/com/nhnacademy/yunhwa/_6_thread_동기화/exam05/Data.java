package com.nhnacademy.yunhwa._6_thread_동기화.exam05;

public class Data {
    private String packet;

    // 참이면 sender가 아직 데이터를 안보낸 것. 이동을 아직 안한 것.
    private boolean notTransfer = true; // True if receiver should wait  // False if sender should wait

    public synchronized void send(String packet) { // 보낸다
        while (!notTransfer) { // 전송이 완료된 상태라면
            try {
                wait(); // sender 가 waiting 상태에 들어간다. receiver 가 데이터를 받을 때까지 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        } // wait 가 다 끝났으면.
        notTransfer = false; // 전송이 다 되었다고 초기화시킴.

        this.packet = packet;
        notifyAll(); // receiver 에게 전송 완료를 알림
    }

    public synchronized String receive() { // 받는다
        while (notTransfer) { // 전송이 완료되지 않은 상태라면
            try {
                wait(); // receiver 이 waiting 상태에 들어간다. sender 가 데이터를 보낼 때까지 대기
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        } // 전송 완료됨.
        notTransfer = true; // 한 턴이 끝났으니, 다음을 위해 전송 아직 완료되지 않았다고 초기화 시킴.

        String returnPacket = packet;
        notifyAll(); // sender 에게 수신 완료를 알림.

        return returnPacket;
    }







}
