package com.nhnacademy.yunhwa.Exercise5_2;

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
    private double max;
    private double min;

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        if (count == 0) {
            max = num;
            min = num;
        }

        count++;
        sum += num;
        squareSum += num * num;

        if(num > max) {
            max = num;
        } else if (num < min) {
            min = num;
        }
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;
    }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() { // E(pow(x,2)) - pow(mean,2)
        double mean = getMean();
        return Math.sqrt( squareSum / count - mean * mean );
    }

    @Override
    public String toString() {

        return "데이터 세트 항목수  : "
                + this.getCount() + "\n"
                + "데이터 세트 총 합계 : "
                + String.format("%.2f", this.getSum())  + "\n"
                + "데이터 세트 최댓값  : "
                + String.format("%.2f", this.getMax())  + "\n"
                + "데이터 세트 최솟값  : "
                + String.format("%.2f", this.getMin())  + "\n"
                + "데이터 세트 평균값  : "
                + String.format("%.2f", this.getMean())  + "\n"
                + "데이터 세트 표준편차: "
                + String.format("%.2f", this.getStandardDeviation()) + "\n";
    }

}  // end class StatCalc