package com.nhnacademy.jminsoo.exercise7;

public class FindDifferentBirthday {
    private boolean[] used;
    private int count;

    private int targetPeople;

    private final int DAYS = 365;

    public FindDifferentBirthday(int targetPeople) {
        this.used = new boolean[targetPeople];
        this.count = 0;
        this.targetPeople = targetPeople;
        calculate();
    }

    private void calculate() {
        for (int i = 0; i < targetPeople; i++) {

            int birthday = (int) (Math.random() * DAYS);

            // System.out.printf("Person %d has birthday number %d%n", count, birthday);

            if (!used[birthday]) {
                this.count++;
                used[birthday] = true;
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.targetPeople);
        sb.append("명 중에 다른 생일의 개수는");
        sb.append(this.count);
        sb.append("개 입니다.");
        return sb.toString();
    }
}
