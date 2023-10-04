package org.example.jaehyeon.design_program;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("checkstyle:MissingJavadocType")
public class MaxGCD {

    private final Combination combination;
    private final List<Gcd> gcdList;
    private int gcdMax;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public MaxGCD(int[] numbers, int r) {
        this.combination = new Combination(numbers, r);
        gcdList = new ArrayList<>();
        setGcdList();
        compareGcdMax();
    }

    public int getGcdMax() {
        return gcdMax;
    }

    private void compareGcdMax() {
        int max = 0;
        for (Gcd gcd : this.gcdList) {
            int getGcd = gcd.getGcd();
            if (max < getGcd) {
                max = getGcd;
            }
        }
        this.gcdMax = max;
    }

    private void setGcdList() {
        for (int[] a : combination.getCombiList()) {
            this.gcdList.add(new Gcd(a));
        }
    }

}
