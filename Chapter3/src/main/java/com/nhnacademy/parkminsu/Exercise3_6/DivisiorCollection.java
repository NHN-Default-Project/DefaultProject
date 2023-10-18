package com.nhnacademy.parkminsu.Exercise3_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisiorCollection {
    // private Set<Divisor> list;
    private final Map<Integer, List<Divisor>> number; // 모든 숫자들의 약수를 담은 리스트
    private final Map<Integer, List<Divisor>> manyDivisorNum; // 가장 많은 약수를 가진 숫자를 담은 리스트
    private final Map<Integer, List<Divisor>> fewerDivisorNum; // 가장 적은 약수를 가진 숫자를 담은 리스트

    private int minValue;
    private int maxValue;
    private int beginNum;
    private int endNum;

    public DivisiorCollection(int beginNum, int endNum) {
        if (beginNum <= 0 || endNum <= 0) {
            throw new IllegalArgumentException("bigin Num < 0 or endNum <0");
        } else if (endNum > Integer.MAX_VALUE || beginNum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Integer range over");
        }
        if (beginNum > endNum) {
            this.beginNum = endNum;
            this.endNum = beginNum;
        } else {
            this.beginNum = beginNum;
            this.endNum = endNum;
        }
        this.maxValue = 0;
        this.minValue = Integer.MAX_VALUE;
        this.number = new HashMap<>();
        this.manyDivisorNum = new HashMap<>();
        this.fewerDivisorNum = new HashMap<>();
    }

    public void addList(int num) {
        this.number.put(num, addDivisiorList(num));
    }

    public List<Divisor> addDivisiorList(int num) { //
        List<Divisor> divisorList = new ArrayList<>();
        for (int divisibleNum = 1; divisibleNum <= num; divisibleNum++) {
            if (num % divisibleNum == 0) {
                divisorList.add(new Divisor(divisibleNum));

            }
        }

        return divisorList;
    }

    public void addNumber() {
        for (int currentNum = getBeginNum(); currentNum <= getEndNum(); currentNum++) {
            addList(currentNum);
        }
        for (Map.Entry<Integer, List<Divisor>> num : this.number.entrySet()) {
            if (this.maxValue < num.getValue().size()) {
                this.maxValue = num.getValue().size();
            }
            if (this.minValue > num.getValue().size()) {
                this.minValue = num.getValue().size();
            }
        }
    }

    public void numManyFewerDivisors() {
        for (Map.Entry<Integer, List<Divisor>> num : this.number.entrySet()) {
            if (this.maxValue == num.getValue().size()) {
                this.manyDivisorNum.put(num.getKey(), num.getValue());
            }
            if (this.minValue == num.getValue().size()) {
                this.fewerDivisorNum.put(num.getKey(), num.getValue());
            }
        }
    }

    public int numManyDivisors() {
        int maxNum = 0;
        for (Map.Entry<Integer, List<Divisor>> num : this.getManyDivisorNum().entrySet()) {
            if (maxNum < num.getKey()) {
                maxNum = num.getKey();
            }
        }
        return maxNum;
    }

    public void execution(int classsificationNum) {
        this.addNumber(); // number
        this.numManyFewerDivisors();
        if (classsificationNum == 1) {
            System.out.printf("약수가 가장 많은 수 : %d,\n약수의 갯수: %d ", numManyDivisors(), this.getMaxValue());

        } else {
            System.out.printf("%d과 %d 사이의 정수 중에서,\n약수의 최대 갯수는 %d\n이러한 약수의 갯수를 가진 숫자들은:\n", this.getBeginNum(),
                    this.getEndNum(), this.getMaxValue());
            for (Map.Entry<Integer, List<Divisor>> printNum : this.getManyDivisorNum().entrySet()) {
                System.out.println(printNum.getKey());
            }
        }
    }

    public Map<Integer, List<Divisor>> getManyDivisorNum() {
        return manyDivisorNum;
    }

    public Map<Integer, List<Divisor>> getFewerDivisorNum() {
        return fewerDivisorNum;
    }

    public String toString() {
        return "" + number;
    }

    public int getBeginNum() {
        return this.beginNum;
    }

    public int getEndNum() {
        return this.endNum;
    }

    public Map<Integer, List<Divisor>> getNumber() {
        return number;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public static class Divisor {
        private int divisorNum;
        private int[] divisor;

        Divisor(int divisoreNum) {
            // 약수 구해서 내 약수리스트
            this.divisorNum = divisoreNum;
        }

        public String toString() {
            return "" + divisorNum;
        }

        public int getDivisorNum() {
            return divisorNum;
        }
    }
}


