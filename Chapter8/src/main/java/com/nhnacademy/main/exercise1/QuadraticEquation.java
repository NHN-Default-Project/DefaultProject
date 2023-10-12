package com.nhnacademy.main.exercise1;

/**
 * A*x*x + B*x + C = 0 형태의 이차방정식의 해 중에서 큰 해를 반환합니다.
 * 해가 있는 경우에만 작동하며, A == 0 이거나 판별식인 B*B - 4*A*C 가 음수인 경우
 * IllegalArgumentException 예외가 발생합니다.
 */

public class QuadraticEquation { // 2차 방정식 클래스
    private double quadraticCoefficient; //이차항 계수
    private double linearTermCoefficient; //일차항 계수
    private double constant; //상수항

    public QuadraticEquation(double quadraticCoefficient, double linearTermCoefficient, double constant) {
        enterCoefficient(quadraticCoefficient, linearTermCoefficient, constant);
    }

    public void enterCoefficient(double quadraticCoefficient, double linearTermCoefficient, double constant) {
        this.quadraticCoefficient = quadraticCoefficient;
        this.linearTermCoefficient = linearTermCoefficient;
        this.constant = constant;
    }

    public double root() throws IllegalArgumentException {
        if (this.quadraticCoefficient == 0) {
            throw new IllegalArgumentException("A는 0일 수 없습니다.");
        } else {
            double disc = this.linearTermCoefficient * this.linearTermCoefficient - 4 * this.quadraticCoefficient * this.constant;
            if (disc < 0) {
                throw new IllegalArgumentException("판별식 < 0.");
            }
            return (-this.linearTermCoefficient + Math.sqrt(disc)) / (2 * this.quadraticCoefficient);
        }
    }
}
