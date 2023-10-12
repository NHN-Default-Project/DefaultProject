package com.nhnacademy.jminsoo.exercise6;

import java.util.ArrayList;
import java.util.List;

public class MaxDivisor {
    private int inputNumber;

    private List<Integer> maxNumberList;
    private int maxNum;
    private int maxCount;

    public MaxDivisor(int inputNumber) {
        this.inputNumber = inputNumber;
        this.maxNum = 0;
        this.maxCount = 0;
        this.maxNumberList = new ArrayList<>();

        this.calMaxDivisor();

    }

    public void calMaxDivisor() {
        int divisorCount = 0;

        for (int num = 1; num <= inputNumber; num++) {

            for (int divisor = 1; divisor * divisor <= num; divisor++) {
                if (divisor * divisor == num) {
                    divisorCount++;
                } else if (num % divisor == 0) {
                    divisorCount += 2;
                }
            }

            if (divisorCount > this.maxCount) {
                this.maxNumberList.clear();
                this.maxNumberList.add(num);
                this.maxNum = num;
                this.maxCount = divisorCount;
            } else if (divisorCount == maxCount) {
                maxNumberList.add(num);
            }
            divisorCount = 0;

        }
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public List<Integer> getMaxNumberList() {
        return this.maxNumberList;
    }

    public void printMaxNumberList() {
        System.out.printf("%d개를 갖고있는 숫자들\n", this.maxCount);
        for (int maxNumber : maxNumberList) {
            System.out.println(maxNumber);
        }
    }
}
