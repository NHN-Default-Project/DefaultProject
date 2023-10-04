package com.nhnacademy.parkminsu.exercise8_1;

public class QuadraticEquation {
    private int quadraticCoefficient;
    private int linearTermCoefficient;
    private int constant;

    public QuadraticEquation() {
        this.quadraticCoefficient = 0;
        this.linearTermCoefficient = 0;
        this.constant = 0;
    }

    public void enterCoefficient(int quadraticCoefficient, int linearTermCoefficient, int constant) {
        this.quadraticCoefficient = quadraticCoefficient;
        this.linearTermCoefficient = linearTermCoefficient;
        this.constant = constant;
    }

    public int getQuadraticCoefficient() {
        return quadraticCoefficient;
    }

    public int getLinearTermCoefficient() {
        return linearTermCoefficient;
    }

    public int getConstant() {
        return constant;
    }
}
