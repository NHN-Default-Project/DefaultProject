package parkminsu.privatestudy.thread.assignment;

import parkminsu.privatestudy.thread.assignment.exception.NegativeNumException;

public class Mart {
    private Store[] store;
    private int storeNum;

    public Mart(int storeNum) throws NegativeNumException {
        isCheckNegativeNum(storeNum);
        this.storeNum = storeNum;
        initStore();
    }

    private void initStore() {
        this.store = new Store[this.storeNum];
        String str = "store";
        for (int i = 0; i < store.length; i++) {
            this.store[i] = new Store(str + i);
        }
    }

    private void isCheckNegativeNum(int num) throws NegativeNumException {
        if (isNegativeNum(num)) {
            throw new NegativeNumException("음수를 입력하셨습니다");
        }
    }

    private boolean isNegativeNum(int num) {
        return num < 0;
    }

    public Store[] getStore() {
        return store;
    }

    public void enterStore(int buyItemStore) {
        System.out.println(buyItemStore + "번 째 마트에 입장했습니다");
        store[buyItemStore].enter();
    }

    public void sellStoreItem(int buyItemStore) {
        store[buyItemStore].sell();
    }

    public void exitStore(int storeNum) {
        store[storeNum].exit();
    }

    public void buyStore(int storeNum) {
        System.out.println("공급자가 " + storeNum + "매장에 들어갔습니다");
        store[storeNum].buy();
    }
}
