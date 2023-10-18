package com.nhnacademy.main.exercise9_1;

@FunctionalInterface
public interface Precondition<T extends Comparable> {


    void precondition(T data);
}
