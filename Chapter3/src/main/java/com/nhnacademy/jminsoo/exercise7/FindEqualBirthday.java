package com.nhnacademy.jminsoo.exercise7;

class FindEqualBirthday {
    private int[] used;
    private int count;
    private int targetPeople;

    private final int DAYS = 365;

    private FindEqualBirthday() {

    }

    public FindEqualBirthday(int targetPeople) {
        this.targetPeople = targetPeople;
        this.used = new int[DAYS];
        this.count = 0;
        calculate();
    }

    private void calculate() {
        while (true) {

            int birthday = (int) (Math.random() * DAYS);
            count++;

            // System.out.printf("Person %d has birthday number %d%n", count, birthday);

            if (used[birthday] == targetPeople) {
                break;
            }

            used[birthday] += 1;

        } // end while
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("같은 생일을 가진 사람 ");
        sb.append(targetPeople);
        sb.append("명 찾는데에 ");
        sb.append(this.count);
        sb.append("번이 걸렸습니다.");
        return sb.toString();
    }

    public int getCount() {
        return this.count;
    }

}