package com.nhnacademy.parkminsu.exercise9_3.funcinterface;

@FunctionalInterface
public interface RandomNum<T, R> {
    R apply(T value);

}
