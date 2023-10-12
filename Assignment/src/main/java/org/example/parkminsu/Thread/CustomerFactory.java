package org.example.parkminsu.Thread;

public class CustomerFactory extends Thread {

    private WaitingList waitingList;

    public CustomerFactory(WaitingList waitingList) {
        this.waitingList = waitingList;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                if (waitingList.getWaiting().size() <= 50) {
                    waitingList.add();
                }
                Thread.sleep(900);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
