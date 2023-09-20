package com.nhnacademy.Jminsoo.excercise2;

/**
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

public class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private double maxNum;
    private double minNum;

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        this.count++;
        this.sum += num;
        this.squareSum += num * num;
        this.maxNum = Math.max(num, this.maxNum);

        if (count == 1) {
            this.minNum = num;
        } else {
            this.minNum = Math.min(num, this.minNum);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("넣은 개수 : %d\n", this.getCount()));
        sb.append(String.format("평균 : %.2f\n", this.getMean()));
        sb.append(String.format("합계 : %.2f\n", this.getSum()));
        sb.append(String.format("표준편차 : %.2f\n", this.getStandardDeviation()));
        sb.append(String.format("최대값 : %.2f\n", this.getMax()));
        sb.append(String.format("최소값 : %.2f\n", this.getMin()));

        return sb.toString();
    }

    public double getMax() {
        return this.maxNum;
    }

    public double getMin() {
        return this.minNum;
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return this.sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        if (this.count == 0) {
            throw new ArithmeticException("숫자 집합의 개수가 0입니다!");
        }
        return this.sum / this.count;
    }

    public double getStandardDeviation() {
        if (this.count == 0) {
            throw new ArithmeticException("숫자 집합의 개수가 0입니다!");
        }
        double mean = getMean();
        return Math.sqrt(this.squareSum / this.count - mean * mean);
    }


}  // end class StatCalc