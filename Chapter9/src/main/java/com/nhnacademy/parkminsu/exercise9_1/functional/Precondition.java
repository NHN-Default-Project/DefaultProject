package com.nhnacademy.parkminsu.exercise9_1.functional;

@FunctionalInterface
public interface Precondition<T extends Comparable> {


    void precondition(T data);
}
