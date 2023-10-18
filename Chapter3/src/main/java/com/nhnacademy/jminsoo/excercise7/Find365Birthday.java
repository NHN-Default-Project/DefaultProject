package com.nhnacademy.jminsoo.excercise7;

public class Find365Birthday {
    private boolean[] used;
    private int peopleCount;

    private final int DAYS = 365;

    public Find365Birthday() {
        this.used = new boolean[DAYS];
        this.peopleCount = 0;
        calculate();
    }

    private void calculate() {
        int count = 0;
        while (true) {
            int birthday = (int) (Math.random() * DAYS);
            peopleCount++;

            if (used[birthday]) {
                continue;
            } else {
                count++;
                used[birthday] = true;
            }

            if (count == 365) {
                break;
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("1일~365일 각각마다 생일이 있는 사람을 찾는데에");
        sb.append(this.peopleCount);
        sb.append("명을 찾았습니다.");

        return sb.toString();
    }

}
