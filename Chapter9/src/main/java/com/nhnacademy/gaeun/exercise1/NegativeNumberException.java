package com.nhnacademy.gaeun.exercise1;

public class NegativeNumberException extends Exception{
    public NegativeNumberException() {
        super("0보다 큰 값을 입력해주세요!!");
    }
}
